package com.example.SpringBootJpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootJpaDemo.Model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
