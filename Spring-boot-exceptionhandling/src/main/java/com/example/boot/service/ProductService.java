package com.example.boot.service;

import java.util.List;

import com.example.boot.model.Product;

public interface ProductService {

	public List<Product> addProduct(List<Product> product);
	public Iterable<Product> findAllProduct();
	public Product findById(Integer prodId);
}
