package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public static void main(String[] args) {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
//		employeeDAO.getEmployee();
//		employeeDAO.addEmployee();
//		employeeDAO.addpsEmployee();
		employeeDAO.batchEmployee();
		
	}
	
	private void batchEmployee() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainers", "root", "prasad");
			
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			stmt.addBatch("INSERT INTO employees VALUES('1', 'Vydani', 'Prasad', 'Chitkul', 'Hyderabad')");
			stmt.addBatch("INSERT INTO employees VALUES('2', 'Vydani', 'Bhavani', 'Chitkul', 'Hyderabad')");
			stmt.addBatch("INSERT INTO employees VALUES('3', 'Mallada', 'Manikanta', 'Chitkul', 'Hyderabad')");
			
			int[] count = stmt.executeBatch();
			
			con.commit();
			
			for(int i=0; i < count.length; i++) {
				
				System.out.println("Count :: " + count[i]);
			}
			
						
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private void addpsEmployee() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainers", "root", "prasad");
			
			con.setAutoCommit(false);
			
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO student VALUES(?, ?, ?)");
			pstmt.setInt(1, 4);
			pstmt.setString(2, "Tulasi");
			pstmt.setString(3, "Hyderabad");
			
			int insertedRecords = pstmt.executeUpdate();
			
			System.out.println("No of records inserted :: " + insertedRecords);
			
			if(true) {
				con.rollback();
			}
			
			con.commit();
			
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private void addEmployee() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainers", "root", "prasad");
			
			Statement stmt = con.createStatement();
			
			int insertRecords = stmt.executeUpdate("INSERT INTO employees VALUES('2', 'Vydani', 'Bhavani', 'Chitkul', 'Hyderabad')");
			int insertRecords2 = stmt.executeUpdate("INSERT INTO employees VALUES('3', 'Mallada', 'Manikantavarma', 'Chitkul', 'Hyderabad')");
//			System.out.println("Total Records inserted :: " + insertRecords);
//			System.out.println("Total Records inserted :: " + insertRecords2);
//			
//			int updatedRecords = stmt.executeUpdate("UPDATE employees SET Address = 'Muthangi' WHERE employeeid = 2");
//			System.out.println("Total Records updated :: " + updatedRecords);
//			
//			int deletedRecords = stmt.executeUpdate("DELETE FROM employees WHERE employeeid IN (1,3)");
//			System.out.println("Total Records deleted :: " + deletedRecords);			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	private void getEmployee() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatrainers", "root", "prasad");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				
				Employee employee = new Employee();
				
				employee.setEmployeeId(rs.getInt(1));
				employee.setLastName(rs.getString(2));
				employee.setFirstName(rs.getString(3));
				employee.setAddress(rs.getString(4));
				employee.setCity(rs.getString(5));
				
				employeeList.add(employee);
			}
			
			System.out.println(employeeList);			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
