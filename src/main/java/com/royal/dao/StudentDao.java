package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.bean.StudentBean;
import com.royal.util.DbConnection;

public class StudentDao 
{
	public int insertStudent(StudentBean sbean) 
	{
		String insertQuery = "INSERT INTO student (fullName,age,course,gender,hobbies,dob,email,mobile,address) VALUES(?,?,?,?,?,?,?,?,?)";
		int rowsAffected = 0;
		
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, sbean.getFullName());
				pstmt.setInt(2, sbean.getAge());
				pstmt.setString(3, sbean.getCourse());
				pstmt.setString(4, sbean.getGender());
				pstmt.setString(5, sbean.getHoobiesStr());
				pstmt.setString(6, sbean.getDob());
				pstmt.setString(7, sbean.getEmail());
				pstmt.setString(8, sbean.getMobile());
				pstmt.setString(9, sbean.getAddress());
				
				System.out.println("pstmt : " + pstmt);
				
				rowsAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao--insertStudent() Db not connected");
		}
		return rowsAffected;
	}
	public void updateStudent() {

	}
	public void getAllStudentRecords() {

	}
	public void deleteStudent() 
	{

	}
}
	