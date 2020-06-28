package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

	@Query("select count(O.orderCode) from OrderMethod O where O.orderCode=:code")
	Integer countOrderCode(String code);
}
