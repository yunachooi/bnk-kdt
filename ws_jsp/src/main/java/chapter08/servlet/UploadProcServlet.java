package chapter08.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 15
)

@WebServlet("/chapter08/uploadProc")
public class UploadProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1. upload 폴더 지정 */
		String uploadPath = request.getServletContext().getRealPath("/chapter08/images/");
		System.out.println("uploadPath : " + uploadPath);
		
		/* 2. 일반 파라미터 처리 */
		String desc = request.getParameter("desc");
		System.out.println("desc : " + desc);
		
		/* 3. 파일 처리 */
		Part part = request.getPart("imgfile");
		long size = part.getSize();
		if(size > 0) {
			part.write(uploadPath + part.getSubmittedFileName());
			part.delete();
			request.setAttribute("filename", part.getSubmittedFileName());
			request.getRequestDispatcher("/chapter08/success.jsp").forward(request, response);
		} else {
			response.sendRedirect("/chapter08/fail.jsp");
		}
	}

}
