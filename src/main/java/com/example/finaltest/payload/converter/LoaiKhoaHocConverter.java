package com.example.finaltest.payload.converter;

import com.example.finaltest.entity.LoaiKhoaHoc;
import com.example.finaltest.payload.dto.LoaiKhoaHocDTO;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.SuaLoaiKhoaHocRequest;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.ThemLoaiKhoaHocRequest;
import org.springframework.stereotype.Component;

@Component
public class LoaiKhoaHocConverter {
    public LoaiKhoaHocDTO entityToDTO(LoaiKhoaHoc loaiKhoaHoc){
        LoaiKhoaHocDTO dto = new LoaiKhoaHocDTO();
        dto.setTenLoaiKhoaHoc(loaiKhoaHoc.getTenLoaiKhoaHoc());
        return dto;
    }
    public LoaiKhoaHoc themLoaiKhoaHoc(ThemLoaiKhoaHocRequest request){
        LoaiKhoaHoc loaiKhoaHoc = new LoaiKhoaHoc();
        loaiKhoaHoc.setTenLoaiKhoaHoc(request.getTenLoaiKhoaHoc());
        return loaiKhoaHoc;
    }
    public LoaiKhoaHoc suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc, SuaLoaiKhoaHocRequest request){
        loaiKhoaHoc.setTenLoaiKhoaHoc(request.getTenLoaiKhoaHoc());
        return loaiKhoaHoc;
    }
}
