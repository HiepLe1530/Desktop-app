/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.DichVu;
import Model.PhieuDichVu;
import Model.Phong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuDAO {
    private Connection conn;
   
    public PhieuDichVuDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    public boolean addPhieuDichVu(PhieuDichVu pdv){
        String sql = "insert into tblPhieuDV(PDV_HDDV_MaHDDV, PDV_DV_MaDV, PDV_P_MaP, PDV_SoLuong, PDV_NgaySD, PDV_TrangThai) "
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pdv.getMaHDDV());
            ps.setString(2, pdv.getMaDV());
            ps.setInt(3, pdv.getMaP());
            ps.setInt(4, pdv.getSoLuong());
            ps.setDate(5, new java.sql.Date(pdv.getNgaySuDung().getTime()));
            ps.setString(6, pdv.getTrangThai());
           
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<PhieuDichVu> getListPhieuDichVu(){
        ArrayList<PhieuDichVu> listPDV = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuDV";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDichVu pdv = new PhieuDichVu();
                pdv.setMaHDDV(rs.getString("PDV_HDDV_MaHDDV"));
                pdv.setMaDV(rs.getString("PDV_DV_MaDV"));
                pdv.setMaP(rs.getInt("PDV_P_MaP"));
                pdv.setSoLuong(rs.getInt("PDV_SoLuong"));
                pdv.setNgaySuDung(rs.getDate("PDV_NgaySD"));
                pdv.setTrangThai(rs.getString("PDV_TrangThai"));
               
                listPDV.add(pdv);
            }
        } catch (SQLException e) {
        }
        return listPDV;
    }
    
    //Tim kiem phieu dich vu theo phong
    public ArrayList<PhieuDichVu> getListPDVTK(Phong p){
        ArrayList<PhieuDichVu> listPDV = new ArrayList();
        String sql = "select * from tblPhieuDV " +
                    "where PDV_P_MaP = "+p.getMaP()+" and PDV_TrangThai = N'chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDichVu Pdv = new PhieuDichVu();
                Pdv.setMaHDDV(rs.getString("PDV_HDDV_MaHDDV"));
                Pdv.setMaDV(rs.getString("PDV_DV_MaDV"));
                Pdv.setMaP(rs.getInt("PDV_P_MaP"));
                Pdv.setSoLuong(rs.getInt("PDV_SoLuong"));
                Pdv.setNgaySuDung(rs.getDate("PDV_NgaySD"));
                Pdv.setTrangThai(rs.getString("PDV_TrangThai"));
               
                listPDV.add(Pdv);
            }
        } catch (SQLException e) {
        }
        return listPDV; 
    }
    
    // update so luong dich vu trên phieu dich vu
    public boolean updateSLDV(PhieuDichVu pdv){
        String sql = "update tblPhieuDV " +
                    "set PDV_SoLuong = "+pdv.getSoLuong()+" " +
                    "where PDV_HDDV_MaHDDV = '"+pdv.getMaHDDV()+"' and PDV_DV_MaDV = '"+pdv.getMaDV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean updateTrangThaiPDV(String s){
        String sql = "update tblPhieuDV " +
                    "set PDV_TrangThai = N'Đã đóng' " +
                    "where PDV_HDDV_MaHDDV = '"+s+"' and PDV_TrangThai = N'Chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean updatePDV(PhieuDichVu pdv, String s){
        String sql = "update tblPhieuDV " +
                    "set PDV_DV_MaDV = '"+pdv.getMaDV()+"' ,PDV_SoLuong = '"+pdv.getSoLuong()+"', "+
                    "PDV_NgaySD = '"+new java.sql.Date(pdv.getNgaySuDung().getTime())+"', "+
                    "PDV_TrangThai = N'"+pdv.getTrangThai()+"' " +
                    "where PDV_HDDV_MaHDDV = '"+pdv.getMaHDDV()+"' and PDV_DV_MaDV = '"+s+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean xoaPDV(PhieuDichVu pdv){
        String sql = "delete from tblPhieuDV " +
                    "where PDV_HDDV_MaHDDV = '"+pdv.getMaHDDV()+"' and PDV_DV_MaDV = '"+pdv.getMaDV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public ArrayList<PhieuDichVu> getListPhieuDichVu(String s){
        ArrayList<PhieuDichVu> listPDV = new ArrayList<>();
        String sql = "select PDV_HDDV_MaHDDV, PDV_DV_MaDV, PDV_P_MaP, PDV_SoLuong, PDV_NgaySD " +
                    "from (select * from (tblPhong inner join tblPhieuDV on P_MaP = PDV_P_MaP) inner join tblDichVu on PDV_DV_MaDV = DV_MaDV) b1 " +
                    "where P_MaP = "+s+" and PDV_TrangThai = N'chưa đóng'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuDichVu pdv = new PhieuDichVu();
                pdv.setMaHDDV(rs.getString("PDV_HDDV_MaHDDV"));
                pdv.setMaDV(rs.getString("PDV_DV_MaDV"));
                pdv.setMaP(rs.getInt("PDV_P_MaP"));
                pdv.setSoLuong(rs.getInt("PDV_SoLuong"));
                pdv.setNgaySuDung(rs.getDate("PDV_NgaySD"));
               
                listPDV.add(pdv);
            }
        } catch (SQLException e) {
        }
        return listPDV;
    }
}
