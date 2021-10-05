package com.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getPersons")
public class RetrieveData extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/junedb";
		String userName = "root";
		String password = "manah";
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			res.setContentType("text/html");
			PrintWriter pt = res.getWriter();
			
			Class.forName(dbDriver);
			String sql = "select * from person";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				pt.print("<h1>"+ id+ " - "+ name+" - "+ age +"</h1>");
			}
			
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
