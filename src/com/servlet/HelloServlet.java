package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class HelloServlet extends HttpServlet {

	//init
	//service
	//destroy
	
	String name;
	
	public void init() {
		name = "Arjun";
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print(name + " is saying Hello Servlet");
	}
	
	public void destroy() {
		
	}
	
}
