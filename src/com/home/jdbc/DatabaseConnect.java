package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnect {

	public static void main(String[] args) {
		
		System.out.println("Welcome to JDBC !!!");

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
//			String uri = "jdbc:mysql://remotemysql.com:3306/HczdjvIxup?characterEncoding=latin1";
//			String userName = "HczdjvIxup";
//			String password = "K3rTDuDl6e";
			
			String uri = "jdbc:mysql://localhost:3306/javatrainers";
			String userName = "root";
			String password = "prasad";

			Connection con = DriverManager.getConnection(uri, userName, password);

			Statement stmt = con.createStatement();
			
			con.setAutoCommit(false);
			
			 String sql = "CREATE TABLE STUDENTS " +
	                   "(id INTEGER not NULL, " +
	                   " first_name VARCHAR(255), " + 
	                   " last_name VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))";
			 
			 String insertQuery = "INSERT INTO STUDENTS VALUES (1, 'Prasad', 'Vydani', 1)";
			 String insertQuery2 = "INSERT INTO student VALUES('2', 'Bhavani', 'Muthangi');";
			 
			 stmt.executeUpdate(insertQuery2);

			con.commit();
			con.close();
			
			System.out.println("Completed....!!!");

		} catch (Exception e) {
			
			System.out.println(e);
			
		}

	}
}
