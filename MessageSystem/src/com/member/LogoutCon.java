package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutCon")
public class LogoutCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//서블릿에서는 세션 먼저 생성
		
		//1. 세션 객체 생성
		HttpSession session = request.getSession();
		
		//2. session (loginvo) 값 삭제
		session.removeAttribute("loginvo");
		
		//3. main.jsp로 이동
		response.sendRedirect("main.jsp");
		
	}

}
