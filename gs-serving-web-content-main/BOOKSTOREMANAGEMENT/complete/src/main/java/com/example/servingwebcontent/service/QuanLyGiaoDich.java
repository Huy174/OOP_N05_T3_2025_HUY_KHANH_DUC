package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.GiaoDich;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuanLyGiaoDich {

    private List<GiaoDich> danhSachGiaoDich = new ArrayList<>();

    public QuanLyGiaoDich() {
        // Ví dụ minh họa
        danhSachGiaoDich.add(new GiaoDich("GD001", "KH001", 150000));
        danhSachGiaoDich.add(new GiaoDich("GD002", "KH002", 90000));
    }

    // Lấy tất cả giao dịch
    public List<GiaoDich> layTatCaGiaoDich() {
        return new ArrayList<>(danhSachGiaoDich);
    }

    // Thêm giao dịch
    public void themGiaoDich(GiaoDich gd) {
        danhSachGiaoDich.add(gd);
    }

    // Cập nhật giao dịch theo mã
    public boolean capNhatGiaoDich(String maGD, GiaoDich gdMoi) {
        Optional<GiaoDich> opt = timTheoMa(maGD);
        if (opt.isPresent()) {
            GiaoDich gdCu = opt.get();
            gdCu.setMaKhachHang(gdMoi.getMaKhachHang());
            gdCu.setTongTien(gdMoi.getTongTien());
            return true;
        }
        return false;
    }

    // Xóa giao dịch theo mã
    public boolean xoaGiaoDich(String maGD) {
        return danhSachGiaoDich.removeIf(gd -> gd.getMaGiaoDich().equals(maGD));
    }

    // Tìm kiếm theo mã
    public Optional<GiaoDich> timTheoMa(String maGD) {
        return danhSachGiaoDich.stream()
                .filter(gd -> gd.getMaGiaoDich().equals(maGD))
                .findFirst();
    }

    // Tính tổng doanh thu
    public double tinhTongDoanhThu() {
        return danhSachGiaoDich.stream()
                .mapToDouble(GiaoDich::getTongTien)
                .sum();
    }
}
