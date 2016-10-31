package com.wrox;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wrox.helper.Product;
import com.wrox.helper.ProductHelper;

public class AddToPreferences extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String strId = request.getParameter("id");
		int id = new Integer(strId);

		Product requiredBook = ProductHelper.getService().getProductById(id);

		HttpSession session = request.getSession();

		List<Product> preferences = (List<Product>) session.getAttribute("preferences");
		if (preferences == null) {
			// this is the first visit (of this servlet) by this user
			preferences = new ArrayList<Product>();
		}

		preferences.add(requiredBook);

		session.setAttribute("preferences", preferences);
		out.println("<h1>Thanks</h1><p>You have added the book to your cart</p>");

		String url = "viewPreferences.html";
		url = response.encodeURL(url);

		out.println("<a href='" + url + "'>Click here to visit your cart</a>");

		out.close();
	}
}
