package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TenthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// first get old session
		HttpSession session = request.getSession(false);

		// get student data from session 
		StudentBean s1= (StudentBean)session.getAttribute("student");	
		
		System.out.println("TenthServlet : session : " + session);
		
		System.out.println(s1.getRno()+" " + s1.getName()+ " "+s1.getStd()+ " " + s1.getMarks());
	}
}
