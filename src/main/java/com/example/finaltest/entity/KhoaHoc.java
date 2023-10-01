package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "khoahocs")
@Data
public class KhoaHoc extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "loaikhoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiKhoaHoc loaiKhoaHoc;
    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocId;
    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;
    @Column(name = "thoigianhoc")
    private int thoiGianHoc;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "hocphi")
    private double hocPhi;
    @Column(name = "sohocvien")
    private int soHocVien = 0;
    @Column(name = "soluongmon")
    private int soLuongMon;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @OneToMany(mappedBy = "khoaHoc")
    @JsonManagedReference
    private Set<DangKiHoc> dangKiHocs;
}
