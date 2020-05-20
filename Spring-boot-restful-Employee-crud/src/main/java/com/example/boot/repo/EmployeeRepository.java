package com.example.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.boot.model.EmployeeBO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBO, Integer> {

	public EmployeeBO findByName(String name);
}
