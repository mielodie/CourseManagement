package com.example.finaltest.payload.request.HocVienRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ThemHocVienRequest {
    private String hinhAnh;
    private String hoTen;
    private LocalDate ngaySinh;
    private String email;
    private String soDienThoai;
    private String diaChi;
}
