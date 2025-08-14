package com.example.servingwebcontent.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class SachControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // GET thành công
    @Test
    public void testGetSachThanhCong() throws Exception {
        mockMvc.perform(get("/sach/BK001"))
               .andExpect(status().isOk());
    }

    // GET lỗi (không tồn tại)
    @Test
    public void testGetSachKhongTonTai() throws Exception {
        mockMvc.perform(get("/sach/INVALID"))
               .andExpect(status().isNotFound());
    }

    // POST thêm sách mới
    @Test
    public void testPostSachMoi() throws Exception {
        String json = "{\"maSach\":\"BK999\",\"ten\":\"Test Book\",\"tacGia\":\"Author\",\"gia\":100000,\"soLuong\":10}";
        mockMvc.perform(post("/sach")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isCreated());
    }

    // PUT sửa sách
    @Test
    public void testPutSach() throws Exception {
        String json = "{\"ten\":\"Test Book Update\",\"tacGia\":\"Author Update\",\"gia\":120000,\"soLuong\":5}";
        mockMvc.perform(put("/sach/BK999")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk());
    }

    // DELETE sách
    @Test
    public void testDeleteSach() throws Exception {
        mockMvc.perform(delete("/sach/BK999"))
               .andExpect(status().isOk());
    }
}
