package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05")
public class ex05 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Post����� �� ���ڵ� ���(����)
		request.setCharacterEncoding("euc-kr");
		
		String text = request.getParameter("text");
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(text);
		
		String[] choice = request.getParameterValues("choice");
		String dessert = request.getParameter("dessert");
		
		String choice_res = "";
		
		for(int i=0; i<choice.length; i++) {
			choice_res = choice_res + choice[i];
			
		}
		
		System.out.println("�����̰� �����̿��� ���� ������: " + choice_res);
		System.out.println("����Ʈ: " + dessert);
		
	}

}
