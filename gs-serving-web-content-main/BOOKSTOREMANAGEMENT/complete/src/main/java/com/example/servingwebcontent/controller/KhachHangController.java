package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.service.QuanLyKhachHang;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

    private final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();

    @GetMapping
    public String danhSachKhachHang(org.springframework.ui.Model model) {
        model.addAttribute("danhSachKhachHang", quanLyKhachHang.layTatCaKhachHang());
        model.addAttribute("khachHangMoi", new KhachHang());
        return "khachhang"; // templates/khachhang.html
    }

    // Thêm / Sửa khách hàng
    @PostMapping("/luu")
    @ResponseBody
    public List<KhachHang> luuKhachHang(@ModelAttribute KhachHang kh) {
        if (quanLyKhachHang.timTheoMa(kh.getMaKhachHang()).isPresent()) {
            quanLyKhachHang.capNhatKhachHang(kh.getMaKhachHang(), kh);
        } else {
            quanLyKhachHang.themKhachHang(kh);
        }
        return quanLyKhachHang.layTatCaKhachHang();
    }

    // Xóa khách hàng
    @DeleteMapping("/xoa/{maKhachHang}")
    @ResponseBody
    public List<KhachHang> xoaKhachHang(@PathVariable String maKhachHang) {
        quanLyKhachHang.xoaKhachHang(maKhachHang);
        return quanLyKhachHang.layTatCaKhachHang();
    }

    // Tìm kiếm khách hàng theo mã
    @GetMapping("/timkiem")
    @ResponseBody
    public List<KhachHang> timKhachHang(@RequestParam String maKhachHang) {
        return quanLyKhachHang.timTheoMa(maKhachHang)
                .map(List::of)
                .orElse(List.of());
    }
}
