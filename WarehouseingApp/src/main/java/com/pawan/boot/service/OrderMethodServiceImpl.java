package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.boot.model.OrderMethod;
import com.pawan.boot.repossitory.OrderMethodRepository;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private OrderMethodRepository repo;
	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
	
		
		return repo.save(orderMethod).getId();
	}

	@Override
	public void updateorderMethod(OrderMethod orderMethod) {
		
		repo.save(orderMethod);

	}

	@Override
	public void deleteorderMethod(Integer id) {
	
		repo.deleteById(id);

	}

	@Override
	public List<OrderMethod> getAllorderMethods() {
	
		return repo.findAll();
	}

	@Override
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
	
		Optional<OrderMethod> opt=repo.findById(id);
		return opt;
	}

	@Override
	public boolean isExist(Integer id) {
		
		return repo.existsById(id);
	}

}
