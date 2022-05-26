

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 技记 按眉 积己
		HttpSession session = request.getSession();
		
		//2. session (loginvo) 蔼 昏力
		session.removeAttribute("id");
		
		//3. loginForm.html肺 捞悼
		response.sendRedirect("loginForm.html");
		
	}

}
