package chapter02.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/test4")
public class Test4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 초기화 작업 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}

	/* 서버 종료 시, 생성된 servlet 객체를 소멸 */
	public void destroy() {
		System.out.println("destroy...");
	}

	/* 서비스 담당 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
	}

}
