package com.example.finaltest.controller;

import com.example.finaltest.payload.dto.KhoaHocDTO;
import com.example.finaltest.payload.request.KhoaHocRequest.SuaKhoaHocRequest;
import com.example.finaltest.payload.request.KhoaHocRequest.ThemKhoaHocRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.service.impl.KhoaHocService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class KhoaHocController {
    private final KhoaHocService _khoaHocService;
    public KhoaHocController(KhoaHocService khoaHocService){
        _khoaHocService = khoaHocService;
    }
    @PostMapping(value = "themkhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> themKhoaHoc(@RequestBody ThemKhoaHocRequest request){
        return _khoaHocService.themKhoaHoc(request);
    }
    //???
    @PutMapping(value = "suakhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> suaKhoaHoc(@RequestBody SuaKhoaHocRequest request){
        return _khoaHocService.suaKhoaHoc(request);
    }
    @DeleteMapping(value = "xoakhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaKhoaHoc(@RequestParam int khoaHocId){
        return _khoaHocService.xoaKhoaHoc(khoaHocId);
    }
    @GetMapping(value = "laykhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<KhoaHocDTO> layKhoaHoc(@RequestParam int pageSize, @RequestParam int pageNumber){
        return _khoaHocService.layKhoaHoc(pageSize, pageNumber);
    }
    @GetMapping(value = "timkiemkhoahoctheoten", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<KhoaHocDTO> timKiemKhoaHocTheoTen(@RequestParam String tenKhoaHoc, @RequestParam int pageSize, @RequestParam int pageNumber){
        return _khoaHocService.timKiemKhoaHocTheoTen(tenKhoaHoc, pageSize, pageNumber);
    }
}
