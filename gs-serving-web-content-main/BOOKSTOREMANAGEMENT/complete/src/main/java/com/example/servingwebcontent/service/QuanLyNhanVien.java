package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyNhanVien {

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    // Constructor: dữ liệu minh họa
    public QuanLyNhanVien() {
        danhSachNhanVien.add(new NhanVien("NV001", "Nguyen Van A", "Quản lý", "0912345678", 12000000));
        danhSachNhanVien.add(new NhanVien("NV002", "Tran Thi B", "Nhân viên bán hàng", "0987654321", 8000000));
        danhSachNhanVien.add(new NhanVien("NV003", "Le Van C", "Kế toán", "0901122334", 9000000));
    }

    // Thêm nhân viên
    public void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }

    // Lấy tất cả nhân viên
    public List<NhanVien> layTatCaNhanVien() {
        return danhSachNhanVien;
    }

    // Tìm kiếm nhân viên theo mã
    public Optional<NhanVien> timTheoMa(String maNhanVien) {
        return danhSachNhanVien.stream()
                .filter(nv -> nv.getMaNhanVien().equals(maNhanVien))
                .findFirst();
    }

    // Tìm kiếm nhân viên theo tên
    public List<NhanVien> timTheoTen(String tuKhoa) {
        return danhSachNhanVien.stream()
                .filter(nv -> nv.getHoTen().toLowerCase().contains(tuKhoa.toLowerCase()))
                .toList();
    }

    // Cập nhật nhân viên
    public boolean capNhatNhanVien(String maNhanVien, NhanVien nvMoi) {
        Optional<NhanVien> nv = timTheoMa(maNhanVien);
        if (nv.isPresent()) {
            NhanVien nvCu = nv.get();
            nvCu.setHoTen(nvMoi.getHoTen());
            nvCu.setChucVu(nvMoi.getChucVu());
            nvCu.setSoDienThoai(nvMoi.getSoDienThoai());
            nvCu.setLuong(nvMoi.getLuong());
            return true;
        }
        return false;
    }

    // Xóa nhân viên
    public boolean xoaNhanVien(String maNhanVien) {
        return danhSachNhanVien.removeIf(nv -> nv.getMaNhanVien().equals(maNhanVien));
    }
}
