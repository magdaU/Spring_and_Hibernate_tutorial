package com.github.magdau.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";		
		
		try {
			System.out.println("Connection to database" + jdbcURL);		
			Connection myConnection = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection sucessful!");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
