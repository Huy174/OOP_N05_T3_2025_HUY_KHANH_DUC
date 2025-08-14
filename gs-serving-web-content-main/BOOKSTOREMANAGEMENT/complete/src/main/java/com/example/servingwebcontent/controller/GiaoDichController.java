package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.service.QuanLyGiaoDich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/giaodich")
public class GiaoDichController {

    private final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    @GetMapping
    public String danhSachGiaoDich(Model model) {
        model.addAttribute("danhSachGiaoDich", quanLyGiaoDich.layTatCaGiaoDich());
        model.addAttribute("tongDoanhThu", quanLyGiaoDich.tinhTongDoanhThu());
        model.addAttribute("giaoDich", new GiaoDich());
        return "giaodich";
    }

    // Lưu giao dịch (thêm/sửa)
    @PostMapping("/luu")
    @ResponseBody
    public List<GiaoDich> luuGiaoDich(@ModelAttribute GiaoDich gd) {
        if (quanLyGiaoDich.timTheoMa(gd.getMaGiaoDich()).isPresent()) {
            quanLyGiaoDich.capNhatGiaoDich(gd.getMaGiaoDich(), gd);
        } else {
            quanLyGiaoDich.themGiaoDich(gd);
        }
        return quanLyGiaoDich.layTatCaGiaoDich();
    }

    // Xóa giao dịch
    @DeleteMapping("/xoa/{maGiaoDich}")
    @ResponseBody
    public List<GiaoDich> xoaGiaoDich(@PathVariable String maGiaoDich) {
        quanLyGiaoDich.xoaGiaoDich(maGiaoDich);
        return quanLyGiaoDich.layTatCaGiaoDich();
    }

    // Tìm kiếm giao dịch
    @GetMapping("/timkiem")
    @ResponseBody
    public List<GiaoDich> timGiaoDich(@RequestParam String maGiaoDich) {
        return quanLyGiaoDich.timTheoMa(maGiaoDich)
                .map(List::of)
                .orElse(List.of());
    }
}
