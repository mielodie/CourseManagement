package com.example.finaltest.payload.dto;

import com.example.finaltest.entity.LoaiKhoaHoc;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class KhoaHocDTO {
    private int loaiKhoaHocId;
    private String tenKhoaHoc;
    private int thoiGianHoc;
    private String gioiThieu;
    private String noiDung;
    private double hocPhi;
    private int soHocVien = 0;
    private int soLuongMon;
    private String hinhAnh;
}
