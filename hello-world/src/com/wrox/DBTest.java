package com.wrox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.err.println("Oracle driver loaded");
	//		String dbURL = "jdbc:oracle:thin:@//localhost:1521/XEXDB";
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "2";
			Connection conn = DriverManager.getConnection(dbURL, user, password);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
