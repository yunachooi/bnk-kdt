package chapter02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/test1")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Test1Servlet() {
        super();
    }

    /* 주소창에 나옴, 서버가 제공하기로 약속한 것에 관해 제공 받을 경우(공개해도 괜찮) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>EX01 Page(Get방식)</h1><hr />");
		out.print("<p>Servlet을 배우고 있습니다.</p>");
		out.print("</body>");
		out.print("</html>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
