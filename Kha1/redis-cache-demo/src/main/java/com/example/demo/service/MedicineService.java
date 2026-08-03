package com.example.demo.service;

import com.example.demo.entity.Medicine;
import com.example.demo.repository.MedicineRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Dùng annotation này để lưu vào Redis với key dạng medicines::<id>
    @Cacheable(value = "medicines", key = "#id")
    public Medicine getMedicineById(Long id) {
        // Log này xuất hiện nghĩa là hệ thống PHẢI vào Database để lấy dữ liệu (Cache Miss)
        System.out.println("======> DỮ LIỆU CHƯA CÓ TRONG CACHE. ĐANG TRUY VẤN DATABASE CHO ID: " + id + " <======");

        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thuốc với ID: " + id));
    }

    // Hàm tạo thuốc mới
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}