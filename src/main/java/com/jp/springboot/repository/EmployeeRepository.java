package com.jp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	  Employee findByAddress(String address);
}
