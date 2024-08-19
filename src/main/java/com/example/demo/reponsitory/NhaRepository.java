package com.example.demo.reponsitory;

import com.example.demo.dto.respon.NhaRespon;
import com.example.demo.entity.Nha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaRepository extends JpaRepository<Nha, Integer> {

    @Query(value = """
            select a.id,a.dia_chi_nha,a.loai_nha,a.gia_tien,b.tenCN,b.dia_chi,b.so_dien_thoai,b.email
                      from nha a join chu_nha b on a.chu_nha_id=b.id
            """,nativeQuery = true)
    List<NhaRespon> find2();

    @Query(value = """
            select a.id,a.dia_chi_nha,a.loai_nha,a.gia_tien,b.tenCN,b.dia_chi,b.so_dien_thoai,b.email
                      from nha a join chu_nha b on a.chu_nha_id=b.id
            """,nativeQuery = true)
    Page<NhaRespon> phanTrang(Pageable pageable);
}
