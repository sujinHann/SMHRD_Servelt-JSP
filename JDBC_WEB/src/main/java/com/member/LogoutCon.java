package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutCon")
public class LogoutCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Session ��ü�� ����(Servlet)
		HttpSession session = request.getSession();
		
		//2. Session���� loginid �����͸� ����
		session.removeAttribute("loginid");
	
		//3. Main.jsp�� �̵� 
		response.sendRedirect("Main.jsp");
	}

}
