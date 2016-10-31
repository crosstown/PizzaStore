package com.fernando;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		//
		// We are going to read a file called configuration.properties. This
		// file is placed under the WEB-INF directory.
		//
		
		
		String filename = "/WEB-INF/configuration.properties";

		ServletContext context = getServletContext();
		
		//Interface ServletContext. Defines a set of methods that a servlet uses to communicate 
		//with its servlet container, for example, to get the MIME type of a file,
		//dispatch requests, or write to a log file. 
		//There is one context per "web application" per Java Virtual Machine.
		
		
		String user = request.getParameter("userName");
		String password = request.getParameter("password");

		//
		// First get the file InputStream using
		// ServletContext.getResourceAsStream()
		// method.
		//
		
		InputStream is = context.getResourceAsStream(filename);
		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			PrintWriter writer = response.getWriter();
			String text = "";
			String[] tokens;
			Hashtable<String, String> ht1 = new Hashtable<String, String>();
			//
			// We read the file line by line and later will be displayed on the
			// browser page.
			//
			while ((text = reader.readLine()) != null) {
				tokens = text.split(",");
				writer.println(tokens[0] + " " + tokens[1] + "<br>");
				ht1.put(tokens[0], tokens[1]);
				// writer.println(text);
			}
			writer.print(user + " " + password  + "<br>");
			writer.println(ht1.get(user));
			writer.println(password);
			if (ht1.get(user).equals(password)) {
				
                String nextHTML = "/RandomDisplay.html";	//Redirecting to random page
				RequestDispatcher rs = request.getRequestDispatcher(nextHTML);
				rs.forward(request, response);
			} else {
				writer.println("Username or Password incorrect");
		   //        RequestDispatcher rs = request.getRequestDispatcher("index.htm");
		 //          rs.include(request, response);
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
