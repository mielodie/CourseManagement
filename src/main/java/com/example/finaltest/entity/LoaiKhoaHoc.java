package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "loaikhoahocs")
@Data
public class LoaiKhoaHoc extends BaseEntity {
    @Column(name = "tenloaikhoahoc")
    private String tenLoaiKhoaHoc;
    @OneToMany(mappedBy = "loaiKhoaHoc")
    @JsonManagedReference
    private Set<KhoaHoc> khoaHocs;
}
