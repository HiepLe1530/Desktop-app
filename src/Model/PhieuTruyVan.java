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
public class PhieuTruyVan {
    private String MaPT;
    private String MaKH;
    private int MaP;
    private long TienCoc;
    private Date Ngay_checkin;
    private Date Ngay_checkout;
    private String TrangThai;
    private float DienTich;
    private long DonGia;
    private String TinhTrang;
    private String TenKH;
    private String CMND;
    private String QuocTich;
    private String DiaChi;
    private String GioiTinh;
    private String MaPDK;
    private Date NgayDK;
    private Date Check_in;
    private Date Check_out;
    private String MaDV;
    private String TenDV;
    private String MaHDDV;
    private int SoLuong;
    private Date NgaySuDung;

    public PhieuTruyVan() {
    }

    public PhieuTruyVan(String MaPT, String MaKH, int MaP, long TienCoc, Date Ngay_checkin, Date Ngay_checkout, String TrangThai, float DienTich, long DonGia, String TinhTrang, String TenKH, String CMND, String QuocTich, String DiaChi, String GioiTinh, String MaPDK, Date NgayDK, Date Check_in, Date Check_out, String MaDV, String TenDV, String MaHDDV, int SoLuong, Date NgaySuDung) {
        this.MaPT = MaPT;
        this.MaKH = MaKH;
        this.MaP = MaP;
        this.TienCoc = TienCoc;
        this.Ngay_checkin = Ngay_checkin;
        this.Ngay_checkout = Ngay_checkout;
        this.TrangThai = TrangThai;
        this.DienTich = DienTich;
        this.DonGia = DonGia;
        this.TinhTrang = TinhTrang;
        this.TenKH = TenKH;
        this.CMND = CMND;
        this.QuocTich = QuocTich;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.MaPDK = MaPDK;
        this.NgayDK = NgayDK;
        this.Check_in = Check_in;
        this.Check_out = Check_out;
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.MaHDDV = MaHDDV;
        this.SoLuong = SoLuong;
        this.NgaySuDung = NgaySuDung;
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

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMaPDK() {
        return MaPDK;
    }

    public void setMaPDK(String MaPDK) {
        this.MaPDK = MaPDK;
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

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public String getMaHDDV() {
        return MaHDDV;
    }

    public void setMaHDDV(String MaHDDV) {
        this.MaHDDV = MaHDDV;
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

    
    

}