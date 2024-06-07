/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.KhachHang;
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
public class PhongDAO {
    private Connection conn;
   
    public PhongDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public boolean addPhong(Phong p){
        String sql = "INSERT INTO tblPhong(P_MaP, P_DienTich, P_DonGia, P_TinhTrang)"
                +"VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getMaP());
            ps.setFloat(2, p.getDienTich());
            ps.setLong(3, p.getDonGia());
            ps.setString(4, p.getTinhTrang());
            
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<Phong> getListPhong(){
        ArrayList<Phong> listP = new ArrayList<>();
        String sql = "SELECT * FROM tblPhong";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setMaP(rs.getInt("P_MaP"));
                p.setDienTich(rs.getFloat("P_DienTich"));
                p.setDonGia(rs.getLong("P_DonGia"));
                p.setTinhTrang(rs.getString("P_TinhTrang"));
                
                listP.add(p);
            }
        } catch (SQLException e) {
        }
        return listP;
    }
    public ArrayList<Phong> getListPhongTK(String s){
        ArrayList<Phong> dsPhong = new ArrayList<>();
        String sql = "select P_MaP, P_TinhTrang, P_DienTich from tblPhong where P_MaP = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setMaP(rs.getInt("P_MaP"));
                p.setTinhTrang(rs.getString("P_TinhTrang"));
                p.setDienTich(rs.getFloat("P_DienTich"));
                dsPhong.add(p);
            }
        } catch (SQLException e) {
        }
        return dsPhong;
    }
    
    public ArrayList<Phong> getListPhong(String s){
        ArrayList<Phong> dsPhong = new ArrayList<>();
        String sql = "select P_MaP, P_DienTich, P_DonGia from tblPhong where P_MaP = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setMaP(rs.getInt("P_MaP"));
                p.setDienTich(rs.getFloat("P_DienTich"));
                p.setDonGia(rs.getLong("P_DonGia"));
                dsPhong.add(p);
            }
        } catch (SQLException e) {
        }
        return dsPhong;
    }
    
    public boolean update(String s, int i){
        String sql = "update tblPhong set P_TinhTrang = '"+s+"' "
                + "where P_MaP = '"+i+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean updatePhongTrong(String i){
        String sql = "update tblPhong set P_TinhTrang = 'Trong' "
                + "where P_MaP = '"+i+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean updatePhongDaThue(String i){
        String sql = "update tblPhong set P_TinhTrang = 'Da thue' "
                + "where P_MaP = '"+i+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean xoaPhong(Phong p){
        String sql = "delete from tblPhong where P_MaP = '"+p.getMaP()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
}

