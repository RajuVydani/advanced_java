package com.home.jdbc;

//DTO - Data Transfer Object
public class Employee {
	
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", city=" + city + "]";
	}

	public int getEmployeeId() {
		return employeeId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	

}
