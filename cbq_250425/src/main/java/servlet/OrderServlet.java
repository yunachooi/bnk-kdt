package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.OrderVO;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO order = new OrderDAO();
		OrderVO o = new OrderVO();
		
		String orderno = request.getParameter("orderno");
		String shopno = request.getParameter("shopno");
		String orderdate = request.getParameter("orderdate");
		String pcode = request.getParameter("pcode");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		o.setOrderno(orderno);
		o.setShopno(shopno);
		o.setOrderdate(orderdate);
		o.setPcode(pcode);
		o.setAmount(amount);
		
		try {
			order.orderRegist(o);
			System.out.println("ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
	}

}
