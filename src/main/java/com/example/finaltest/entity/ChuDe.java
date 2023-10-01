package com.example.finaltest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chudes")
@Data
public class ChuDe extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "loaibaivietid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;
    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;
    @Column(name = "tenchude")
    private String tenChuDe;
    @Column(name = "noidung")
    private String noiDung;
    @OneToMany(mappedBy = "chuDe")
    @JsonManagedReference
    private Set<BaiViet> baiViets;
}
