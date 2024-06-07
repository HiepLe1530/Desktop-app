/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.DichVu;
import Model.PhieuThue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sun.tools.asm.TryData;

/**
 *
 * @author Administrator
 */
public class DichVuDAO {
    private Connection conn;
    
   
    public DichVuDAO() {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002"); 
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    public boolean addDichVu(DichVu dv){
        String sql = "insert into tblDichVu(DV_MaDV, DV_TenDV, DV_DonGia) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dv.getMaDV());
            ps.setString(2, dv.getTenDV());
            ps.setLong(3, dv.getDonGia());
           
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<DichVu> getListDichVu(){
        ArrayList<DichVu> listDV = new ArrayList<>();
        String sql = "SELECT * FROM tblDichVu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DichVu dv = new DichVu();
                dv.setMaDV(rs.getString("DV_MaDV"));
                dv.setTenDV(rs.getString("DV_TenDV"));
                dv.setDonGia(rs.getLong("DV_DonGia"));
               
                listDV.add(dv);
            }
        } catch (SQLException e) {
        }
        return listDV;
    }
    
    public boolean updateDV(DichVu dv){
        String sql = "update tblDichvu " +
                    "set DV_TenDV = N'"+dv.getTenDV()+"', DV_DonGia = "+dv.getDonGia()+" " +
                    "where DV_MaDV = '"+dv.getMaDV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean xoaDV(DichVu dv){
        String sql = "delete from tblDichVu where DV_MaDV = '"+dv.getMaDV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public ArrayList<DichVu> getListDichVu(String s){
        ArrayList<DichVu> listDV = new ArrayList<>();
        String sql = "select DV_MaDV, DV_TenDV, DV_DonGia " +
                    "from (select * from (tblPhong inner join tblPhieuDV on P_MaP = PDV_P_MaP) inner join tblDichVu on PDV_DV_MaDV = DV_MaDV) b1 " +
                    "where P_MaP = "+s+" and PDV_TrangThai = N'chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DichVu dv = new DichVu();
                dv.setMaDV(rs.getString("DV_MaDV"));
                dv.setTenDV(rs.getString("DV_TenDV"));
                dv.setDonGia(rs.getLong("DV_DonGia"));
               
                listDV.add(dv);
            }
        } catch (SQLException e) {
        }
        return listDV;
    }
}
