package com.example.finaltest.payload.converter;

import com.example.finaltest.entity.KhoaHoc;
import com.example.finaltest.payload.dto.KhoaHocDTO;
import com.example.finaltest.payload.request.KhoaHocRequest.SuaKhoaHocRequest;
import com.example.finaltest.payload.request.KhoaHocRequest.ThemKhoaHocRequest;
import org.springframework.stereotype.Component;

@Component
public class KhoaHocConverter {
    public KhoaHocDTO entityToDTO(KhoaHoc khoaHoc){
        KhoaHocDTO dto = new KhoaHocDTO();
        dto.setLoaiKhoaHocId(khoaHoc.getLoaiKhoaHocId());
        dto.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
        dto.setHocPhi(khoaHoc.getHocPhi());
        dto.setNoiDung(khoaHoc.getNoiDung());
        dto.setGioiThieu(khoaHoc.getGioiThieu());
        dto.setHinhAnh(khoaHoc.getHinhAnh());
        dto.setSoHocVien(khoaHoc.getSoHocVien());
        dto.setSoLuongMon(khoaHoc.getSoLuongMon());
        dto.setThoiGianHoc(khoaHoc.getThoiGianHoc());
        return dto;
    }
    public KhoaHoc themKhoaHoc(ThemKhoaHocRequest request){
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setLoaiKhoaHocId(request.getLoaiKhoaHocId());
        khoaHoc.setTenKhoaHoc(request.getTenKhoaHoc());
        khoaHoc.setHocPhi(request.getHocPhi());
        khoaHoc.setNoiDung(request.getNoiDung());
        khoaHoc.setGioiThieu(request.getGioiThieu());
        khoaHoc.setHinhAnh(request.getHinhAnh());
        khoaHoc.setSoLuongMon(request.getSoLuongMon());
        khoaHoc.setThoiGianHoc(request.getThoiGianHoc());
        return khoaHoc;
    }
    public KhoaHoc suaKhoaHoc(KhoaHoc khoaHoc, SuaKhoaHocRequest request){
        khoaHoc.setId(request.getKhoaKhocId());
        khoaHoc.setLoaiKhoaHocId(request.getLoaiKhoaHocId());
        khoaHoc.setTenKhoaHoc(request.getTenKhoaHoc());
        khoaHoc.setHocPhi(request.getHocPhi());
        khoaHoc.setNoiDung(request.getNoiDung());
        khoaHoc.setGioiThieu(request.getGioiThieu());
        khoaHoc.setHinhAnh(request.getHinhAnh());
        khoaHoc.setSoLuongMon(request.getSoLuongMon());
        khoaHoc.setThoiGianHoc(request.getThoiGianHoc());
        return khoaHoc;
    }
}
