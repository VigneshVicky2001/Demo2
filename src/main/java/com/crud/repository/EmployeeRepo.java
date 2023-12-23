package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.model.Employee;

@Repository						//Actual repository where the method is abstracted with JPA Repository with arguments of object of Employee table and the integer referring to the Employee ID
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query("select e from Employee e where e.department = :department")
	List<Employee> findEmpByDept(@Param("department") String department);
	
	
}
