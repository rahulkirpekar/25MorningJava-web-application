package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("HelloServlet : service()");
		System.out.println("------------------------------");
		System.out.println("request.getRemoteHost() : " + request.getRemoteHost());  
		System.out.println("	request.getRemoteUser() : " + request.getRemoteUser());
		System.out.println("	request.getRemoteAddr() : " + request.getRemoteAddr());
		
	}
}
