package com.crud.serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Employee;
import com.crud.repository.EmployeeRepo;
import com.crud.service.EmployeeService;


@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Object saveEmployee(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(employee.getEmpName().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the employee name");
		}
		
		else if(employee.getDepartment().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the employee department");
		}
		
		else if(employee.getDob() == null) {
			map.put("status", "error");
			map.put("msg", "Please enter the employee department");
		}
		
		else if(employee.getSalary() == 0.0) {
			map.put("status", "error");
			map.put("msg", "Please enter the salary");
		}
		
		else {
			employeeRepo.save(employee);
			map.put("status", "success");
			map.put("msg", "Data saved successfully.");
		}
		return map;
	}

	@Override
	public Object getAllEmployees() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Employee> employees = employeeRepo.findAll();
		for(Employee e: employees) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Employee ID", e.getEmpId());
			map.put("Employee Name", e.getEmpName());
			map.put("Employee DoB", e.getDob());
			map.put("Employee Dept", e.getDepartment());
			map.put("Employee Salary", e.getSalary());
			list.add(map);
		}
		return list;
	}

	@Override
	public Object getEmployeeById(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee employee = employeeRepo.findById(empId).orElse(null);
		if(employee != null) {
			map.put("Employee ID", employee.getEmpId());
			map.put("Employee Name", employee.getEmpName());
			map.put("Employee DoB", employee.getDob());
			map.put("Employee Dept", employee.getDepartment());
			map.put("Employee Salary", employee.getSalary());
			return map;
		}
		return null;
	}

	@Override
	public Object updateEmployee(Employee employee) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(employee.getEmpName().isEmpty() &&  employee.getEmpName() == null) {
			map.put("status", "error");
			map.put("msg", "Please enter the employee name");
		}
		
		else if(employee.getDepartment().isEmpty()) {
			map.put("status", "error");
			map.put("msg", "Please enter the employee department");
		}
		
//		else if(employee.getDob() == null) {
//			map.put("status", "error");
//			map.put("msg", "Please enter the employee department");
//		}
//		
		else if(employee.getSalary() == 0.0) {
			map.put("status", "error");
			map.put("msg", "Please enter the salary");
		}
		
		else {
			employeeRepo.saveAndFlush(employee);					//
			map.put("status", "success");
			map.put("msg", "Data updated successfully.");
		}	
		return map;
	}

	@Override
	public Object deleteEmpById(int empId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee employee = employeeRepo.findById(empId).orElse(null);
		if(employee != null) {
			employeeRepo.delete(employee);
			map.put("status", "success");
			map.put("msg", "Data deleted successfully");
		}
		else {
			map.put("status", "error");
			map.put("status", "ID not found");
		}
		return map;
	}

	@Override
	public Object getEmployeeByDept(String department) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Employee> employees = employeeRepo.findEmpByDept(department);
		for(Employee e: employees) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Employee ID", e.getEmpId());
			map.put("Employee Name", e.getEmpName());
			map.put("Employee DoB", e.getDob());
			map.put("Employee Dept", e.getDepartment());
			map.put("Employee Salary", e.getSalary());
			list.add(map);
		}
		return list;
	}
}
