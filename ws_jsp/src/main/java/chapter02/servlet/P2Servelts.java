package chapter02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/p2")
public class P2Servelts extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		request.getRequestDispatcher("/chapter04/p2.jsp").forward(request, response);
		//response.sendRedirect("chapter04/p2.jsp");
	}

}
