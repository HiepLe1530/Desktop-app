/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.PhieuDangKy;
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
public class PhieuDangKyDAO {
    private Connection conn;
   
    public PhieuDangKyDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public boolean addPhieuDangKy(PhieuDangKy pdk){
        String sql = "INSERT INTO tblPhieuDangKy(PDK_MaPDK, PDK_KH_MaKH, PDK_P_MaP, PDK_TienCoc, PDK_Checkin, PDK_Checkout, PDK_NgayDK)"
                +"VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pdk.getMaPDK());
            ps.setString(2, pdk.getMaKH());
            ps.setInt(3, pdk.getMaP());
            ps.setLong(4, pdk.getTienCoc());
            ps.setDate(5,  new java.sql.Date(pdk.getCheck_in().getTime()));
            ps.setDate(6, new java.sql.Date(pdk.getCheck_out().getTime()));
            ps.setDate(7, new java.sql.Date(pdk.getNgayDK().getTime()));
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<PhieuDangKy> getListPhieuDangKy(){
        ArrayList<PhieuDangKy> listPDK = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuDangKy";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDangKy pdk = new PhieuDangKy();
                pdk.setMaPDK(rs.getString("PDK_MaPDK"));
                pdk.setMaKH(rs.getString("PDK_KH_MaKH"));
                pdk.setMaP(rs.getInt("PDK_P_MaP"));
                pdk.setTienCoc(rs.getLong("PDK_TienCoc"));
                pdk.setCheck_in(rs.getDate("PDK_Checkin"));
                pdk.setCheck_out(rs.getDate("PDK_Checkout"));
                pdk.setNgayDK(rs.getDate("PDK_NgayDK"));
                listPDK.add(pdk);
            }
        } catch (SQLException e) {
        }
        return listPDK;
    }
    public ArrayList<PhieuDangKy> getListPhieuDangKyTKNgay(String s){
        ArrayList<PhieuDangKy> listPDK = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM tblPhieuDangKy "
                + "WHERE PDK_NgayDK = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDangKy pdk = new PhieuDangKy();
                
                pdk.setMaPDK(rs.getString("PDK_MaPDK"));
                pdk.setMaKH(rs.getString("PDK_KH_MaKH"));
                pdk.setMaP(rs.getInt("PDK_P_MaP"));
                pdk.setTienCoc(rs.getLong("PDK_TienCoc"));
                pdk.setCheck_in(rs.getDate("PDK_Checkin"));
                pdk.setCheck_out(rs.getDate("PDK_Checkout"));
                pdk.setNgayDK(rs.getDate("PDK_NgayDK"));
                
                
                listPDK.add(pdk);
            }
        } catch (SQLException e) {
        }
        return listPDK;
    }
    
    public ArrayList<PhieuDangKy> getListPhieuDangKyTKCCCD(String s){
        ArrayList<PhieuDangKy> listPDK = new ArrayList<>();
        String sql = "SELECT PDK_MaPDK, PDK_KH_MaKH, PDK_P_MaP, PDK_TienCoc, PDK_Checkin, PDK_Checkout, PDK_NgayDK "
                + "FROM tblPhieuDangKy inner join tblKhachHang on PDK_KH_MaKH = KH_MaKH "
                + "WHERE KH_CMND = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDangKy pdk = new PhieuDangKy();
                
                pdk.setMaPDK(rs.getString("PDK_MaPDK"));
                pdk.setMaKH(rs.getString("PDK_KH_MaKH"));
                pdk.setMaP(rs.getInt("PDK_P_MaP"));
                pdk.setTienCoc(rs.getLong("PDK_TienCoc"));
                pdk.setCheck_in(rs.getDate("PDK_Checkin"));
                pdk.setCheck_out(rs.getDate("PDK_Checkout"));
                pdk.setNgayDK(rs.getDate("PDK_NgayDK"));
                
                
                listPDK.add(pdk);
            }
        } catch (SQLException e) {
        }
        return listPDK;
    }
    
    public boolean updatePDK(PhieuDangKy pdk){
        String sql = "update tblPhieuDangKy "
                + "set PDK_P_MaP = "+pdk.getMaP()+ ", PDK_TienCoc = "+pdk.getTienCoc()
                + ", PDK_Checkin = '"+new java.sql.Date(pdk.getCheck_in().getTime())+"'"
                +", PDK_Checkout = '"+new java.sql.Date(pdk.getCheck_out().getTime())+"' "
                + "where PDK_MaPDK = '"+pdk.getMaPDK()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean XoaPDK(PhieuDangKy pdk){
        String sql = "delete from tblPhieuDangKy where PDK_MaPDK = '"+pdk.getMaPDK()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
