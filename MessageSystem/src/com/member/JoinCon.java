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
		// 1. main.jsp���� ����ڰ� ������ ������ �����ÿ�(post)
		
		// 3. ���� �Ϸ� �Ŀ� main.jsp �̵��Ͻÿ�

		request.setCharacterEncoding("euc-kr");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		memberDAO dao = new memberDAO();	
		int cnt = dao.join(email,pw,tel,address);
		
		if (cnt > 0) {
			response.sendRedirect("main.jsp");
			// ��P�� �̵��ϴ� ~ 
		} else {
			response.sendRedirect("main.jsp");
		}

		
	}

}
		
		
		
		
		
		
		
		

		// 2. JDBC�� ���� DB�� �����Ͽ� message_member ���̺� ������� ������ �����Ͻÿ�
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
//				// ��P�� �̵��ϴ� ~ 
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			try {
//				// �ֱٿ� ���� ������� �ݾ������
//				// finally �ȿ� �ִ� ����? try���̵� catch���̵� �ݱ����� <- ������ ����Ǵ� ����
//				psmt.close();
//				conn.close();
//			} catch (Exception e2) {
//
//				e2.printStackTrace();
//			}
//		}

