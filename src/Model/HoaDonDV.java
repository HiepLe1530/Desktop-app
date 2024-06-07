/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Le Van Hoang
 */
public class HoaDonDV {
    private String MaHDDV;
    private Date NgayLap;
    private long TongTien;

    public HoaDonDV() {
    }

    public HoaDonDV(String MaHDDV, Date NgayLap, long TongTien) {
        this.MaHDDV = MaHDDV;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }
    
}
