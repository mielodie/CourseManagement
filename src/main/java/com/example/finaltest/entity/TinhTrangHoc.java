package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tinhtranghocs")
@Data
public class TinhTrangHoc extends BaseEntity{
    @Column(name = "tentinhtrang")
    private String tenTinhTrang;
    @OneToMany(mappedBy = "tinhTrangHoc")
    @JsonManagedReference
    private Set<DangKiHoc> dangKiHocs;
}
