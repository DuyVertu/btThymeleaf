package khanhduy.services;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories") // Tên bảng trong CSDL
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị cho ID
    private Long id;

    private String name;

    // Constructor mặc định
    public Category() {
    }

    // Constructor có tham số
    public Category(String name) {
        this.name = name;
    }

    // Getters và Setters
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
}

