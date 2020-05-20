package com.example.boot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Product;
import com.example.boot.repository.ProductRepository;
import com.example.boot.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer addProduct(Product product) {
		System.out.println(product);
		double cost=product.getProdCost();
		
		double discount = cost * 5/100.0;
		double gst = cost * 12/100.0;

		product.setProdDis(discount);
		product.setProdGst(gst);

		repo.save(product);
		return product.getProdId();
	}

	@Override
	public List<Product> getAll() {

		return repo.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Product findById(Integer id) {
		Product product=repo.findById(id).get();
      
     
		return product;
		
	}

	@Override
	public boolean isExist(Integer id) {
            
		return repo.existsById(id);
	}

	@Override
	public Product updateById(Integer id) {

		return null;
	}
	public void updateProduct(Product product) {
     double cost=product.getProdCost();
		
		double discount = cost * 5/100.0;
		double gst = cost * 12/100.0;

		product.setProdDis(discount);
		product.setProdGst(gst);

		repo.save(product);
		
	}

}
