package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "baiviets")
@Data
public class BaiViet extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "chudeid", insertable = false, updatable = false)
    @JsonBackReference
    private ChuDe chuDe;
    @Column(name = "chudeid")
    private int chuDeId;
    @ManyToOne
    @JoinColumn(name = "taikhoanid", insertable = false, updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;
    @Column(name = "taikhoanid")
    private int taiKhoanId;
    @Column(name = "tenbaiviet")
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;
    @Column(name = "tentacgia")
    private String tenTacGia;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "hinhanh")
    private String HinhAnh;
}
