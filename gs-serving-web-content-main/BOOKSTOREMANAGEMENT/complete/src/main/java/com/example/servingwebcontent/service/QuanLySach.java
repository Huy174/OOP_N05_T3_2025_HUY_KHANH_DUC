package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Sach;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLySach {

    private List<Sach> danhSachSach = new ArrayList<>();

    // Constructor: dữ liệu minh họa
    public QuanLySach() {
        danhSachSach.add(new Sach("S001", "Đắc Nhân Tâm", "Dale Carnegie", 10, 120000));
        danhSachSach.add(new Sach("S002", "Tuổi Trẻ Đáng Giá Bao Nhiêu", "Nguyễn Nhật Ánh", 5, 90000));
        danhSachSach.add(new Sach("S003", "Nhà Giả Kim", "Paulo Coelho", 8, 110000));
    }

    // CRUD cơ bản

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public List<Sach> layTatCaSach() {
        return danhSachSach;
    }

    public Optional<Sach> timTheoMa(String maSach) {
        return danhSachSach.stream()
                .filter(s -> s.getMaSach().equals(maSach))
                .findFirst();
    }

    public List<Sach> timTheoTen(String tuKhoa) {
        return danhSachSach.stream()
                .filter(s -> s.getTenSach().toLowerCase().contains(tuKhoa.toLowerCase()))
                .toList();
    }

    public boolean capNhatSach(String maSach, Sach sachMoi) {
        Optional<Sach> s = timTheoMa(maSach);
        if (s.isPresent()) {
            Sach sCu = s.get();
            sCu.setTenSach(sachMoi.getTenSach());
            sCu.setTacGia(sachMoi.getTacGia());
            sCu.setSoLuongTonKho(sachMoi.getSoLuongTonKho());
            sCu.setGiaBan(sachMoi.getGiaBan());
            return true;
        }
        return false;
    }

    public boolean xoaSach(String maSach) {
        return danhSachSach.removeIf(s -> s.getMaSach().equals(maSach));
    }
}
