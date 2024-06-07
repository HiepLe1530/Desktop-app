/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String CMND;
    private String QuocTich;
    private String DiaChi;
    private String GioiTinh;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String CMND, String QuocTich, String DiaChi, String GioiTinh) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.CMND = CMND;
        this.QuocTich = QuocTich;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
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
    
}
