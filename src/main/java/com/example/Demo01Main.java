package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01Main {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "nilesh";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			try(Statement stmt = con.createStatement()) {
				String sql = "SELECT * FROM students";
				try(ResultSet rs = stmt.executeQuery(sql)) {
					while(rs.next()) {
						int roll = rs.getInt("roll");
						String name = rs.getString("name");
						double marks = rs.getDouble("marks");
						System.out.println(roll + ", " + name + ", " + marks);
					}
				} // rs.close()
			} // stmt.close()
		} // con.close()
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}








