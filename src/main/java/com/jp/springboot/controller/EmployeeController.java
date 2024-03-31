package com.jp.springboot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.springboot.entity.Employee;
import com.jp.springboot.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		try {
		employee=employeeRepository.save(employee);
		
		if(employee.getEmployeeId()>0) {
			
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Employee>(employee,HttpStatus.NOT_FOUND);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Employee>>  getAllEmployee(){
		
		List<Employee> employeeList=employeeRepository.findAll();
		
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
	

	@GetMapping("/get/{id}")
	public ResponseEntity<?>  getEmployeeById(@PathVariable int id){
		Employee employee=null;
		try {
			employee=employeeRepository.findById(id).get();
		if(null!=employee) {
			
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Employee Not Found with id= "+id,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>  updateEmployee(@RequestBody Employee employee){
		
		try {
		Employee	employee1=employeeRepository.findById(employee.getEmployeeId()).get();
		if(null!=employee && employee.getEmployeeId()>0) {
			
			BeanUtils.copyProperties(employee, employee1);
			
			employeeRepository.save(employee1);
			
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
	}
}
