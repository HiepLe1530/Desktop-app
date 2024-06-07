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
public class PhieuDangKy {
    private String MaPDK;
    private String MaKH;
    private int MaP;
    private Date NgayDK;
    private Date Check_in;
    private Date Check_out;
    private long TienCoc;

    public PhieuDangKy() {
    }

    public PhieuDangKy(String MaPDK, String MaKH, int MaP, Date NgayDK, Date Check_in, Date Check_out, long TienCoc) {
        this.MaPDK = MaPDK;
        this.MaKH = MaKH;
        this.MaP = MaP;
        this.NgayDK = NgayDK;
        this.Check_in = Check_in;
        this.Check_out = Check_out;
        this.TienCoc = TienCoc;
    }

    public String getMaPDK() {
        return MaPDK;
    }

    public void setMaPDK(String MaPDK) {
        this.MaPDK = MaPDK;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaP() {
        return MaP;
    }

    public void setMaP(int MaP) {
        this.MaP = MaP;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

    public Date getCheck_in() {
        return Check_in;
    }

    public void setCheck_in(Date Check_in) {
        this.Check_in = Check_in;
    }

    public Date getCheck_out() {
        return Check_out;
    }

    public void setCheck_out(Date Check_out) {
        this.Check_out = Check_out;
    }

    public long getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(long TienCoc) {
        this.TienCoc = TienCoc;
    }

    @Override
    public String toString() {
        return "PhieuDangKy{" + "MaPDK=" + MaPDK + ", MaKH=" + MaKH + ", MaP=" + MaP + ", NgayDK=" + NgayDK + ", Check_in=" + Check_in + ", Check_out=" + Check_out + ", TienCoc=" + TienCoc + '}';
    }
    
}
