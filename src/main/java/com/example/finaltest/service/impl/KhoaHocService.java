package com.example.finaltest.service.impl;

import com.example.finaltest.assistance.ChuanHoaTenAssistance;
import com.example.finaltest.payload.converter.KhoaHocConverter;
import com.example.finaltest.payload.dto.KhoaHocDTO;
import com.example.finaltest.payload.request.KhoaHocRequest.SuaKhoaHocRequest;
import com.example.finaltest.payload.request.KhoaHocRequest.ThemKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.reposiry.KhoaHocRepo;
import com.example.finaltest.reposiry.LoaiKhoaHocRepo;
import com.example.finaltest.service.iKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class KhoaHocService implements iKhoaHocService {
    @Autowired
    private KhoaHocRepo _khoaHocRepo;
    @Autowired
    private LoaiKhoaHocRepo _loaiKhoaHocRepo;
    @Autowired
    private KhoaHocConverter _converter;
    @Autowired
    private ResponseObject<KhoaHocDTO> _khoaHocDTOResponseObject;
    @Autowired
    private ChuanHoaTenAssistance _chuanHoaTenAssistance;
    public ResponseObject<KhoaHocDTO> themKhoaHoc(ThemKhoaHocRequest request) {
        var checkLoaiKhoaHoc = _loaiKhoaHocRepo.findById(request.getLoaiKhoaHocId());
        if(checkLoaiKhoaHoc.isEmpty()){
            return _khoaHocDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Loại khóa học không tồn tại", null);
        }
        var khoaHocThem = _converter.themKhoaHoc(request);
        _khoaHocRepo.save(khoaHocThem);
        return _khoaHocDTOResponseObject.responseSuccess("Thêm khóa học thành công", _converter.entityToDTO(khoaHocThem));
    }

    public ResponseObject<KhoaHocDTO> suaKhoaHoc(SuaKhoaHocRequest request) {
        var checkKhoaHoc = _khoaHocRepo.findById(request.getKhoaKhocId());
        if(checkKhoaHoc.isEmpty()){
            return _khoaHocDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Không tìm thấy khóa học này", null);
        }
        var khoaHocSua = _converter.suaKhoaHoc(checkKhoaHoc.get(), request);
        _khoaHocRepo.save(khoaHocSua);
        return _khoaHocDTOResponseObject.responseSuccess("Sửa khóa học thành công", _converter.entityToDTO(khoaHocSua));
    }

    public String xoaKhoaHoc(int khoaHocId) {
        var checkKhoaHoc = _khoaHocRepo.findById(khoaHocId);
        if(checkKhoaHoc.isEmpty()){
            return "Không tìm thấy khóa học này";
        }
        _khoaHocRepo.delete(checkKhoaHoc.get());
        return "Xóa khóa học thành công";
    }

    public Set<KhoaHocDTO> layKhoaHoc(int pageSize, int pageNumber) {
        return _khoaHocRepo.findAll().stream()
                .skip((pageNumber - 1) * pageNumber)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<KhoaHocDTO> timKiemKhoaHocTheoTen(String tenKhoaHoc, int pageSize, int pageNumber) {
        return _khoaHocRepo.findAll().stream()
                .filter(x -> _chuanHoaTenAssistance.chuanHoaTen(x.getTenKhoaHoc()).equals(_chuanHoaTenAssistance.chuanHoaTen(tenKhoaHoc)))
                .skip((pageNumber - 1) * pageNumber)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }
}
