package chapter08.servlet;

import java.io.IOException;
import java.sql.SQLException;

import chapter08.dao.RspDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memberi")
public class MemberiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RspDAO rsp = new RspDAO();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try {
			rsp.insert(id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/chapter08/loginIndex.jsp").forward(request, response);
	}

}
