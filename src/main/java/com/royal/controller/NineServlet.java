package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NineServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// session create 
		HttpSession session = request.getSession();
		
		// Data -- ready
		StudentBean s1 = new StudentBean(1, "Rahul Kirpekar", 12, 100);
		
		// data store ---session
		session.setAttribute("student", s1);

		System.out.println("NineServlet - session Address(student Data Store into session) : " + session);
	}
}
