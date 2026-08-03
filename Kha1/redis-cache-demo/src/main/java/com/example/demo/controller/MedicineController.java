package com.example.demo.controller;

import com.example.demo.entity.Medicine;
import com.example.demo.service.MedicineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // API 1: Tạo thuốc mẫu
    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    // API 2: Lấy chi tiết thuốc theo ID (Có áp dụng Cache)
    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }
}