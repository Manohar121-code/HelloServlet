package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloPerson")
public class HelloPerson extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("personName");
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print("<h1>"+"Hello "+ name+"</h1>");
	}
}
