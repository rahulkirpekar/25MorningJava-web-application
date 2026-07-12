package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.bean.UserBean;
import com.royal.util.DbConnection;

public class UserDao 
{
	public UserBean authenticateUser(String emailId,String password) 
	{
		String selectQuery = "SELECT * FROM user WHERE email ='"+emailId+"' AND password='"+password+"'";
		
		UserBean userBean = null;

		Connection conn = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
			
				rs = stmt.executeQuery(selectQuery);
				
				if (rs.next()) 
				{
					int id = rs.getInt(1);
					String email = rs.getString(2);
					String name = rs.getString(3);
					String password1 = rs.getString(4);
					
					userBean = new UserBean(id, email, name, password1);
				}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("UserDao : authenticateUser() Db not connected");
		}
		return userBean;
	}
}
