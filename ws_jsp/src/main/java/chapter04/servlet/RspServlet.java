package chapter04.servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rsp")
public class RspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random rd = new Random();
		int rsp = Integer.parseInt(request.getParameter("rsp"));
		int rdNum = rd.nextInt(3) + 1;
		System.out.println(rdNum);

		int result = rsp - rdNum;
		String rspResult = null;

		if (result == 0) {
			rspResult = "무승부";
		} else if (result == -1 || result == 2) {
			rspResult = "패배";
		} else {
			rspResult = "승리";
		}

		request.setAttribute("rsp", rsp);
		request.setAttribute("rspResult", rspResult);

		request.getRequestDispatcher("chapter04/rspResult.jsp").forward(request, response);

	}

}
