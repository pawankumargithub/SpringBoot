package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
