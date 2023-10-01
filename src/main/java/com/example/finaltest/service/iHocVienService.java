package com.example.finaltest.service;

import com.example.finaltest.payload.dto.HocVienDTO;
import com.example.finaltest.payload.request.HocVienRequest.SuaHocVienRequest;
import com.example.finaltest.payload.request.HocVienRequest.ThemHocVienRequest;
import com.example.finaltest.payload.response.ResponseObject;

import java.util.Set;

public interface iHocVienService {
    ResponseObject<HocVienDTO> themHocVien(ThemHocVienRequest request);
    ResponseObject<HocVienDTO> suaHocVien(SuaHocVienRequest request);
    String xoaHocVien(int hocVienId);
    Set<HocVienDTO> layHocVien(int pageSize, int pageNumber);
    Set<HocVienDTO> layHocVienTheoTen(String tenHocVien, int pageSize, int pageNumber);
    Set<HocVienDTO> layHocVienThemEmail(String email, int pageSize, int pageNumber);
}
