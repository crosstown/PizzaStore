package com.wrox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wrox.helper.Product;

public class ViewPreferences extends HttpServlet{
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
				
		out.println("<html><body><h1>Your Preferences</h1><ul>");
		
		HttpSession session = request.getSession();
		List<Product> cart = (List<Product>)session.getAttribute("preferences");
		if (cart != null)
		{
			for (Product next : cart)
			{
				out.println("<li>" + next.getName() + ": $" + next.getPrice() + "</li>");
			}
		}
		
		out.println("</ul></body></html>");
		
		out.close();
	}
}
