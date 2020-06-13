package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.boot.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

}
