package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "taikhoans")
@Data
public class TaiKhoan extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "quyenhanid", insertable = false, updatable = false)
    @JsonBackReference
    private QuyenHan quyenHan;
    @Column(name = "quyenhanid")
    private int quyenHanId;
    @Column(name = "tennguoidung")
    private String tenNguoiDung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @OneToMany(mappedBy = "taiKhoan")
    @JsonManagedReference
    private Set<BaiViet> baiViets;
    @OneToMany(mappedBy = "taiKhoan")
    @JsonManagedReference
    private Set<DangKiHoc> dangKiHocs;
}
