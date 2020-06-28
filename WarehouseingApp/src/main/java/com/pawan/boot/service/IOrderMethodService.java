package com.pawan.boot.service;

import java.util.List;
import java.util.Optional;

import com.pawan.boot.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod orderMethod);

	void updateorderMethod(OrderMethod orderMethod);

	void deleteorderMethod(Integer id);

	List<OrderMethod> getAllorderMethods();

	Optional<OrderMethod> getOneOrderMethod(Integer id);

	boolean isExist(Integer id);

	boolean isOrderMethodCodeExist(String code);
}
