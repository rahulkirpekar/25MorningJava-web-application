package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdTableServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int no = 5;
		PrintWriter out = response.getWriter();
		for(int i = 1 ; i <=10 ; i++) 
		{
			out.println(no+" * " + i + " = "+(no*i));
		}
	}
}
