package com.lti.newApp;
import com.lti.dao.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.lti.dao.Database_Conn;
import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class TestDbconn 
{
	public static Employee_Dao dao;
//	@BeforeAll
//    static void init() throws SQLException {
//        Connection conn = Database_Conn.getconn();
//        try {
//            // set auto commit false so any operation in this test will be discarded.
//            conn.setAutoCommit(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//       // emp_dao = new Employee_dao(conn);
//    }
//     
//    @AfterAll
//    static void teardown() throws SQLException {
//        Connection conn = Database_Conn.getconn();
//        try {
//            conn.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }type name = new type();

    @Test             // to test the connection and else
   public void getConnectionTest() throws SQLException
    {
    	 Connection conn = Database_Conn.getconn();
    	 assertNotNull(conn,"connection successfull");
    }
    @Before
    public void getDao() throws SQLException
    {
    	 dao = new Employee_Dao();
    	
    }
    
    
    @Test
    public void addEmptest() throws SQLException
    {
    	Employee emp = new Employee();
    	emp.setUsername("emp");
    	emp.setPassword("emppass");
    	emp.setEmail("emp@email");
    	Connection conn = Database_Conn.getconn();
    	//Employee_Dao dao = new Employee_Dao();
    	dao.addEmployee(emp);
    	Employee empfromdb = dao.getEmpbyname("emp");
    	assertEquals("emppass",empfromdb.getPassword());      //in junit 4 dont add message but not in junit 5
    }
    @Test
    public void deleteEmpTest() throws SQLException 
    {
    	//Employee_Dao dao = new Employee_Dao();
    	Employee empfromdb = dao.getEmpbyname("emp22");
    	dao.deleteEmployee("emp22");
    	assertNull(empfromdb.getUsername());
    	System.out.println();
    }
    
    
}
