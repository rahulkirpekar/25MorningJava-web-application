package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EightServlet")
public class EightServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentBean s1 =  (StudentBean)request.getAttribute("student1");
		StudentBean s2 =  (StudentBean)request.getAttribute("student2");
		
		System.out.println("EightServlet - service() : " + s1.getRno()+" " + s1.getName()+" " + s1.getStd()+" " + s1.getMarks()+"<br>");
		System.out.println("EightServlet - service() : " + s2.getRno()+" " + s2.getName()+" " + s2.getStd()+" " + s2.getMarks());
	}
}
