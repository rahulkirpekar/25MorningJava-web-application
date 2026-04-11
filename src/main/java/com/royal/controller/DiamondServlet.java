package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DiamondServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<String>list = Arrays.asList("Black","White","Red","Lime","Blue","Yellow","Cyan","Magenta","Silver","Gray","Maroon","Olive","Green","Purple","Teal","Navy","Orange","Pink","Brown","Gold","Sky Blue","Violet","Indigo","Coral","Turquoise");

		// MIME - Multipurpose Mail Extension
		response.setContentType("text/html");
		
		PrintWriter out=	response.getWriter();
		
		int l=0;
		for (int i = 1; i <= 5 ; i++) 
		{
			for(int k=(5-i);k>=1;k--) 
			{
				out.print("&nbsp&nbsp");
			}
			for (int j = 1; j <=i; j++) 
			{
				out.print("<font color='"+list.get(l++)+"'>*</font>&nbsp&nbsp");
			}
			out.println("<br>");
			
		}
		for (int i = 4; i >=1; i--) 
		{
			for(int k=(5-i);k>=1;k--) 
			{
				out.print("&nbsp&nbsp");
			}
			for (int j = 1; j <=i; j++) 
			{
				out.print("<font color='"+list.get(l++)+"'>*</font> &nbsp&nbsp");
			}
			out.println("<br>");
		}
	}
}
