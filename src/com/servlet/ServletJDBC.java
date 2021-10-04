package com.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertData")
public class ServletJDBC extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/junedb";
		String userName = "root";
		String password = "manah";
		
		String parameter1 = req.getParameter("id");
		int id = Integer.parseInt(parameter1);
		
		String name = req.getParameter("name");
		
		String parameter3 = req.getParameter("age");
		int age = Integer.parseInt(parameter3);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			Class.forName(dbDriver);
			String sql = "insert into person(id, name, age) values(?,?,?)";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setInt(3, age);
			
			prepareStatement.executeUpdate();
			
			res.setContentType("text/html");
			PrintWriter pt = res.getWriter();
			pt.print("<h1>"+ "Person data inserted successfully" +"</h1>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
