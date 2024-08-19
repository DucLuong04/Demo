package com.example.demo.dto.respon;

import jakarta.persistence.Column;

public interface NhaRespon {

    Integer getId();

    String getDia_chi_nha();

    String getLoai_nha();

    Double getGia_tien();

    String getTenCN();

    String getDia_chi();

    String getSo_dien_thoai();

    String getEmail();
}
