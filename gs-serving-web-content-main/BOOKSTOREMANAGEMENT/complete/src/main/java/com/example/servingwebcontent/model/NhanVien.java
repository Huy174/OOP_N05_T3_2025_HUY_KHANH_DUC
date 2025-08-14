package com.example.servingwebcontent.model;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String chucVu;
    private String soDienThoai;
    private double luong;

    // Constructor mặc định
    public NhanVien() {
    }

    // Constructor đầy đủ
    public NhanVien(String maNhanVien, String hoTen, String chucVu, String soDienThoai, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.soDienThoai = soDienThoai;
        this.luong = luong;
    }

    // Getter & Setter
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", luong=" + luong +
                '}';
    }
}
