package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;
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
	public ArrayList<StudentBean> getAllStudentRecords() 
	{
		String selectQuery = "SELECT * FROM student";
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		PreparedStatement pstmt = null;
		Connection conn = DbConnection.getConnection();
		ResultSet rs = null;
		if(conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectQuery);
			
				rs = pstmt.executeQuery();
				
				StudentBean s = null;
				
				while(rs.next()) 
				{
					s  = new StudentBean();
					
					s.setId(rs.getInt(1));
					s.setFullName(rs.getString(2));
					s.setAge(rs.getInt(3));
					s.setCourse(rs.getString(4));
					s.setGender(rs.getString(5));
					
					String hobbiesStr = rs.getString(6);
					String hobbies[] = hobbiesStr.split(",");
					
					s.setHobbies(hobbies);
					s.setDob(rs.getString(7));
					s.setEmail(rs.getString(8));
					s.setMobile(rs.getString(9));
					s.setAddress(rs.getString(10));
					
					list.add(s);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("StudentDao---getAllStudentRecords() Db not connected");
		}
		return list;
	}
	public int deleteStudent(int id) 
	{
		String deleteQuery = "DELETE FROM student WHERE id=?";
		int rowsAffected = 0;
		
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, id);
				
				System.out.println("pstmt : " + pstmt);
				
				rowsAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao--deleteStudent() Db not connected");
		}
		return rowsAffected;
	}
}
	