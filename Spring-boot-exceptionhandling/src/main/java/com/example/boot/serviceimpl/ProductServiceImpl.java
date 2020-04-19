package com.example.boot.serviceimpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Product;
import com.example.boot.repository.ProductRepository;
import com.example.boot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> addProduct(List<Product> product) {
	
		return repository.saveAll(product);
	}

	@Override
	public Iterable<Product> findAllProduct() {
		
		return repository.findAll();
	}

	@Override
	public Product findById(Integer prodId) {
		
		return repository.findById(prodId).get();
	}

}
