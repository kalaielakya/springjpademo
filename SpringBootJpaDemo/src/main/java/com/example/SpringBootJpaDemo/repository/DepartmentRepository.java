package com.example.SpringBootJpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJpaDemo.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
