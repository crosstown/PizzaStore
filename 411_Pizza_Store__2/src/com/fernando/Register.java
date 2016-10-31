package com.fernando;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	response.setContentType("text/html");

	//
	// We are going to read a file called configuration.properties. This
	// file is placed under the WEB-INF directory.
	//
	String filename = "/WEB-INF/configuration.properties";

	ServletContext context = getServletContext();

	String user = request.getParameter("usernamesignup");
	String password = request.getParameter("passwordsignup");

	//
	// First get the file InputStream using
	// ServletContext.getResourceAsStream()
	// method.
	//
	//URL url = this.getClass().getResource("/WEB-INF/configuration.properties");

	
	
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
			
            String nextHTML = "/products.htm";
			RequestDispatcher rs = request.getRequestDispatcher(nextHTML);
			rs.forward(request, response);
		} else {
			writer.println("Username or Password incorrect");
	   //        RequestDispatcher rs = request.getRequestDispatcher("index.htm");
	 //          rs.include(request, response);
			
		}
	}
}
	
}
	

