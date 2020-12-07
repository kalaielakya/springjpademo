package com.example.SpringBootJpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringBootJpaDemo.Model.Address;
import com.example.SpringBootJpaDemo.Model.Employee;
import com.example.SpringBootJpaDemo.service.EmployeeServiceInterface;
import com.example.SpringBootJpaDemo.service.Employeeservice;
import com.example.SpringBootJpaDemo.vo.EmployeeForm;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInter;
	
	@Autowired
	private Employeeservice employeeService;
	
	//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		//model.addAttribute("listEmployees", employeeServiceInter.getAllEmployees());
	    //return "index";
		return findPaginated(1,model);
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		//create model attribute to bind form data
		Employee employee = new Employee();
		// thymeleaf template will access the empty employee object for binding form data
		model.addAttribute("employee1",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")EmployeeForm employee)
	{
		// save employee to database
		
		employeeService.saveEmployee(employee);
		
		//employeeServiceInter.saveEmployee(employeeForm, addressForms);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
		// get employee from the service
		Employee employee = employeeServiceInter.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
		}
	
	@GetMapping("/showFormForDelete/{id}")
     public String showFormForDelete(@PathVariable (value = "id") int id)
     {
    	 //call delete employee by id
		employeeServiceInter.deleteEmployeeById(id);
		return "redirect:/";
		
     }
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,Model model) {
		
		int pageSize = 5;
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("listEmployees", listEmployees);
		
		
		return "index";
		
	}
}
