package com.example.SpringBootJpaDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringBootJpaDemo.Model.Address;
import com.example.SpringBootJpaDemo.Model.Employee;
import com.example.SpringBootJpaDemo.repository.AddressRepository;
import com.example.SpringBootJpaDemo.repository.EmployeeRepository;
import com.example.SpringBootJpaDemo.vo.AddressForms;
import com.example.SpringBootJpaDemo.vo.EmployeeForm;

@Service
public class Employeeservice implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressrepository;
	
	@Override
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(EmployeeForm employeeForm)
	{
        Employee emp = new Employee();
		emp.setFirstName(employeeForm.getFirstName());
		emp.setLastName(employeeForm.getLastName());
		emp.setEmail(employeeForm.getEmail());
		emp.setCity(employeeForm.getCity());
		emp.setDistrict(employeeForm.getDistrict());
//		Address add =new Address();
//		add.setCity(employeeForm.getCity());
//		add.setState(employeeForm.getState());
           
	    employeeRepository.save(emp);
//	    addressrepository.save(add);
	    
	}
	
//	public User save(UserRegistrationDto registration) {
//        User user = new User();
//        user.setFirstName(registration.getFirstName());
//        user.setLastName(registration.getLastName());
//        user.setEmail(registration.getEmail());
//        user.setPassword(passwordEncoder.encode(registration.getPassword()));
//        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
//        return userRepository.save(user);
//    }	
	
	
	
	@Override
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> optional= employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found for id ::: " +id);
		}
		return employee;
		}
	
	@Override
	public void deleteEmployeeById(int id)
	{
		employeeRepository.deleteById(id);
	}
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1,pageSize);
		
		return employeeRepository.findAll(pageable);
	}
	

	
	}

