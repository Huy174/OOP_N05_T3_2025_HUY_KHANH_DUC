package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.KhachHang;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyKhachHang {

    private List<KhachHang> danhSachKhachHang = new ArrayList<>();

    // Constructor: khởi tạo dữ liệu minh họa sẵn chỉ với các biến của KhachHang
    public QuanLyKhachHang() {
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A", "0901234567", "Hà Nội");
        KhachHang kh2 = new KhachHang("KH002", "Trần Thị B", "0912345678", "TP HCM");
        KhachHang kh3 = new KhachHang("KH003", "Lê Văn C", "0922334455", "Đà Nẵng");

        danhSachKhachHang.add(kh1);
        danhSachKhachHang.add(kh2);
        danhSachKhachHang.add(kh3);
    }

    // Thêm khách hàng
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }

    // Lấy tất cả khách hàng
    public List<KhachHang> layTatCaKhachHang() {
        return danhSachKhachHang;
    }

    // Tìm kiếm khách hàng theo mã
    public Optional<KhachHang> timTheoMa(String maKhachHang) {
        return danhSachKhachHang.stream()
                .filter(kh -> kh.getMaKhachHang().equals(maKhachHang))
                .findFirst();
    }

    // Tìm kiếm khách hàng theo tên
    public List<KhachHang> timTheoTen(String tuKhoa) {
        return danhSachKhachHang.stream()
                .filter(kh -> kh.getTenKhachHang().toLowerCase().contains(tuKhoa.toLowerCase()))
                .toList();
    }

    // Cập nhật khách hàng
    public boolean capNhatKhachHang(String maKhachHang, KhachHang khMoi) {
        Optional<KhachHang> kh = timTheoMa(maKhachHang);
        if (kh.isPresent()) {
            KhachHang khCu = kh.get();
            khCu.setTenKhachHang(khMoi.getTenKhachHang());
            khCu.setDiaChi(khMoi.getDiaChi());
            khCu.setSoDienThoai(khMoi.getSoDienThoai());
            return true;
        }
        return false;
    }

    // Xóa khách hàng
    public boolean xoaKhachHang(String maKhachHang) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaKhachHang().equals(maKhachHang));
    }
}
