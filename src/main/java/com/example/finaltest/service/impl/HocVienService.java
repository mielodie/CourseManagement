package com.example.finaltest.service.impl;

import com.example.finaltest.assistance.ChuanHoaTenAssistance;
import com.example.finaltest.payload.converter.HocVienConverter;
import com.example.finaltest.payload.dto.HocVienDTO;
import com.example.finaltest.payload.request.HocVienRequest.SuaHocVienRequest;
import com.example.finaltest.payload.request.HocVienRequest.ThemHocVienRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.reposiry.HocVienRepo;
import com.example.finaltest.service.iHocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HocVienService implements iHocVienService {
    @Autowired
    private HocVienRepo _hocVienRepo;
    @Autowired
    private HocVienConverter _converter;
    @Autowired
    private ResponseObject<HocVienDTO> _hocVienDTOResponseObject;
    @Autowired
    private ChuanHoaTenAssistance _chuanHoaTenAssistance;
    public ResponseObject<HocVienDTO> themHocVien(ThemHocVienRequest request) {
        var checkEmail = _hocVienRepo.findAll().stream().filter(x ->  x.getEmail().equals(request.getEmail()));
        var checkPhoneNumber = _hocVienRepo.findAll().stream().filter(x ->  x.getSoDienThoai().equals(request.getSoDienThoai()));
        if(checkEmail != null){
            return _hocVienDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Email này đã được sử dụng", null);
        }
        if(checkPhoneNumber != null){
            return _hocVienDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Số điện thoại này đã được sử dụng", null);
        }
        var hocVienThem = _converter.themHocVien(request);
        _hocVienRepo.save(hocVienThem);
        return _hocVienDTOResponseObject.responseSuccess("Thêm học viên thành công", _converter.entityToDTO(hocVienThem));
    }

    public ResponseObject<HocVienDTO> suaHocVien(SuaHocVienRequest request) {
        var checkHocVien = _hocVienRepo.findAll().stream().filter(x -> x.getId() == request.getHocVienId()).findFirst();
        if(checkHocVien.isEmpty()){
            return _hocVienDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Học viên này không tồn tại", null);
        }
        var hocSinhSua = _converter.suaHocVien(checkHocVien.get(), request);
        _hocVienRepo.save(hocSinhSua);
        return _hocVienDTOResponseObject.responseSuccess("Sửa học viên thành công", _converter.entityToDTO(hocSinhSua));
    }

    public String xoaHocVien(int hocVienId) {
        var checkHocVien = _hocVienRepo.findAll().stream().filter(x -> x.getId() == hocVienId).findFirst();
        if(checkHocVien.isEmpty()){
            return "Học viên này không tồn tại";
        }
        _hocVienRepo.delete(checkHocVien.get());
        return "Xóa học viên thành công";
    }

    public Set<HocVienDTO> layHocVien(int pageSize, int pageNumber) {
        return _hocVienRepo.findAll().stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HocVienDTO> layHocVienTheoTen(String tenHocVien, int pageSize, int pageNumber) {
        return _hocVienRepo.findAll().stream()
                .filter(x -> _chuanHoaTenAssistance.chuanHoaTen(x.getHoTen()).contains(_chuanHoaTenAssistance.chuanHoaTen(tenHocVien)))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HocVienDTO> layHocVienThemEmail(String email, int pageSize, int pageNumber) {
        return _hocVienRepo.findAll().stream()
                .filter(x -> _chuanHoaTenAssistance.chuanHoaTen(x.getEmail()).contains(_chuanHoaTenAssistance.chuanHoaTen(email)))
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }
}
