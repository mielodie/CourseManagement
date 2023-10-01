package com.example.finaltest.service;

import com.example.finaltest.payload.dto.LoaiKhoaHocDTO;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.SuaLoaiKhoaHocRequest;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.ThemLoaiKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;

import java.util.Set;

public interface iLoaiKhoaHocService {
    ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(ThemLoaiKhoaHocRequest request);
    ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(SuaLoaiKhoaHocRequest request);
    String xoaLoaiKhoaHoc(int loaiKhoaHocId);
    Set<LoaiKhoaHocDTO> layLoaiKhoaHoc(int pageSize, int pageNumber);
}
