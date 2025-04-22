package chapter02.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test2Servlet() {
        super();
    }
    
	/* 주소창에 나오지않음, 보안성이 높아짐 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>EX01 Page(Post방식)</h1><hr />");
		out.print("<p>Servlet을 배우고 있습니다.</p>");
		out.print("</body>");
		out.print("</html>");
		
		String name = request.getParameter("name");
		response.getWriter().append("name : " + name);
	}

}
