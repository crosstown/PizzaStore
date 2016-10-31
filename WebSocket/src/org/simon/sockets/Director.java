package org.simon.sockets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "indexServlet", 
urlPatterns = { "/director" },
loadOnStartup = 1)
public class Director extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		if (choice == null)
			choice = "1";
		switch (choice) {
		case "1":
			login(request, response);
			break;
		case "2":
			chat(request, response);
			break;
		default:
			chat(request, response);
			break;
		}
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
		return;
	}

	private void chat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("name");
		String ip ="192.168.1.6";
	//	String ip = java.net.InetAddress.getLocalHost().getHostAddress();
		String realPath = getServletContext().getRealPath("assets/img/" + user + ".png");
		File file = new File(realPath);
		String img = "smily";
		if (file.exists())
			img = user;
		request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp?user=" + user + "&ip=" + ip + "&img=" + img)
				.forward(request, response);
	}
}
