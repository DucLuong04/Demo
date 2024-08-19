package com.example.demo.dto.request;

import com.example.demo.entity.ChuNha;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhaRequest {

    private Integer id;

    private String dia_chi_nha;

    private String loai_nha;

    private Double gia_tien;

    private ChuNha chuNha;
}
