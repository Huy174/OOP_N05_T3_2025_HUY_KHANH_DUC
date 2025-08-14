
package com.example.servingwebcontent.model;

public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int soLuongTonKho;
    private double giaBan;

    // Constructor mặc định
    public Sach() {
    }

    // Constructor đầy đủ
    public Sach(String maSach, String tenSach, String tacGia, int soLuongTonKho, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.soLuongTonKho = soLuongTonKho;
        this.giaBan = giaBan;
    }

    // Getter & Setter
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", soLuongTonKho=" + soLuongTonKho +
                ", giaBan=" + giaBan +
                '}';
    }
}

