package com.example.finaltest.controller;

import com.example.finaltest.payload.dto.HocVienDTO;
import com.example.finaltest.payload.request.HocVienRequest.SuaHocVienRequest;
import com.example.finaltest.payload.request.HocVienRequest.ThemHocVienRequest;
import com.example.finaltest.payload.response.ResponseObject;
import com.example.finaltest.service.impl.HocVienService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class HocVienController {
    private final HocVienService _hocVienService;

    public HocVienController(HocVienService hocVienService) {
        _hocVienService = hocVienService;
    }

    //???
    @PostMapping(value = "themhocvien", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> themHocVien(@RequestBody ThemHocVienRequest request) {
        return _hocVienService.themHocVien(request);
    }

    @PutMapping(value = "suahocvien", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> suaHocVien(@RequestBody SuaHocVienRequest request) {
        return _hocVienService.suaHocVien(request);
    }

    @DeleteMapping(value = "xoahocvien", produces = MediaType.APPLICATION_JSON_VALUE)
    public String themHocVien(@RequestParam int hocVienId) {
        return _hocVienService.xoaHocVien(hocVienId);
    }

    @GetMapping(value = "layhocvien", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HocVienDTO> layHocVien(int pageSize, int pageNumber) {
        return _hocVienService.layHocVien(pageSize, pageNumber);
    }

    @GetMapping(value = "layhocvientheoten", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HocVienDTO> layHocVienTheoTen(String tenHocVien, int pageSize, int pageNumber) {
        return _hocVienService.layHocVienTheoTen(tenHocVien, pageSize, pageNumber);
    }

    @GetMapping(value = "layhocvientheoemail", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HocVienDTO> layHocVienThemEmail(String email, int pageSize, int pageNumber) {
        return _hocVienService.layHocVienThemEmail(email, pageSize, pageNumber);
    }
}
