package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.boot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
