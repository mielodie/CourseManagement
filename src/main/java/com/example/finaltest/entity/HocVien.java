package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "hocviens")
@Data
public class HocVien extends BaseEntity {
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "email")
    private String email;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "diachi")
    private String diaChi;
    @OneToMany(mappedBy = "hocVien")
    @JsonManagedReference
    private Set<DangKiHoc> dangKiHocs;
}
