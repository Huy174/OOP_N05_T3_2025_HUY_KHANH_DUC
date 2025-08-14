package com.example.servingwebcontent.model;

public class GiaoDich {
    private String maGiaoDich;
    private String maKhachHang;
    private double tongTien;

    public GiaoDich() {}

    public GiaoDich(String maGiaoDich, String maKhachHang, double tongTien) {
        this.maGiaoDich = maGiaoDich;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
    }

    public String getMaGiaoDich() { return maGiaoDich; }
    public void setMaGiaoDich(String maGiaoDich) { this.maGiaoDich = maGiaoDich; }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    @Override
    public String toString() {
        return "GiaoDich{" +
                "maGiaoDich='" + maGiaoDich + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}
