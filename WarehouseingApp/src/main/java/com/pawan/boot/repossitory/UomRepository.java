package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Integer> {

	@Query("select count(U.uomModel) from Uom U where uomModel=:model")
	Integer countUomModel(String model);
}
