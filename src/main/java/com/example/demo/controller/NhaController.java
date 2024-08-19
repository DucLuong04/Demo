package com.example.demo.controller;

import com.example.demo.dto.request.NhaRequest;
import com.example.demo.dto.respon.NhaRespon;
import com.example.demo.entity.Nha;
import com.example.demo.reponsitory.NhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nha")
public class NhaController {

    @Autowired
    private NhaRepository repo;

    @GetMapping("/hienthi")
    public ResponseEntity<?> hienThi() {
        return ResponseEntity.ok(repo.find2());
    }

    @GetMapping("/hienthi2")
    public ResponseEntity<?> hienThi2() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/phantrang")
    public ResponseEntity<?> phanTrang(@RequestParam(value = "noPage", defaultValue = "0") Integer noPage) {
        int size = 5;
        Pageable pageable = PageRequest.of(noPage, size);
        return ResponseEntity.ok(repo.phanTrang(pageable));
    }

    @PutMapping("/update")
    public String update(@RequestBody NhaRequest nhaRequest) {
        Nha nha = new Nha();
        nha.setId(nhaRequest.getId());
        nha.setDia_chi_nha(nhaRequest.getDia_chi_nha());
        nha.setLoai_nha(nhaRequest.getLoai_nha());
        nha.setGia_tien(nhaRequest.getGia_tien());
        nha.setChuNha(nhaRequest.getChuNha());
        Nha nha1 = repo.save(nha);
        if (nha1 != null) {
            return "Update thanh cong!";
        } else {
            return "Update that bai!";
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @GetMapping("/fill")
    public List<Nha> fill() {
        return repo.findAll().stream().max(Comparator.comparing(Nha::getGia_tien)).stream().toList();
    }

}
