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

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����ڰ� �Է��� 3������ �޾ƿ��°�
		request.setCharacterEncoding("euc-kr");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		// jdbc�ڵ带 ¥���մϴ�

		// �ڹ��� ����
		// 1.������ ����: ������ ����
		// 2.��Ÿ�� ����: ������ �ؾ����� �� �� �ִ� ����<-jdbc�� ���� (ä��,����ã��)
		
		//��Ÿ�� ������ �Ͼ�� �� ����ó�� try catch
		
		//���������� ����
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. �����ε� (sevlet������ �츮�� � dbms�� ����ϴ��� �𸣱� ������ ���)
			// DB->DBMS(oracle,mysql,mssql)
			Class.forName("oracle.jdbc.driver.OracleDriver");// Ŭ�������� �ε�
			// 2. Oracle�� ���� id/pw�� �����޾ƾ���
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			// DB����

			conn = DriverManager.getConnection(url, dbid, dbpw);
			// ������� DB���� �ܰ�

			// 3. sql�غ� ���� ������ SQL�� �����ְ� �Է°��� ?
			String sql = "insert into web_member values (?,?,?)";
			psmt = conn.prepareStatement(sql);

			// ����ڿ��� ���� ������ ���� ? ��
			psmt.setString(1, id); // ?�� ���� �������ִ� ��� ?����ŭ �־���Ѵ�
			psmt.setString(2, pw); //
			psmt.setString(3, nick); //

			// 4. sql����
			int cnt = psmt.executeUpdate();

			// 5.���� �� ó��
			if (cnt > 0) {
				response.sendRedirect("Main.jsp");
				// ��P�� �̵��ϴ� ~
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				// �ֱٿ� ���� ������� �ݾ������
				// finally �ȿ� �ִ� ����? try���̵� catch���̵� �ݱ����� <- ������ ����Ǵ� ����
				psmt.close();
				conn.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
	}

}
