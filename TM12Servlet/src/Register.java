

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	String uname = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	Member member =new Member(uname, email,password);
	RegisterDao rDao = new RegisterDao();
boolean result =	rDao.insert(member);
if(result) {
	RequestDispatcher rs = request.getRequestDispatcher("index.html");
    rs.forward(request, response);
}

	
	}
}
