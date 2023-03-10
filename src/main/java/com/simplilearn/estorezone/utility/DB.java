package com.simplilearn.estorezone.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	
	private final String DB_URL = "jdbc:mysql://localhost:3306/estore_zone_db";
	private final String DB_USERNAME = "root";
	private final String  DB_PASSWORD = "Yellow#123";
	
	private Connection connection;
	private Statement statement;
	
	//Register the Driver class
	public DB() {
		try {
			getClass().forName("com.mysql.cj.jdbc.Driver");
			System.out.println("-- JDBC Driver Loaded. --");
		} catch(Exception e) {
			System.out.println("-- Something Went Wrong: --");
		}
	}
	
	//Initialize DB Connection
	public void init() {
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			statement = connection.createStatement();
			System.out.println("-- Connection established. --");		
		} catch(Exception e) {
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		}
	}
	
	//Close DB Connection
	public void destroy() {
		try {
			if(connection!=null) {
				connection.close();
				connection = null;
				System.out.println("-- Connection closed. --");
			}	
		} catch(Exception e) {
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		}
	}
	
	//Get DB Connection
	public Connection getConnection() {
		return connection;
	}
	
	//select operation
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;  //ResultSet is logical object that consist of rows and columns
		try {
			System.out.println("-- Executing SQL --"+sql);
			rs = statement.executeQuery(sql);
			System.out.println("-- Query Executed Successfully. --");
		} catch(Exception e) {
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		}
		return rs;
	}
	
	//save, update and delete
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			System.out.println("-- Executing SQL --"+sql);
			result = statement.executeUpdate(sql);
			System.out.println("-- Query Executed Successfully. --");
		} catch(Exception e) {
			System.out.println("-- Something Went Wrong: --"+ e.getMessage());
		}
		return result;
	}

	

}
