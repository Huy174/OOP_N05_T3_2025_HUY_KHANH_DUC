package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.NhanVien;
import com.example.servingwebcontent.service.QuanLyNhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {

    private final QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();

    @GetMapping
    public String danhSachNhanVien(org.springframework.ui.Model model) {
        model.addAttribute("danhSachNhanVien", quanLyNhanVien.layTatCaNhanVien());
        model.addAttribute("nhanVienMoi", new NhanVien());
        return "nhanvien"; // templates/nhanvien.html
    }

    // Thêm / Sửa nhân viên
    @PostMapping("/luu")
    @ResponseBody
    public List<NhanVien> luuNhanVien(@ModelAttribute NhanVien nv) {
        if (quanLyNhanVien.timTheoMa(nv.getMaNhanVien()).isPresent()) {
            quanLyNhanVien.capNhatNhanVien(nv.getMaNhanVien(), nv);
        } else {
            quanLyNhanVien.themNhanVien(nv);
        }
        return quanLyNhanVien.layTatCaNhanVien();
    }

    // Xóa nhân viên
    @DeleteMapping("/xoa/{maNhanVien}")
    @ResponseBody
    public List<NhanVien> xoaNhanVien(@PathVariable String maNhanVien) {
        quanLyNhanVien.xoaNhanVien(maNhanVien);
        return quanLyNhanVien.layTatCaNhanVien();
    }

    // Tìm kiếm nhân viên theo mã
    @GetMapping("/timkiem")
    @ResponseBody
    public List<NhanVien> timNhanVien(@RequestParam String maNhanVien) {
        return quanLyNhanVien.timTheoMa(maNhanVien)
                .map(List::of)
                .orElse(List.of());
    }
}
