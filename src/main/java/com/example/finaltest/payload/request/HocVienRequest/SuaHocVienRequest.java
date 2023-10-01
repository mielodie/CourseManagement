package com.example.finaltest.payload.request.HocVienRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SuaHocVienRequest {
    private int hocVienId;
    private String hinhAnh;
    private String hoTen;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private String diaChi;
}
