package com.royal.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;

@WebServlet("/SevenServlet")
public class SevenServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentBean s1 =  (StudentBean)request.getAttribute("student1");
		StudentBean s2 =  (StudentBean)request.getAttribute("student2");
		
		System.out.println("SevenServlet - service() : " + s1.getRno()+" " + s1.getName()+" " + s1.getStd()+" " + s1.getMarks()+"<br>");
		System.out.println("SevenServlet - service() : " + s2.getRno()+" " + s2.getName()+" " + s2.getStd()+" " + s2.getMarks());
		
		request.removeAttribute("student2");
		
		RequestDispatcher rd= request.getRequestDispatcher("EightServlet");
		rd.forward(request, response);
	}
}
