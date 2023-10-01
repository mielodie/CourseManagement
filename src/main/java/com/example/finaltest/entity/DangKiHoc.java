package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "dangkihocs")
@Data
public class DangKiHoc extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "khoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private KhoaHoc khoaHoc;
    @Column(name = "khoahocid")
    private int khoaHocId;
    @ManyToOne
    @JoinColumn(name = "hocvienid", insertable = false, updatable = false)
    @JsonBackReference
    private HocVien hocVien;
    @Column(name = "hocvienid")
    private int hocVienId;
    @ManyToOne
    @JoinColumn(name = "tinhtranghocid", insertable = false, updatable = false)
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;
    @Column(name = "tinhtranghocid")
    private int tinhTrangHocId;
    @ManyToOne
    @JoinColumn(name = "taikhoanid", insertable = false, updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;
    @Column(name = "taikhoanid")
    private int taiKhoanId;
    @Column(name = "ngaydangki")
    private LocalDate ngayDangKi;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
}
