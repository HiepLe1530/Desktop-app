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
public class Phong {
    private int MaP;
    private float DienTich;
    private long DonGia;
    private String TinhTrang;

    public Phong() {
    }

    public Phong(int MaP, float DienTich, long DonGia, String TinhTrang) {
        this.MaP = MaP;
        this.DienTich = DienTich;
        this.DonGia = DonGia;
        this.TinhTrang = TinhTrang;
    }

    public int getMaP() {
        return MaP;
    }

    public void setMaP(int MaP) {
        this.MaP = MaP;
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
    
}
