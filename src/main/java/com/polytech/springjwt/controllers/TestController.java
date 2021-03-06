package com.polytech.springjwt.controllers;

import com.polytech.springjwt.employeemanager.model.Employee;
import com.polytech.springjwt.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	private final EmployeeService employeeService;
	public TestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@GetMapping("employee/find/{id}")
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	@GetMapping("employee/all")
	public ResponseEntity<List<Employee>> getAllEmployees () {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	@PostMapping("employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@PutMapping("employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("employee/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}



}
