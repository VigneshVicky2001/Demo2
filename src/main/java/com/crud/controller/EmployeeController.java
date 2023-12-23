package com.crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;


@RestController										//we have to call controller to get input
public class EmployeeController {
	
	@Autowired										//autowire to connect between classes in other class
	private EmployeeService employeeService;
	
	@PostMapping("/saveemp")						//postmapping annotation to give a name for method that can be accessed in API interface
	public Object saveEmp(@RequestBody Employee employee) {			//we're requesting to the body to set the value
		return (employeeService.saveEmployee(employee));	
	}
	
	@GetMapping("/getallemp")
	public Object getEmp() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getbyid/{empId}")
	public Object getEmpById(@PathVariable int empId) {				//we're requesting to fetch a single variable using Id so we're using path variable with the id
		return employeeService.getEmployeeById(empId);
	}
	
	@PutMapping("/updateemp")
	public Object updateEmp(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);	
	}
	
	@DeleteMapping("/deleteemp/{empId}")
	public Object deleteEmp(@PathVariable int empId) {
		return employeeService.deleteEmpById(empId);
	}
	
	@GetMapping("/getbydept")
	public Object getEmpByDept(@RequestParam String department) {
		return employeeService.getEmployeeByDept(department);
	}
}
