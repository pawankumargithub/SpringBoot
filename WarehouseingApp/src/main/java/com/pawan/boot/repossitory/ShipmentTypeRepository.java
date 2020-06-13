package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.boot.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {

}
