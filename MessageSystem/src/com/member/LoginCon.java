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

import com.DAO.memberDAO;
import com.VO.memberVO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자가 입력한 email과 pw를 받아오시오
		// 2. jdbc를 통해 member_message테이블에 있는 email의 정보를 검색하시오
		// 3. 검색된 정보의 pw와 사용자가 입력한 pw가 일치할 때 
		// 		session에 'loginmeail'라는 name값으로 로그인에 성공한 email을 저장하시오 
		// 4. 성공 후에는 'main.jsp'로 이동하시오
		// 5. 실패 했을때(id가 없을 때 / pw가 틀렸을때) 이동x
		
		
		// 1. 사용자가 입력한 ID/PW를 가져오시오 request
		request.setCharacterEncoding("euc-kr");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);

		if (vo != null) {

			HttpSession session = request.getSession();
			session.setAttribute("loginvo", vo);

			response.sendRedirect("main.jsp");

		} else {
			response.sendRedirect("main.jsp");

		}

	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// 2. jdbc를 통해 message_member테이블에 있는 email의 정보를 검색하시오
//	     Connection conn = null;
//         PreparedStatement psmt = null;
//         ResultSet rs = null;
//         
//         try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//            String dbid = "hr";
//            String dbpw = "hr";
//            
//            conn = DriverManager.getConnection(url,dbid,dbpw);
//            
//            String sql = "select * from message_member where email = ?";
//            
//            psmt = conn.prepareStatement(sql);
//            psmt.setString(1, email);
//            
//            rs = psmt.executeQuery();
//            
//            // 3. 검색된 정보의 pw와 사용자가 입력한 pw가 일치할 때 
//    		// 		session에 'loginmeail'라는 name값으로 로그인에 성공한 email을 저장하시오 
//            
//            if(rs.next()){
//            	
//               String getemail = rs.getString(1);
//               String getpw = rs.getString(2);
//               String tel = rs.getString(3); 
//               String address = rs.getString(4); 
//               String date = rs.getString(5); 
//               
//               System.out.println(getemail+ "\t" + getpw + "\t" + tel + "\t" + address + "\t" + date);
//               
//          
//              
//               if(pw.equals(getpw)) {
//            	   
//            	   //Cookie cook = new Cookie("loginid", id);
//            	   //response.addCookie(cook);
//            	   //쿠키를 활용한 아이디값 저장
//            	   
//            	   memberVO vo = new memberVO(email, tel, address);
//            	   
//            	   HttpSession session = request.getSession();
//            	   //Servlet은 내장객체가 없기 때문에 session 객체생성
//            	   
//            	   //session에 'loginemail'라는 name값으로 로그인에 성공한 email을 저장하시오 
//            	   session.setAttribute("loginvo", vo);
//            	   //session영역에 데이터생성
//            	   
//           
//            	  //4. 성공 후에는 'main.jsp'로 이동하시오        	   
//            	   response.sendRedirect("main.jsp");
//            	   
//            	   //URL을 통해서 데이터를 전송하는 방식
//            	   //QueryString
//            	   //         ex04        ?
//            	   //보내려하는 파일이름 QueryString시작
//            	   //         name        =     value
//            	   //보내려는 데이터에 이름표          보내는 데이터
//            	   
//               }else {
//            	   
//               }
//            }else {
//            	
//            }
//                
//         }catch(Exception e) {
//            e.printStackTrace();
//         }finally {
//            try {
//            rs.close();
//             psmt.close();
//             conn.close();         
//            } catch (Exception e2) {
//               e2.printStackTrace();
//            }
//         }
	
