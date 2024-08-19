package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nha")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String dia_chi_nha;

    @Column
    private String loai_nha;

    @Column
    private Double gia_tien;

    @ManyToOne
    @JoinColumn(name = "chu_nha_id",referencedColumnName = "id")
    private ChuNha chuNha;
}
