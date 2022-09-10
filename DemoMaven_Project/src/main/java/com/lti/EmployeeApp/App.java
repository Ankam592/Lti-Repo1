package com.lti.EmployeeApp;
import java.util.*;
import java.sql.SQLException;

import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class App
{
	public static void main(String[] args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		String delname = sc.nextLine();
		System.out.println();
		Employee_Dao  dao = new Employee_Dao();
		Employee e1 = new Employee();
		e1.setUsername("nithish");
		e1.setPassword("1234t");
		e1.setEmail("nithish!2@gmail.com");
	//	dao.addEmployee(e1);
		System.out.println("Employee added successfully");
		dao.deleteEmployee(delname);
		System.out.println("Employee deleted Successfully "+delname);
		
		
		
	}
	

}
