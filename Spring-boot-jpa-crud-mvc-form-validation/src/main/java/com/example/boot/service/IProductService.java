package com.example.boot.service;

import java.util.List;

import com.example.boot.model.Product;

public interface IProductService {

	public Integer addProduct(Product product);

	public List<Product> getAll();

	public void deleteById(Integer id);

	public Product findById(Integer id);

	public boolean isExist(Integer id);

	public Product updateById(Integer id);
}
