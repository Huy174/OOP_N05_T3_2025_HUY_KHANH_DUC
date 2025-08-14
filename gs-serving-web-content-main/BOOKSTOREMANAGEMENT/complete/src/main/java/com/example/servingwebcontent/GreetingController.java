package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {



    // Trang giới thiệu
    @GetMapping("/about")
    public String about() {
        return "about"; // trả về about.html
    }
}
