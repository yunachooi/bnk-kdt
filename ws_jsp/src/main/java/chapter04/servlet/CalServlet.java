package chapter04.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cal")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String calculation = request.getParameter("calculation");
		
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("calculation", calculation);
		
		int result = 0;
		switch(calculation) {
		case "더하기" -> result = a + b;
		case "빼기" -> result = a - b;
		case "곱하기" -> result = a * b;
		case "나누기" -> result = a / b;
		}
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("chapter04/calResult.jsp").forward(request, response);
	}

}
