package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FifthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// get configuration of application level
		ServletContext context = getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		String lang4 = context.getInitParameter("lang4");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>FifthServlet : </b><br>");
		out.print("<b>lang1 : "+lang1+"<br>");
		out.print("<b>lang2 : </b>"+lang2+"<br>");
		out.print("<b>lang3 : </b>"+lang3+"<br>");
		out.print("<b>lang4 : </b>"+lang4+"<br>");
		
		
		
		
		// get Servletlevel Configuration(SerrvletConfig)
//		ServletConfig config = getServletConfig();
		
//		String urlName= config.getInitParameter("urlName");
//		String driverClass= config.getInitParameter("driverClass");
//		String userName= config.getInitParameter("userName");
//		String password= config.getInitParameter("password");
		
//		response.setContentType("text/html");
		
//		PrintWriter out = response.getWriter();
		
//		Enumeration<String> e =	config.getInitParameterNames();
/*		
		out.print("<b>FifthServlet : </b><br>");
		
		while(e.hasMoreElements()) 
		{
			String paramName = e.nextElement();
			
			String paramValue = config.getInitParameter(paramName);
			
			out.print("<b>"+paramName+" : </b>" + paramValue+"</br>");
		}
*/	}
}