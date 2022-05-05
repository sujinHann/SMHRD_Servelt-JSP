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
import javax.servlet.http.HttpSession;

import com.DAO.memberDAO;
import com.VO.memberVO;

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ������ ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		//pw, tel, address / email -> session
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginvo");
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		//JDBC_WEB ������Ʈ -> UpdateCon ����
		//MessageSystem -> JoinCon ����
		
		//���� ���� -> �ܼ�â�� "��������" ��� (������ �̵�x)
		//���� ���� -> �ܼ�â�� "��������" ��� (������ �̵�x)
		
		memberDAO dao = new memberDAO();	
		int cnt = dao.update(email,pw,tel,address);
		
		if(cnt>0){
			System.out.println("��������");
			//main.jsp���� ������ ��ȭ��ȣ/���ּ� ���
			//������� ������ ���� ������ �ִ� vo
			
			memberVO vo2= new memberVO(email, tel, address);
			session.setAttribute("loginvo", vo2);
			
			//main.jsp�� �̵�
			response.sendRedirect("main.jsp");
			
         }else {  
        	 System.out.println("��������");
        	 //main.jsp�� �̵�
        	 response.sendRedirect("main.jsp");
         }
	}

}
		
		
		
		
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
//			String sql = "update message_member set pw = ?, tel = ?, address = ? where email = ?"; 
//			
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, pw);
//			psmt.setString(2, tel);
//			psmt.setString(3, address);
//			psmt.setString(4, email);
//
//
//			int cnt = psmt.executeUpdate();
//
//			if(cnt>0){
//				System.out.println("��������");
//				//main.jsp���� ������ ��ȭ��ȣ/���ּ� ���
//				//������� ������ ���� ������ �ִ� vo
//				memberVO vo2= new memberVO(email, tel, address);
//				session.setAttribute("loginvo", vo2);
//				
//				//main.jsp�� �̵�
//				response.sendRedirect("main.jsp");
//				
//             }else {  
//            	 System.out.println("��������");
//            	 //main.jsp�� �̵�
//            	 response.sendRedirect("main.jsp");
//             }
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				psmt.close();
//				conn.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		
		
