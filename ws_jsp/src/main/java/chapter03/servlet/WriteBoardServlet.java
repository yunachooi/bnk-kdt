package chapter03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import chapter03.dao.BoardDao;
import chapter03.vo.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/write")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDao board = new BoardDao();
		BoardVO b = new BoardVO();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = (String) session.getAttribute("id");
		
		b.setTitle(title);
		b.setContent(content);
		b.setWriter(writer);
		try {
			board.insert(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("title", title);
		
		request.getRequestDispatcher("chapter03/onlyMemberIndex.jsp").forward(request, response);
	}

}
