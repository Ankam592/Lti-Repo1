package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.entity.Employee;

public class Employee_Dao
{
	//we have to insert data into emp_table from here
    private Connection conn;
    public Employee_Dao() throws SQLException
    {
    	conn = Database_Conn.getconn();   // this has to happen every time so we written in constructor.
    }
    public void addEmployee(Employee e) throws SQLException   //we have to import employee from com.lti.entity it is just the data
    {
         PreparedStatement  ps =   conn.prepareStatement("insert into Emp_table(username,password,email) values(?,?,?)");                               // passing our own data with parametres	
         ps.setString(1,e.getUsername());
         ps.setString(2,e.getPassword());
         ps.setString(3,e.getEmail());
         ps.executeUpdate();
         ps.close();
    }
    public void deleteEmployee(String delname) 
    {
    	 PreparedStatement ps=null;
   	try
    	{
    	ps =   conn.prepareStatement("delete from Emp_table where username= ?");                               // passing our own data with parametres	
         ps.setString(1,delname);
         
    	ps.executeUpdate();
    	 ps.close();
    	}
   	catch(SQLException e)
	{
		System.out.println("name you have entered is not their in the table"+e);
	}
    }
    public Employee getEmpbyname(String username) throws SQLException
    {
    	Employee emp1 = new Employee();
    	PreparedStatement ps =  conn.prepareStatement("select * from Emp_table where username = ?");
    	ps.setString(1,username);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next())
    	{
    		emp1.setUsername(rs.getString("username"));
    		emp1.setPassword(rs.getString("password"));
    		emp1.setEmail(rs.getString("email"));
    	}
    	return emp1;
    }
    
}
// when ever we are writing the query we should throws sql exception