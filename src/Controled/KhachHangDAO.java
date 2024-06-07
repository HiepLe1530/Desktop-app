/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.KhachHang;
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
public class KhachHangDAO {
    private Connection conn;
   
    public KhachHangDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
            
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    
    
    
    public boolean addKhachHang(KhachHang kh){
        String sql = "INSERT INTO tblKhachHang(KH_MaKH, KH_HoTen, KH_CMND, KH_QuocTich, KH_DiaChi, KH_GioiTinh)"
                +"VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getCMND());
            ps.setString(4, kh.getQuocTich());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getGioiTinh());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM tblKhachHang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("KH_MaKH"));
                kh.setTenKH(rs.getString("KH_HoTen"));
                kh.setCMND(rs.getString("KH_CMND"));
                kh.setQuocTich(rs.getString("KH_QuocTich"));
                kh.setDiaChi(rs.getString("KH_DiaChi"));
                kh.setGioiTinh(rs.getString("KH_GioiTinh"));
                
                listKH.add(kh);
            }
        } catch (SQLException e) {
        }
        return listKH;
    }
    
    public ArrayList<KhachHang> getListKhachHang(String s){
        ArrayList<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM tblKhachHang where KH_MaKH = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("KH_MaKH"));
                kh.setTenKH(rs.getString("KH_HoTen"));
                kh.setCMND(rs.getString("KH_CMND"));
                kh.setQuocTich(rs.getString("KH_QuocTich"));
                kh.setDiaChi(rs.getString("KH_DiaChi"));
                kh.setGioiTinh(rs.getString("KH_GioiTinh"));
                
                listKH.add(kh);
            }
        } catch (SQLException e) {
        }
        return listKH;
    }
    
    public boolean updateKH(KhachHang kh){
        String sql = "update tblKhachHang " +
                    "set KH_HoTen = N'"+kh.getTenKH()+"', KH_CMND = '"+kh.getCMND()+"', "
                    + "KH_Quoctich = N'"+kh.getQuocTich()+"', KH_DiaChi = N'"+kh.getDiaChi()+"', "
                    + "KH_GioiTinh = N'"+kh.getGioiTinh()+"' " +
                    "where KH_MaKH = '"+kh.getMaKH()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean Xoa(KhachHang kh){
        String sql = "delete from tblKhachHang where KH_MaKH = '"+kh.getMaKH()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }

    public ArrayList<KhachHang> TKKhachHang(String s){
            ArrayList<KhachHang> listKH = new ArrayList<>();
            String sql = "SELECT * FROM tblKhachHang where KH_HoTen like N'%"+s+"%'";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("KH_MaKH"));
                    kh.setTenKH(rs.getString("KH_HoTen"));
                    kh.setCMND(rs.getString("KH_CMND"));
                    kh.setQuocTich(rs.getString("KH_QuocTich"));
                    kh.setDiaChi(rs.getString("KH_DiaChi"));
                    kh.setGioiTinh(rs.getString("KH_GioiTinh"));

                    listKH.add(kh);
                }
            } catch (SQLException e) {
            }
            return listKH;
        }

    public ArrayList<KhachHang> getListTKKHThueNgay(String s){
            ArrayList<KhachHang> listKH = new ArrayList<>();
            String sql = "select * from tblKhachHang inner join tblPhieuThue on KH_MaKH = PT_KH_MaKH " +
                        "where PT_Check_in = '"+s+"'";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("KH_MaKH"));
                    kh.setTenKH(rs.getString("KH_HoTen"));
                    kh.setCMND(rs.getString("KH_CMND"));
                    kh.setQuocTich(rs.getString("KH_QuocTich"));
                    kh.setDiaChi(rs.getString("KH_DiaChi"));
                    kh.setGioiTinh(rs.getString("KH_GioiTinh"));

                    listKH.add(kh);
                }
            } catch (SQLException e) {
            }
            return listKH;
    }
    
    public ArrayList<KhachHang> getListTKKHTraNgay(String s){
            ArrayList<KhachHang> listKH = new ArrayList<>();
            String sql = "select * from tblKhachHang inner join tblPhieuThue on KH_MaKH = PT_KH_MaKH " +
                        "where PT_Check_out = '"+s+"'";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("KH_MaKH"));
                    kh.setTenKH(rs.getString("KH_HoTen"));
                    kh.setCMND(rs.getString("KH_CMND"));
                    kh.setQuocTich(rs.getString("KH_QuocTich"));
                    kh.setDiaChi(rs.getString("KH_DiaChi"));
                    kh.setGioiTinh(rs.getString("KH_GioiTinh"));

                    listKH.add(kh);
                }
            } catch (SQLException e) {
            }
            return listKH;
    }
    
    public ArrayList<KhachHang> getListTKKHDangO(String s){
            ArrayList<KhachHang> listKH = new ArrayList<>();
            String sql = "select * from tblKhachHang inner join tblPhieuThue on KH_MaKH = PT_KH_MaKH " +
                        "where PT_Check_in <= '"+s+"' and PT_Check_out > '"+s+"'";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("KH_MaKH"));
                    kh.setTenKH(rs.getString("KH_HoTen"));
                    kh.setCMND(rs.getString("KH_CMND"));
                    kh.setQuocTich(rs.getString("KH_QuocTich"));
                    kh.setDiaChi(rs.getString("KH_DiaChi"));
                    kh.setGioiTinh(rs.getString("KH_GioiTinh"));

                    listKH.add(kh);
                }
            } catch (SQLException e) {
            }
            return listKH;
    }
}