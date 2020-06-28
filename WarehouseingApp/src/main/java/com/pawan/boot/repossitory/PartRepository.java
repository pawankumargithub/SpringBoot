package com.pawan.boot.repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pawan.boot.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {

	@Query("SELECT COUNT(P.partCode) FROM Part P Where P.partCode=:code")
	Integer countByPartCode(String code);
}
