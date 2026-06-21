package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;
import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("UpdateStudentServlet : service()");
		StudentBean sbean = new StudentBean();

		int id = Integer.parseInt(request.getParameter("id"));
		
		sbean.setId(id);
		
		// Backend Validation
		response.setContentType("text/html");
		String fullName  =	request.getParameter("fullname");
		

		boolean flag = false;
		
		if(StringUtils.isValidStr(fullName)) 
		{
			sbean.setFullName(fullName);
		}else 
		{
			flag = true;
			request.setAttribute("fullNameErr", "<font color='red'>Please enter valid FullName.</font>");
		}
		
		String age = request.getParameter("age");
		
		if(StringUtils.isValidStr(age)) 
		{
			sbean.setAge(Integer.parseInt(age));
		}else 
		{
			flag = true;
			request.setAttribute("ageErr", "<font color='red'>Please enter valid Age.</font>");
		}
		
		String course	 =	request.getParameter("course");

		if(StringUtils.isValidStr(course)) 
		{
			sbean.setCourse(course);
		}else 
		{
			flag = true;
			request.setAttribute("courseErr", "<font color='red'>Please enter valid Course.</font>");
		}
	
		String gender	 =	request.getParameter("gender");
		if(StringUtils.isValidStr(gender)) 
		{
			sbean.setGender(gender);
		}else 
		{
			flag = true;
			request.setAttribute("genderErr", "<font color='red'>Please enter valid Gender.</font>");
		}
		
		String hobby[]	 =	request.getParameterValues("hobby");
		if(hobby !=null) 
		{
			sbean.setHobbies(hobby);
		}else 
		{
			flag = true;
			request.setAttribute("hobbyErr", "<font color='red'>Please enter valid Hobby.</font>");
		}		
		
		String dob		 =	request.getParameter("dob");
		
		if(StringUtils.isValidStr(dob)) 
		{
			sbean.setDob(dob);
		}else 
		{
			flag = true;
			request.setAttribute("dobErr", "<font color='red'>Please enter valid DOB.</font>");
		}
		
		String email	 =	request.getParameter("email");
		
		if(StringUtils.isValidStr(email)) 
		{
			sbean.setEmail(email);
		}else 
		{
			flag = true;
			request.setAttribute("emailErr", "<font color='red'>Please enter valid Email.</font>");
		}
		String mobile	 =	request.getParameter("mobile");
		
		if(StringUtils.isValidStr(mobile)) 
		{
			sbean.setMobile(mobile);
		}else 
		{
			flag = true;
			request.setAttribute("mobileErr", "<font color='red'>Please enter valid Mobile.</font>");
		}
		
		String address	 =	request.getParameter("address");
		if(StringUtils.isValidStr(address)) 
		{
			sbean.setAddress(address);
		}else 
		{
			flag = true;
			request.setAttribute("addressErr", "<font color='red'>Please enter valid Address.</font>");
		}
		
		request.setAttribute("sbean", sbean);
		
		RequestDispatcher rd = null;
		if (flag) 
		{
			rd = request.getRequestDispatcher("studentregi.jsp");
		} else 
		{
			StudentDao dao  = new StudentDao();
			
			int rowsAffected = dao.updateStudent(sbean,id);
			
			if(rowsAffected > 0) 
			{
				rd = request.getRequestDispatcher("ListStudentServlet");
			}else 
			{
				rd = request.getRequestDispatcher("studentregi.jsp");
			}
		}
		rd.forward(request, response);
	}
}
