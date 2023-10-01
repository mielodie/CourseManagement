package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "loaibaiviets")
@Data
public class LoaiBaiViet extends BaseEntity {
    @Column(name = "tenloaibaiviet")
    private String tenLoaiBaiViet;
    @OneToMany(mappedBy = "loaiBaiViet")
    @JsonManagedReference
    private Set<ChuDe> chuDes;
}
