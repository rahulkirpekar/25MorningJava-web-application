package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		RequestDispatcher rd = null;
		if (session != null) 
		{
			System.out.println("if : (session != null) ");
			
			Object obj = session.getAttribute("userBean");

			System.out.println("obj : " + obj);
			if(obj != null) 
			{
				System.out.println("==== if(obj != null)==== ");
				
				UserBean userBean = (UserBean)session.getAttribute("userBean");

				request.setAttribute("logoutSuccess", "<font color='green'>"+userBean.getName()+", successfully Logout...!</font>");
				
				// Session Logout
				session.invalidate();
				
				rd = request.getRequestDispatcher("login.jsp");
			}
			else
			{
				request.setAttribute("invalidUser", "<font color='red'>Invalid Access,Please login first.</font>");
				rd = request.getRequestDispatcher("login.jsp");
			}
			
		} else 
		{
			request.setAttribute("invalidUser", "<font color='red'>Invalid Access,Please login first.</font>");
			rd = request.getRequestDispatcher("login.jsp");
		}
		
		rd.forward(request, response);
	}
}
