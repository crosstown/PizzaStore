package com.wrox;
import com.wrox.helper.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wrox.helper.ProductHelper;
public class ProductsList extends HttpServlet {
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
	
		// do some work
		ProductHelper productservice = ProductHelper.getService();
		
		List<Product> allProducts = productservice.getEntireList();

		// output the result page
		out.println("<html><head><title>Our entire list</title>");
		out.println("<body><h1>Our Entire Product List</h1>");
		
		out.println("<ul>");
		for (Product nextProduct : allProducts)
		{
			out.println("<li>");
			out.println(nextProduct.getName());	
			
			String url = "addToPreferences.html";
			url = response.encodeURL(url);
			
			out.println("<form method='post' action='" + url + "'>");
			out.println("<input type='hidden' name='id' value='" + nextProduct.getId() + "'/>");
			out.println("<input type='submit' value='Add To Preferences'/>");
			out.println("</form>");
			
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}
}
