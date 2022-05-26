package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. ����ڰ� �Է��� ID/PW�� �������ÿ� request
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
	     Connection conn = null;
         PreparedStatement psmt = null;
         ResultSet rs = null;
         
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
            String dbid = "hr";
            String dbpw = "hr";
            
            conn = DriverManager.getConnection(url,dbid,dbpw);
            
            String sql = "select * from web_member where id = ?";
            
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            
            rs = psmt.executeQuery();
            
            if(rs.next()){
               String getid = rs.getString(1);
               String getpw = rs.getString(2);
               String nick = rs.getString(3); 
               
               //System.out.println(getid+"\t"+getpw+"\t"+nick);
               
               // ����ڰ� �Է��� pw�� DB ������ pw�� ��ġ�ϸ� 'LoginS.jsp' �̵��ϰ�
               // 							 ��ġ���� ������ 'LoginF.jsp' �̵��Ͻÿ�
               
               if(pw.equals(getpw)) {
            	   
            	   //Cookie cook = new Cookie("loginid", id);
            	   //response.addCookie(cook);
            	   //��Ű�� Ȱ���� ���̵� ����
            	   
            	   HttpSession session = request.getSession();
            	   //Servlet�� ���尴ü�� ���� ������ session ��ü����
            	   session.setAttribute("loginid", id);
            	   //session������ �����ͻ���
            	   
        
            	   
            	   response.sendRedirect("LoginS.jsp?id="+id);
            	   
            	   //URL�� ���ؼ� �����͸� �����ϴ� ���
            	   //QueryString
            	   //         ex04        ?
            	   //�������ϴ� �����̸� QueryString����
            	   //         name        =     value
            	   //�������� �����Ϳ� �̸�ǥ          ������ ������
            	   
               }else {
            	   response.sendRedirect("LoginF.jsp");
               }
            }else {
            	response.sendRedirect("LoginF.jsp");
            }
               
           
            
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            try {
            rs.close();
             psmt.close();
             conn.close();         
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
	//���, 3����
		
		
		
	}

}
