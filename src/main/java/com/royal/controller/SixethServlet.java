package com.royal.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.royal.bean.StudentBean;

@WebServlet("/SixethServlet")
public class SixethServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentBean s1 = new StudentBean(1, "Rahul Kirpekar", 12, 100);
		StudentBean s2 = new StudentBean(2, "Ankur Patel", 10, 100);

		request.setAttribute("student1", s1);
		request.setAttribute("student2", s2);
		
		RequestDispatcher rd= request.getRequestDispatcher("SevenServlet");
		rd.forward(request, response);
	}
}
