package com.example.finaltest.payload.request.KhoaHocRequest;

import lombok.Data;

@Data
public class SuaKhoaHocRequest {
    private int khoaKhocId;
    private int loaiKhoaHocId;
    private String tenKhoaHoc;
    private int thoiGianHoc;
    private String gioiThieu;
    private String noiDung;
    private double hocPhi;
    private int soLuongMon;
    private String hinhAnh;
}
