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
public class PhieuDichVu {
    private String MaHDDV;
    private int MaP;
    private String MaDV;
    private int SoLuong;
    private Date NgaySuDung;
    private String TrangThai;

    public PhieuDichVu() {
    }
    
    public PhieuDichVu(String MaHDDV, int MaP, String MaDV, int SoLuong, Date NgaySuDung, String TrangThai) {
        this.MaHDDV = MaHDDV;
        this.MaP = MaP;
        this.MaDV = MaDV;
        this.SoLuong = SoLuong;
        this.NgaySuDung = NgaySuDung;
        this.TrangThai = TrangThai;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
    }

    public int getMaP() {
        return MaP;
    }

    public void setMaP(int MaP) {
        this.MaP = MaP;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgaySuDung() {
        return NgaySuDung;
    }

    public void setNgaySuDung(Date NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }
    
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
