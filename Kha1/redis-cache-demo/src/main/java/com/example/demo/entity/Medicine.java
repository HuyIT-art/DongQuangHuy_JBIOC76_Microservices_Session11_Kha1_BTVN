package com.example.demo.entity;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medicines")
public class Medicine implements Serializable {

    // Bắt buộc phải implement Serializable để lưu được vào Redis
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    // Constructor trống (bắt buộc cho JPA)
    public Medicine() {
    }

    // Constructor có tham số
    public Medicine(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
