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
public class PhieuThue {
    private String MaPT;
    private String MaKH;
    private int MaP;
    private long TienCoc;
    private Date Ngay_checkin;
    private Date Ngay_checkout;
    private String TrangThai;
    

    public PhieuThue() {
    }

    public PhieuThue(String MaPT, String MaKH, int MaP, long TienCoc, Date Ngay_checkin, Date Ngay_checkout, String TrangThai) {
        this.MaPT = MaPT;
        this.MaKH = MaKH;
        this.MaP = MaP;
        this.TienCoc = TienCoc;
        this.Ngay_checkin = Ngay_checkin;
        this.Ngay_checkout = Ngay_checkout;
        this.TrangThai = TrangThai;
    }

    public String getMaPT() {
        return MaPT;
    }

    public void setMaPT(String MaPT) {
        this.MaPT = MaPT;
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

    public long getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(long TienCoc) {
        this.TienCoc = TienCoc;
    }

    public Date getNgay_checkin() {
        return Ngay_checkin;
    }

    public void setNgay_checkin(Date Ngay_checkin) {
        this.Ngay_checkin = Ngay_checkin;
    }

    public Date getNgay_checkout() {
        return Ngay_checkout;
    }

    public void setNgay_checkout(Date Ngay_checkout) {
        this.Ngay_checkout = Ngay_checkout;
    }
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
