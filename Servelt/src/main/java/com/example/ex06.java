package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex06")
public class ex06 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Post방식일 때 인코딩 방식(습관)
		request.setCharacterEncoding("euc-kr");
		
		//사용자가 입력한 정보를 가져오는 기능 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("pw1");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String date = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String talk = request.getParameter("talk");
		
		//hobby는 중복선택.. 배열로...
		String hobby_res = ""; // 초기값선언 
		
		for(int i=0; i<hobby.length; i++) {
			hobby_res = hobby_res + hobby[i];
			
		}
		
		// 응답 데이터(response)
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		

		
		out.print("아이디: " + id + "<br>");
		out.print("비밀번호: " + pw + "<br>");
		out.print("비밀번호확인: " + pw1 + "<br>");
		out.print("성별: " + gender + "<br>");
		out.print("혈액형: " + blood + "<br>");
		out.print("생일: " + date + "<br>");
		out.print("취미: " + hobby_res + "<br>");
		out.print("좋아하는색: " + color + "<br>");
		out.print("하고싶은말: " + talk + "<br>");
		

		
	}

}
