package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;
import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// MIME
		response.setContentType("text/html");
		System.out.println("LoginServlet---service()");
		
		String emailId = request.getParameter("userName");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		if (StringUtils.isValidStr(emailId) && StringUtils.isValidStr(password)) 
		{
			UserDao userDao  = new UserDao();
			
			UserBean userBean = userDao.authenticateUser(emailId,password);
			
			if(userBean != null) 
			{
				// Create Session for Authenticate User
				HttpSession session = (HttpSession)request.getSession();
					
				session.setAttribute("userBean", userBean);
				
				request.setAttribute("validUser", "<font color='green'>"+userBean+" successfully Login...!</font>");
				
				rd = request.getRequestDispatcher("studentregi.jsp");
			}else 
			{
				request.setAttribute("invalidUser", "<font color='red'>Please enter valid UserName and Password.</font>");
				rd = request.getRequestDispatcher("login.jsp");				
			}			
		} else 
		{
			request.setAttribute("invalidUser", "<font color='red'>Please enter valid UserName and Password.</font>");
			rd = request.getRequestDispatcher("login.jsp");				
		}
		rd.forward(request, response);
	}
}
