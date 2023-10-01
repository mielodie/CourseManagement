package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "quyenhans")
@Data
public class QuyenHan extends BaseEntity {
    @Column(name = "tenquyenhan")
    private String tenQuyenHan;
    @OneToMany(mappedBy = "quyenHan")
    @JsonManagedReference
    private Set<TaiKhoan> taiKhoans;
}
