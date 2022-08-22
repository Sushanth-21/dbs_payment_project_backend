package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.database.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Optional<Employee> findByEmployeeName(String employeeName);
	Optional<Employee> findByEmployeeId(int employeeId);

}
