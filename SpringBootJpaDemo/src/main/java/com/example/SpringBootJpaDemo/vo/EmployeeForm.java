package com.example.SpringBootJpaDemo.vo;


public class EmployeeForm {

	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String district;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public String getDistrict()
//	{
//		return district;
//	}
//	public void setDistrict()
//	{
//		this.district=district;
//	}

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
	
}
