package com.lti.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Conn
{
	public static Connection getconn() throws SQLException
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String Username = "system";
		String password = "12345";
		Connection conn = DriverManager.getConnection(url,Username,password);
		if(conn!=null)
		{
			System.out.println("Database connected");
		}
		
		return conn;
		
	}
	public static void main(String[] args) throws SQLException,ClassCastException
	{
		getconn();
		
	}


}
