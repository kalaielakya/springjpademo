package com.example.SpringBootJpaDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJpaDemo.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//Optional<Employee> findByempCode(Integer empCode);

	
}
