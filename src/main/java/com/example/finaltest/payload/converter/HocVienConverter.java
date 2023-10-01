package com.example.finaltest.payload.converter;

import com.example.finaltest.entity.HocVien;
import com.example.finaltest.payload.dto.HocVienDTO;
import com.example.finaltest.payload.request.HocVienRequest.SuaHocVienRequest;
import com.example.finaltest.payload.request.HocVienRequest.ThemHocVienRequest;
import org.springframework.stereotype.Component;

@Component
public class HocVienConverter {
    public HocVienDTO entityToDTO(HocVien hocVien){
        HocVienDTO dto = new HocVienDTO();
        dto.setHinhAnh(hocVien.getHinhAnh());
        dto.setEmail(hocVien.getEmail());
        dto.setDiaChi(hocVien.getDiaChi());
        dto.setNgaySinh(hocVien.getNgaySinh());
        dto.setSoDienThoai(hocVien.getSoDienThoai());
        dto.setHoTen(hocVien.getHoTen());
        return dto;
    }
    public HocVien themHocVien(ThemHocVienRequest request){
        HocVien hocVien = new HocVien();
        hocVien.setEmail(request.getEmail());
        hocVien.setNgaySinh(request.getNgaySinh());
        hocVien.setHoTen(request.getHoTen());
        hocVien.setDiaChi(request.getDiaChi());
        hocVien.setHinhAnh(request.getHinhAnh());
        hocVien.setSoDienThoai(request.getSoDienThoai());
        return hocVien;
    }
    public HocVien suaHocVien(HocVien hocVien, SuaHocVienRequest request){
        hocVien.setId(request.getHocVienId());
        hocVien.setNgaySinh(request.getNgaySinh());
        hocVien.setHoTen(request.getHoTen());
        hocVien.setDiaChi(request.getDiaChi());
        hocVien.setHinhAnh(request.getHinhAnh());
        hocVien.setSoDienThoai(request.getSoDienThoai());
        return hocVien;
    }
}
