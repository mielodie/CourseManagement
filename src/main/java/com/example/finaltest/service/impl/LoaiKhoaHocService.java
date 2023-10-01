package com.example.finaltest.service.impl;

import com.example.finaltest.payload.converter.LoaiKhoaHocConverter;
import com.example.finaltest.payload.dto.LoaiKhoaHocDTO;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.SuaLoaiKhoaHocRequest;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.ThemLoaiKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.reposiry.LoaiKhoaHocRepo;
import com.example.finaltest.service.iLoaiKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoaiKhoaHocService implements iLoaiKhoaHocService {
    @Autowired
    private LoaiKhoaHocRepo _loaiKhoaHocRepo;
    @Autowired
    private LoaiKhoaHocConverter _converter;
    @Autowired
    private ResponseObject<LoaiKhoaHocDTO> _loaiKhoaHocDTOResponseObject;
    public ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(ThemLoaiKhoaHocRequest request) {
        var loaiKhoaHocThem = _converter.themLoaiKhoaHoc(request);
        _loaiKhoaHocRepo.save(loaiKhoaHocThem);
        return _loaiKhoaHocDTOResponseObject.responseSuccess("Thêm loại khóa học thành công", _converter.entityToDTO(loaiKhoaHocThem));
    }

    public ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(SuaLoaiKhoaHocRequest request) {
        var checkLoaiKhoaHoc = _loaiKhoaHocRepo.findById(request.getLoaiKhoaHocId());
        if(checkLoaiKhoaHoc.isEmpty()){
            return _loaiKhoaHocDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Không tìm thấy loại khoá học này", null);
        }
        var loaiKhoaHocSua = _converter.suaLoaiKhoaHoc(checkLoaiKhoaHoc.get(), request);
        _loaiKhoaHocRepo.save(loaiKhoaHocSua);
        return _loaiKhoaHocDTOResponseObject.responseSuccess("Sửa loại khóa học thành công", _converter.entityToDTO(loaiKhoaHocSua));
    }

    public String xoaLoaiKhoaHoc(int loaiKhoaHocId) {
        var checkLoaiKhoaHoc = _loaiKhoaHocRepo.findById(loaiKhoaHocId);
        if(checkLoaiKhoaHoc.isEmpty()){
            return "Không tìm thấy loại khoá học này";
        }
        _loaiKhoaHocRepo.delete(checkLoaiKhoaHoc.get());
        return "Xóa loại khóa học thành công";
    }

    public Set<LoaiKhoaHocDTO> layLoaiKhoaHoc(int pageSize, int pageNumber) {
        return _loaiKhoaHocRepo.findAll().stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .map(x -> _converter.entityToDTO(x))
                .collect(Collectors.toSet());
    }
}
