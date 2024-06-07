/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.HoaDonDV;
import Model.PhieuDichVu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Le Van Hoang
 */
public class HoaDonDVDAO {
    private Connection conn;
   
    public HoaDonDVDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    public boolean addHoaDonDV(HoaDonDV hddv){
        String sql = "insert into tblHoaDonDV(HDDV_MaHDDV, HDDV_NgayLap, HDDV_TongTien) "
                + "values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hddv.getMaHDDV());
            ps.setDate(2, new java.sql.Date(hddv.getNgayLap().getTime()));
            ps.setLong(3, hddv.getTongTien());
           
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<HoaDonDV> getListHoaDonDV(){
        ArrayList<HoaDonDV> listHDDV = new ArrayList<>();
        String sql = "SELECT * FROM tblHoaDonDV";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDV hddv = new HoaDonDV();
    
                hddv.setMaHDDV(rs.getString("HDDV_MaHDDV"));
                hddv.setNgayLap(rs.getDate("HDDV_NgayLap"));
                hddv.setTongTien(rs.getLong("HDDV_TongTien"));
               
                listHDDV.add(hddv);
            }
        } catch (SQLException e) {
        }
        return listHDDV;
    }
    
    public ArrayList<HoaDonDV> getListThongKeHDDVtheoNgay(){
        ArrayList<HoaDonDV> listHDDV = new ArrayList<>();
        String sql = "select HDDV_NgayLap, sum(HDDV_TongTien) as DoanhthuDV_ngay  from tblHoadonDV " +
                    "group by HDDV_NgayLap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDV hddv = new HoaDonDV();

                hddv.setNgayLap(rs.getDate("HDDV_NgayLap"));
                hddv.setTongTien(rs.getLong("DoanhthuDV_ngay"));
               
                listHDDV.add(hddv);
            }
        } catch (SQLException e) {
        }
        return listHDDV;
    }
    
    public ArrayList<HoaDonDV> getListThongKeHDDVtheoThang(String s){
        ArrayList<HoaDonDV> listHDDV = new ArrayList<>();
        String sql = "select DATEPART(month, HDDV_NgayLap) as Thang, sum(HDDV_TongTien) as DoanhthuDV_thang  "
                + "from tblHoaDonDV "
                + "where DATEPART(year, HDDV_Ngaylap) = '"+s+"' " 
                + "group by DATEPART(month, HDDV_NgayLap)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDV hddv = new HoaDonDV();

                hddv.setMaHDDV(rs.getString("Thang"));
                hddv.setTongTien(rs.getLong("DoanhthuDV_thang"));
               
                listHDDV.add(hddv);
            }
        } catch (SQLException e) {
        }
        return listHDDV;
    }
    
    public ArrayList<HoaDonDV> getListThongKeHDDVtheoNam(){
        ArrayList<HoaDonDV> listHDDV = new ArrayList<>();
        String sql = "select DATEPART(year, HDDV_NgayLap) as Nam, sum(HDDV_TongTien) as DoanhthuDV_nam  from tblHoaDonDV " +
                    "group by DATEPART(year, HDDV_NgayLap)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDV hddv = new HoaDonDV();

                hddv.setMaHDDV(rs.getString("Nam"));
                hddv.setTongTien(rs.getLong("DoanhthuDV_nam"));
               
                listHDDV.add(hddv);
            }
        } catch (SQLException e) {
        }
        return listHDDV;
    }
    
    public boolean xoaHDDV(HoaDonDV hddv){
        String sql = "delete from tblHoaDonDV "
                   + "where HDDV_MaHDDV = '"+hddv.getMaHDDV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
