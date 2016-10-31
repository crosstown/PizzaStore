package com.fernando;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBDirector extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String choice = req.getParameter("choice");
		resp.getWriter().print("value = " + choice);
       if (choice == null)
    	   choice = "1";
		switch (choice) {
		case "1":
			this.showStudents(req, resp);
			break;
		case "2":
			this.addStudentForm(req, resp);
			break;
		case "3":
			this.deleteStudentForm(req, resp);
			break;
		case "4":
			this.addStudent(req, resp);
			break;
		case "5":
			this.deleteStudent(req, resp);
			break;
		default:
			showStudents(req, resp);
			break;
		}

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.err.println("Oracle driver loaded");
			// String dbURL = "jdbc:oracle:thin:@//localhost:1521/XEXDB";
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

	private void deleteStudentForm(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect("deleteForm.html");

	}

	private void addStudentForm(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		resp.sendRedirect("addForm.html");;

	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/deleteStudent.jsp").forward(req, resp);

	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/addStudent.jsp").forward(req, resp);;
	}

	private void showStudents(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/displayDBTable.jsp").forward(req, resp);
	}

}
