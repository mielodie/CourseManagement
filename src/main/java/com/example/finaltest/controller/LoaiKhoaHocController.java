package com.example.finaltest.controller;

import com.example.finaltest.payload.dto.LoaiKhoaHocDTO;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.SuaLoaiKhoaHocRequest;
import com.example.finaltest.payload.request.LoaiKhoaHocRequest.ThemLoaiKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.service.impl.LoaiKhoaHocService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class LoaiKhoaHocController {
    private final LoaiKhoaHocService _loaiKhoaHocService;

    public LoaiKhoaHocController(LoaiKhoaHocService loaiKhoaHocService) {
        _loaiKhoaHocService = loaiKhoaHocService;
    }

    @PostMapping(value = "themloaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(@RequestBody ThemLoaiKhoaHocRequest request) {
        return _loaiKhoaHocService.themLoaiKhoaHoc(request);
    }

    @PutMapping(value = "sualoaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(@RequestBody SuaLoaiKhoaHocRequest request) {
        return _loaiKhoaHocService.suaLoaiKhoaHoc(request);
    }

    @DeleteMapping(value = "xoaloaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaLoaiKhoaHoc(@RequestParam int loaiKhoaHocId) {
        return _loaiKhoaHocService.xoaLoaiKhoaHoc(loaiKhoaHocId);
    }

    @GetMapping(value = "layloaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<LoaiKhoaHocDTO> themLoaiKhoaHoc(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _loaiKhoaHocService.layLoaiKhoaHoc(pageSize, pageNumber);
    }
}
