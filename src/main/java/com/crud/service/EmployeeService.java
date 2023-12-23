package com.crud.service;

import com.crud.model.Employee;

public interface EmployeeService {
	
	public Object saveEmployee(Employee employee);
	public Object getAllEmployees();
	public Object getEmployeeById(int empId);
	public Object updateEmployee(Employee employee);
	public Object deleteEmpById(int empId);
	public Object getEmployeeByDept(String department);
}
