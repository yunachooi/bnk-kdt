package chapter09.servlet;

import java.io.IOException;
import java.sql.SQLException;

import chapter09.dao.AccountDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();

    public void init(ServletConfig config) throws ServletException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromAccountId = request.getParameter("fromAccount");
        String toAccountId = request.getParameter("toAccount");
        String amountStr = request.getParameter("amount");

        try {
            double amount = Double.parseDouble(amountStr);

            // 트랜잭션 실행
            accountDAO.transfer(fromAccountId, toAccountId, amount);

            request.setAttribute("message", "이체 성공: " + fromAccountId + "에서 " + toAccountId + "로 " + amount + "원 이체되었습니다.");
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "이체 실패: " + e.getMessage());
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "유효하지 않은 금액입니다.");
        }
        
        request.getRequestDispatcher("/chapter09/result.jsp").forward(request, response);
    }
}
