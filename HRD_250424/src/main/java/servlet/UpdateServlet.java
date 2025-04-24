package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.MemberVO;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO m = new MemberVO();
		MemberDAO member = new MemberDAO();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		m.setCustno(custno);
		m.setCustname(custname);
		m.setPhone(phone);
		m.setAddress(address);
		m.setJoindate(joindate);
		m.setGrade(grade);
		m.setCity(city);
		
		
		try {
			member.update(m, custno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("custno", custno);
		response.sendRedirect("registration.jsp");
	}

}
