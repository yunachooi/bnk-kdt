package chapter03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import chapter03.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginDao login = new LoginDao();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = null;
		try {
			name = login.checkName(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		try {
			if(login.checkUser(id, pw) == true) {
				request.getRequestDispatcher("/chapter03/loginResult.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/chapter03/loginIndex.jsp").forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
