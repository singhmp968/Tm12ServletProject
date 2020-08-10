

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changePass
 */
@WebServlet("/changePass")
public class changePass extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter pw = response.getWriter();
			String email = request.getParameter("email");
			String oldPass = request.getParameter("oldPass");
			String newPass = request.getParameter("newPass");
			
			if(Validate.checkUser(email, oldPass)) {
				
				if(passwordChangeClass.passChange(email, newPass)) {
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
		            rs.forward(request, response);
				}
				
				
			}
			
	}

}
