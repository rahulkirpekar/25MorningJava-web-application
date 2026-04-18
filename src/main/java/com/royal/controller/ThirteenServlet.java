package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirteenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		
		String name1 = (String)context.getAttribute("name1");
		String name2 = (String)context.getAttribute("name2");
		
		System.out.println("ThirteenServlet : ");
		System.out.println("Name1 : " + name1);
		System.out.println("Name2 : " + name2);
	}
}
