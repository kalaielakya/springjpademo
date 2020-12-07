package com.example.SpringBootJpaDemo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
	@Column(name = "first_Name")
	private String firstName;
    @Column(name = "last_name")
	private String lastName;
    @Column(name = "email")
	private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="addressid")
//    private Address address;
//    @OneToMany(targetEntity =Department.class, cascade= CascadeType.ALL)
//    @JoinColumn(name = "dep_emp", referencedColumnName = "depId")
//    private List<Department> department;
//    
//    public List<Department> getDepartment() {
//		return department;
//	}
//	public void setDepartment(List<Department> department) {
//		this.department = department;
//	}
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Employee()
    {
    	
    }

	public Employee(int id, String firstName, String lastName, String email, String city, String district) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.district = district;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public int getEmpCode() {
//		return empCode;
//	}
//	public void setEmpCode(int empCode) {
//		this.empCode = empCode;
//	}

	
}
