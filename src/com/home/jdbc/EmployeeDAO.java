package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainers", "root", "prasad");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			
			Employee employee = new Employee();	
			
			
			while(rs.next()) {
				
				employee.setEmployeeId(rs.getInt(1));
				employee.setLastName(rs.getString(2));
				employee.setFirstName(rs.getString(3));
				employee.setAddress(rs.getString(4));
				employee.setCity(rs.getString(5));
			}
			
			System.out.println(employee);			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
