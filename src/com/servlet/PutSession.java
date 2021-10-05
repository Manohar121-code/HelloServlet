package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PutSession")
public class PutSession extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		HttpSession session = req.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("phone", phone);
		
		res.setContentType("text/html");
		PrintWriter pt = res.getWriter();
		pt.print("<h1>"+ "Data is set to session successfully" +"</h1>");
	}
	
}
