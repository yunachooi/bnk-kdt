package chapter02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/test3")
public class Test3Servelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test3Servelt() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		/* 페이지정보가 노출되지 않음, 요청에 대응하면서 가용한 서버 자원을 관리 */
		request.getRequestDispatcher("/chapter02/ex1.jsp").forward(request, response);
		/* 페이지정보가 노출, 도메인에 파라미터가 적시됨 */
		//response.sendRedirect("/chapter02/ex1.jsp");
	}

}
