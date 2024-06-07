/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HoaDonPhong {
    private String MaHDP;
    private String MaPT;
    private Date NgayLap;
    private long TongTien;

    public HoaDonPhong() {
    }

    public HoaDonPhong(String MaHDP, String MaPT, Date NgayLap, long TongTien) {
        this.MaHDP = MaHDP;
        this.MaPT = MaPT;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public String getMaHDP() {
        return MaHDP;
    }

    public void setMaHDP(String MaHDP) {
        this.MaHDP = MaHDP;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
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
