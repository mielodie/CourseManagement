package com.example.finaltest.payload.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class HocVienDTO {
    private String hinhAnh;
    private String hoTen;
    private LocalDate ngaySinh;
    private String email;
    private String soDienThoai;
    private String diaChi;
}
