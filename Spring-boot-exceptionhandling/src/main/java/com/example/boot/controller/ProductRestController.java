package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.exception.ProductNotFoundException;
import com.example.boot.model.Product;
import com.example.boot.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public List<Product> save(@RequestBody List<Product> product) {
		return service.addProduct(product);
	}

	@GetMapping("/all")
	public Iterable<Product> findAllProduct() {

		Iterable<Product> products= service.findAllProduct();
		if(products==null)
			throw new ProductNotFoundException("product is not available");
		return products;
	}
	@GetMapping("/byid/{prodId}")
public Product findById(@PathVariable Integer prodId) {
		Product productId=null;
		try {
			 productId= service.findById(prodId);
		}
		catch(Exception e) {
			throw new ProductNotFoundException("product not found with given id");
		}
		return productId;
	}
}
