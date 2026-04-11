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

public class FourthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		Enumeration<String> e =	context.getInitParameterNames();
		
		while(e.hasMoreElements()) 
		{
			String paramName = e.nextElement();
			String paramValue = context.getInitParameter(paramName);
			
			out.print("<b>"+paramName+" : "+paramValue+"<br>");	
		}
/*		
		// get configuration of application level
		ServletContext context = getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		String lang4 = context.getInitParameter("lang4");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>FourthServlet : </b><br>");
		out.print("<b>lang1 : "+lang1+"<br>");
		out.print("<b>lang2 : </b>"+lang2+"<br>");
		out.print("<b>lang3 : </b>"+lang3+"<br>");
		out.print("<b>lang4 : </b>"+lang4+"<br>");
		
---------------------------------------------------------------------------		
		// get Servletlevel Configuration(SerrvletConfig)
		ServletConfig config = getServletConfig();
		
		String urlName= config.getInitParameter("urlName");
		String driverClass= config.getInitParameter("driverClass");
		String userName= config.getInitParameter("userName");
		String password= config.getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>FourthServlet : </b><br>");
		out.print("<b>UrlName : "+urlName+"<br>");
		out.print("<b>DriverClass : </b>"+driverClass+"<br>");
		out.print("<b>UserName : </b>"+userName+"<br>");
		out.print("<b>password : </b>"+password+"<br>");
*/	}
}
