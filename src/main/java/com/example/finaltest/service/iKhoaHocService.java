package com.example.finaltest.service;

import com.example.finaltest.payload.dto.KhoaHocDTO;
import com.example.finaltest.payload.request.KhoaHocRequest.SuaKhoaHocRequest;
import com.example.finaltest.payload.request.KhoaHocRequest.ThemKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;

import java.util.Set;

public interface iKhoaHocService {
    ResponseObject<KhoaHocDTO> themKhoaHoc(ThemKhoaHocRequest request);
    ResponseObject<KhoaHocDTO> suaKhoaHoc(SuaKhoaHocRequest request);
    String xoaKhoaHoc(int khoaHocId);
    Set<KhoaHocDTO> layKhoaHoc(int pageSize, int pageNumber);
    Set<KhoaHocDTO> timKiemKhoaHocTheoTen(String tenKhoaHoc, int pageSize, int pageNumber);
}
