/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.DichVu;
import Model.KhachHang;
import Model.PhieuDichVu;
import Model.PhieuThue;
import Model.PhieuTruyVan;
import Model.Phong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuTruyVanDAO {
    private Connection conn;
   
    public PhieuTruyVanDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    
    public ArrayList<PhieuTruyVan> getListPhieuTruyVanTK(String s){
        ArrayList<PhieuTruyVan> listPTV = new ArrayList<>();
        String sql = "select P_MaP, P_TinhTrang, PT_Check_in, PT_Check_out, PDK_Checkin, PDK_Checkout " 
                    + " from ((select *" 
                    + "from (tblPhieuThue inner join tblPhong on PT_P_MaP = P_MaP) left join tblPhieuDangKy on P_MaP = PDK_P_MaP)" 
                    + " union" 
                    + "(select *" 
                    + "from tblPhieuThue right join (tblPhong inner join tblPhieuDangKy on P_MaP = PDK_P_MaP) on PT_P_MaP = P_MaP)) b1 "
                                    + "where PT_Check_out > '"+s+"' or PDK_Checkout > '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuTruyVan ptv = new PhieuTruyVan();
                
                ptv.setMaP(rs.getInt("P_MaP"));
                ptv.setCheck_in(rs.getDate("PDK_Checkin"));
                ptv.setCheck_out(rs.getDate("PDK_Checkout"));
                ptv.setNgay_checkin(rs.getDate("PT_Check_in"));
                ptv.setNgay_checkout(rs.getDate("PT_Check_out"));
                ptv.setTinhTrang(rs.getString("P_TinhTrang"));
                
                
                listPTV.add(ptv);
            }
        } catch (SQLException e) {
        }
        return listPTV;
    }
    //except (select P_MaP from ((select * from (tblPhieuThue inner join tblPhong on PT_P_MaP = P_MaP) left join tblPhieuDangKy on P_MaP = PDK_P_MaP) union (select * from tblPhieuThue right join (tblPhong inner join tblPhieuDangKy on P_MaP = PDK_P_MaP) on PT_P_MaP = P_MaP)) b1 where PT_Check_out > '"+s+"' or PDK_Checkout > '"+s+"')
    public ArrayList<Phong> getListPhieuTruyVanTKTrong(String s){
        ArrayList<Phong> listP = new ArrayList<>();
        String sql = "(select P_MaP from tblPhong) "
                + "except (select P_MaP "
                + "from ((select * "
                + "from (tblPhieuThue inner join tblPhong on PT_P_MaP = P_MaP) left join tblPhieuDangKy on P_MaP = PDK_P_MaP) "
                + "union (select * "
                + "from tblPhieuThue right join (tblPhong inner join tblPhieuDangKy on P_MaP = PDK_P_MaP) on PT_P_MaP = P_MaP)) b1 "
                + "where PT_Check_out > '"+s+"' or PDK_Checkout > '"+s+"')";
                     
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                
                p.setMaP(rs.getInt("P_MaP"));
                
                
                listP.add(p);
            }
        } catch (SQLException e) {
        }
        return listP;
    }
    

    
}
