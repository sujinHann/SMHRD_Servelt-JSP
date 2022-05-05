package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. main.jsp에서 사용자가 보내는 정보를 받으시오(post)
		
		// 3. 저장 완료 후에 main.jsp 이동하시오

		request.setCharacterEncoding("euc-kr");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		memberDAO dao = new memberDAO();	
		int cnt = dao.join(email,pw,tel,address);
		
		if (cnt > 0) {
			response.sendRedirect("main.jsp");
			// 웹P로 이동하는 ~ 
		} else {
			response.sendRedirect("main.jsp");
		}

		
	}

}
		
		
		
		
		
		
		
		

		// 2. JDBC를 통해 DB와 연결하여 message_member 테이블에 사용자의 정보를 저장하시오
//		Connection conn = null;
//		PreparedStatement psmt = null;
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//			String dbid = "hr";
//			String dbpw = "hr";
//
//			conn = DriverManager.getConnection(url, dbid, dbpw);
//
//			String sql = "insert into message_member values(?,?,?,?,sysdate)";
//
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, email);
//			psmt.setString(2, pw);
//			psmt.setString(3, tel);
//			psmt.setString(4, address);
//
//			int cnt = psmt.executeUpdate();
//
//			if (cnt > 0) {
//				response.sendRedirect("main.jsp");
//				// 웹P로 이동하는 ~ 
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			try {
//				// 최근에 열린 순서대로 닫아줘야함
//				// finally 안에 넣는 이유? try문이든 catch문이든 닫기위해 <- 무조건 실행되는 문장
//				psmt.close();
//				conn.close();
//			} catch (Exception e2) {
//
//				e2.printStackTrace();
//			}
//		}

