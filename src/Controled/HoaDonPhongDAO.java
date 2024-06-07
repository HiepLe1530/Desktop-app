/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controled;

import Model.HoaDonPhong;
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
public class HoaDonPhongDAO {
    private Connection conn;
   
    public HoaDonPhongDAO() {
      
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EOKFNG74:1433;databaseName=QLKhachSan;"
            +"user=sa;password=30042002");
                    
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public boolean addHoaDonPhong(HoaDonPhong hdp){
        String sql = "insert into tblHoaDonPhong(HDP_MaHDP, HDP_PT_MaPT, HDP_NgayLap, HDP_TongTien)"
                + "values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdp.getMaHDP());
            ps.setString(2, hdp.getMaPT());
            ps.setDate(3, new java.sql.Date(hdp.getNgayLap().getTime()));
            ps.setLong(4, hdp.getTongTien());
           
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        }
        return false;
    }
    public ArrayList<HoaDonPhong> getListHoaDonPhong(){
        ArrayList<HoaDonPhong> listHDP = new ArrayList<>();
        String sql = "SELECT * FROM tblHoaDonPhong";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonPhong hdp = new HoaDonPhong();
                hdp.setMaHDP(rs.getString("HDP_MaHDP"));
                hdp.setMaPT(rs.getString("HDP_PT_MaPT"));
                hdp.setNgayLap(rs.getDate("HDP_NgayLap"));
                hdp.setTongTien(rs.getLong("HDP_TongTien"));
               
                listHDP.add(hdp);
            }
        } catch (SQLException e) {
        }
        return listHDP;
    }
    
    public ArrayList<HoaDonPhong> getListThongKeHDPtheoNgay(){
        ArrayList<HoaDonPhong> listHDP = new ArrayList<>();
        String sql = "select HDP_NgayLap, sum(HDP_TongTien) as DoanhThu_Ngay  from tblHoaDonPhong " +
                    "group by HDP_NgayLap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonPhong hdp = new HoaDonPhong();
                hdp.setNgayLap(rs.getDate("HDP_NgayLap"));
                hdp.setTongTien(rs.getLong("DoanhThu_Ngay"));
               
                listHDP.add(hdp);
            }
        } catch (SQLException e) {
        }
        return listHDP;
    }
    
    public ArrayList<HoaDonPhong> getListThongKeHDPtheoThang(String s){
        ArrayList<HoaDonPhong> listHDP = new ArrayList<>();
        String sql = "select DATEPART(month, HDP_NgayLap) as Thang, sum(HDP_TongTien) as Doanhthu_thang  "
                + "from tblHoaDonPhong "
                + "where DATEPART(year, HDP_Ngaylap) = '"+s+"' " 
                + "group by DATEPART(month, HDP_NgayLap)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonPhong hdp = new HoaDonPhong();
                hdp.setMaHDP(rs.getString("Thang"));
                hdp.setTongTien(rs.getLong("Doanhthu_thang"));
               
                listHDP.add(hdp);
            }
        } catch (SQLException e) {
        }
        return listHDP;
    }
    
    public ArrayList<HoaDonPhong> getListThongKeHDPtheoNam(){
        ArrayList<HoaDonPhong> listHDP = new ArrayList<>();
        String sql = "select DATEPART(year, HDP_NgayLap) as Nam, sum(HDP_TongTien) as Doanhthu_nam  from tblHoaDonPhong " +
                    "group by DATEPART(year, HDP_NgayLap)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonPhong hdp = new HoaDonPhong();
                hdp.setMaHDP(rs.getString("Nam"));
                hdp.setTongTien(rs.getLong("Doanhthu_nam"));
               
                listHDP.add(hdp);
            }
        } catch (SQLException e) {
        }
        return listHDP;
    }
    
    public boolean xoaHDP(HoaDonPhong hdp){
        String sql = "delete from tblHoaDonPhong "
                   + "where HDP_MaHDP = '"+hdp.getMaHDP()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
}
