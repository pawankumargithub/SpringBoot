package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {

	@Query("SELECT COUNT(ST.shipmentCode) FROM ShipmentType ST WHERE ST.shipmentCode=:code ")
	public Integer getshipmentCodeCount(String code);
}
