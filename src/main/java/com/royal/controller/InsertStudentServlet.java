package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String fullName  =	request.getParameter("fullname");
		String age		 =	request.getParameter("age");
		String course	 =	request.getParameter("course");
		String gender	 =	request.getParameter("gender");
		String hobby[]	 =	request.getParameterValues("hobby");
		String dob		 =	request.getParameter("dob");
		String email	 =	request.getParameter("email");
		String mobile	 =	request.getParameter("mobile");
		String address	 =	request.getParameter("address");
		
		PrintWriter out = response.getWriter();
				
		out.print("InsertStudentServlet service() : "+"<br>");
		out.print("fullName : " + fullName+"<br>");
		out.print("age : " + age+"<br>");
		out.print("course : " + course+"<br>");
		out.print("gender : " + gender+"<br>");
		out.print("hobby : <br>");
		
		for (int i = 0; i < hobby.length; i++) 
		{
			out.print("hobby["+i+"] : " + hobby[i]+"<br>");
		}
		
		
		out.print("dob : " + dob+"<br>");
		out.print("email : " + email+"<br>");
		out.print("mobile : " + mobile+"<br>");
		out.print("address : " + address+"<br>");
		
		
	}
}
