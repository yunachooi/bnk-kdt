package chapter08.servlet;

import java.io.IOException;
import java.sql.SQLException;

import chapter08.service.RspLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/chapter08/login_i")
public class LoginiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RspLoginService rsp = new RspLoginService();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		session.setAttribute("userId", id);
		
		try {
			if(rsp.loginCheck(id, pw) == true) {
				request.getRequestDispatcher("/chapter08/gameIndex.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/chapter08/loginIndex.jsp").forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
