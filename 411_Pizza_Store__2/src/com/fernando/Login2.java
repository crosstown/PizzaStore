package com.fernando;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

response.setContentType("text/html");
		
		//
		// We are going to read a file called configuration.properties. This
		// file is placed under the WEB-INF directory.
		//
	//	String filename = "test";
		
	//	ServletContext context = getServletContext();
		try {
		Properties prop = new Properties();
		 prop.setProperty("db.host", "localhost");
	        prop.setProperty("db.user", "user");
	        prop.setProperty("db.pwd", "password");
	        
	        File f = new File("text.ini");
	        FileOutputStream out = new FileOutputStream( f );
	        
	        
	        
	        prop.store(out, "DB Config file");	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
