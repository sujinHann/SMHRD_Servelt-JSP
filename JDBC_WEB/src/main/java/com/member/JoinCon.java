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

		// 사용자가 입력한 3가지를 받아오는것
		request.setCharacterEncoding("euc-kr");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		// jdbc코드를 짜야합니다

		// 자바의 오류
		// 1.컴파일 오류: 문법적 오류
		// 2.런타임 오류: 실행을 해야지만 알 수 있는 오류<-jdbc의 원인 (채팅,파일찾기)
		
		//런타임 오류가 일어났을 때 예외처리 try catch
		
		//전역변수로 세팅
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. 동적로딩 (sevlet파일은 우리가 어떤 dbms를 사용하는지 모르기 떄문에 사용)
			// DB->DBMS(oracle,mysql,mssql)
			Class.forName("oracle.jdbc.driver.OracleDriver");// 클래스파일 로딩
			// 2. Oracle에 가서 id/pw를 인증받아야함
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			// DB연결

			conn = DriverManager.getConnection(url, dbid, dbpw);
			// 여기까지 DB연결 단계

			// 3. sql준비 실제 실행할 SQL문 적어주고 입력값은 ?
			String sql = "insert into web_member values (?,?,?)";
			psmt = conn.prepareStatement(sql);

			// 사용자에게 받을 세가지 값을 ? 로
			psmt.setString(1, id); // ?의 값을 대입해주는 기능 ?수만큼 있어야한다
			psmt.setString(2, pw); //
			psmt.setString(3, nick); //

			// 4. sql실행
			int cnt = psmt.executeUpdate();

			// 5.실행 후 처리
			if (cnt > 0) {
				response.sendRedirect("Main.jsp");
				// 웹P로 이동하는 ~
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				// 최근에 열린 순서대로 닫아줘야함
				// finally 안에 넣는 이유? try문이든 catch문이든 닫기위해 <- 무조건 실행되는 문장
				psmt.close();
				conn.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
	}

}
