package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSession")
public class GetSession extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String phone = (String) session.getAttribute("phone");
		
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print("<h1>"+ "Data is read from session successfully" +"</h1>");
		pt.print("<h1>"+ "Email - "+ email + ", phone - "+ phone +"</h1>");
		
		session.invalidate();
	}
	
}
