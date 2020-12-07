package com.example.SpringBootJpaDemo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.SpringBootJpaDemo.Model.Employee;
import com.example.SpringBootJpaDemo.vo.AddressForms;
import com.example.SpringBootJpaDemo.vo.EmployeeForm;

public interface EmployeeServiceInterface {

	List<Employee> getAllEmployees();
	void saveEmployee(EmployeeForm employeeForm);
	Employee getEmployeeById(int id);
	void deleteEmployeeById(int id);
    Page<Employee> findPaginated(int pageNo,int pageSize);
}
