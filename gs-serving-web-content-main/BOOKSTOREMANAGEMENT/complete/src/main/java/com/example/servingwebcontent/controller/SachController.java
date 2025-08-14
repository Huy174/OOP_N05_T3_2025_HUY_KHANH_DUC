package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Sach;
import com.example.servingwebcontent.service.QuanLySach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sach")
public class SachController {

    private final QuanLySach quanLySach = new QuanLySach();

    @GetMapping
    public String danhSachSach(org.springframework.ui.Model model) {
        model.addAttribute("danhSachSach", quanLySach.layTatCaSach());
        model.addAttribute("sachMoi", new Sach());
        return "sach"; // templates/sach.html
    }

    // Thêm / Sửa sách
    @PostMapping("/luu")
    @ResponseBody
    public List<Sach> luuSach(@ModelAttribute Sach sach) {
        if (quanLySach.timTheoMa(sach.getMaSach()).isPresent()) {
            quanLySach.capNhatSach(sach.getMaSach(), sach);
        } else {
            quanLySach.themSach(sach);
        }
        return quanLySach.layTatCaSach();
    }

    // Xóa sách
    @DeleteMapping("/xoa/{maSach}")
    @ResponseBody
    public List<Sach> xoaSach(@PathVariable String maSach) {
        quanLySach.xoaSach(maSach);
        return quanLySach.layTatCaSach();
    }

    // Tìm kiếm sách theo mã
    @GetMapping("/timkiem")
    @ResponseBody
    public List<Sach> timSach(@RequestParam String maSach) {
        return quanLySach.timTheoMa(maSach)
                .map(List::of)
                .orElse(List.of());
    }
}
