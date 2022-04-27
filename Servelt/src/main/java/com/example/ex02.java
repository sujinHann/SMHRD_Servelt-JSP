package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class ex02 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자가 입력한 정보를 가져오는 기능 
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String cal = request.getParameter("cal");
		
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);
		
		// System.out.println(num3+num4);
		
		//response : 서버프로그램에서 사용자에게 응답을 할 수 있게 해주는 객체 
		//응답하는 파일을 생성하고 인코딩방식 지정
		response.setContentType("text/html;charset=euc-kr");
		// 응답하는 파일과 현재 작업하고 있는 Servelt파일을 이어주는 통로객체 생성
		PrintWriter out = response.getWriter();

		// 사용자가 선택한 값을 통해서 해당하는 사칙연산 값을 출력하시오
		if (cal.equals("+")) {
			System.out.println(num3+num4);
			out.print(num3 + num4);
		} else if (cal.equals("-")) {
			System.out.println(num3-num4);
			out.print(num3 - num4);
		} else if (cal.equals("*")) {
			System.out.println(num3*num4);
			out.print(num3 * num4);
		} else if (cal.equals("/")) {
			System.out.println(num3/num4);
			out.print(num3 / num4);
		} 

	}

}
