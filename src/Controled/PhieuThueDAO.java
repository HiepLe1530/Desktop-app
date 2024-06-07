/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.PhieuThue;
import Model.Phong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Administrator
 */
public class PhieuThueDAO {
    private Connection conn;
   
    public PhieuThueDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public boolean addPhieuThue(PhieuThue pt){
        String sql = "INSERT INTO tblPhieuThue(PT_MaPT, PT_KH_MaKH, PT_P_MaP, PT_TienCoc, PT_Check_in, PT_Check_out, PT_TrangThai)"
                +"VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pt.getMaPT());
            ps.setString(2, pt.getMaKH());
            ps.setInt(3, pt.getMaP());
            ps.setLong(4, pt.getTienCoc());
            ps.setDate(5,  new java.sql.Date(pt.getNgay_checkin().getTime()));
            ps.setDate(6, new java.sql.Date(pt.getNgay_checkout().getTime()));
            ps.setString(7, pt.getTrangThai());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<PhieuThue> getListPhieuThue(){
        ArrayList<PhieuThue> listPT = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuThue";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuThue pt = new PhieuThue();
                pt.setMaPT(rs.getString("PT_MaPT"));
                pt.setMaKH(rs.getString("PT_KH_MaKH"));
                pt.setMaP(rs.getInt("PT_P_MaP"));
                pt.setTienCoc(rs.getLong("PT_TienCoc"));
                pt.setNgay_checkin(rs.getDate("PT_Check_in"));
                pt.setNgay_checkout(rs.getDate("PT_Check_out"));
                pt.setTrangThai(rs.getString("PT_TrangThai"));
                listPT.add(pt);
            }
        } catch (SQLException e) {
        }
        return listPT;
    }
    public ArrayList<PhieuThue> getListPhieuThueTKPhong(String s){
        ArrayList<PhieuThue> listPT = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM tblPhieuThue "
                + "WHERE PT_P_MaP = '"+s+"' and PT_TrangThai = N'chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuThue pt = new PhieuThue();
                pt.setMaPT(rs.getString("PT_MaPT"));
                pt.setMaKH(rs.getString("PT_KH_MaKH"));
                pt.setMaP(rs.getInt("PT_P_MaP"));
                pt.setTienCoc(rs.getLong("PT_TienCoc"));
                pt.setNgay_checkin(rs.getDate("PT_Check_in"));
                pt.setNgay_checkout(rs.getDate("PT_Check_out"));
                pt.setTrangThai(rs.getString("PT_TrangThai"));
                listPT.add(pt);
            }
        } catch (SQLException e) {
        }
        return listPT;
    }
    
    public ArrayList<PhieuThue> getListPhieuThue(String s){
        ArrayList<PhieuThue> listPT = new ArrayList<>();
        String sql = "SELECT PT_MaPT, PT_KH_MaKH, PT_P_MaP, PT_TienCoc, PT_Check_in, PT_Check_out "
                + "FROM tblPhieuThue where PT_MaPT = '"+s+"' and PT_TrangThai = N'Chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuThue pt = new PhieuThue();
                pt.setMaPT(rs.getString("PT_MaPT"));
                pt.setMaKH(rs.getString("PT_KH_MaKH"));
                pt.setMaP(rs.getInt("PT_P_MaP"));
                pt.setTienCoc(rs.getLong("PT_TienCoc"));
                pt.setNgay_checkin(rs.getDate("PT_Check_in"));
                pt.setNgay_checkout(rs.getDate("PT_Check_out"));
                listPT.add(pt);
            }
        } catch (SQLException e) {
        }
        return listPT;
    }
    public boolean updateTrangThaiPT(String s){
        String sql = "update tblPhieuThue set PT_TrangThai = N'Đã đóng' "
                + "where PT_MaPT = '"+s+"' and PT_TrangThai = N'Chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean updatePT(PhieuThue pt){
        String sql = "update tblPhieuThue "
                + "set PT_TienCoc = "+pt.getTienCoc()+", PT_Check_in = '"+new java.sql.Date(pt.getNgay_checkin().getTime())+"' "
                +", PT_Check_out = '"+new java.sql.Date(pt.getNgay_checkout().getTime())+"' "
                + ", PT_TrangThai = N'"+pt.getTrangThai()+"' "
                + "where PT_MaPT = '"+pt.getMaPT()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean xoaPT(PhieuThue pt){
        String sql = "delete from tblPhieuThue "
                    +"where PT_MaPT = '"+pt.getMaPT()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
