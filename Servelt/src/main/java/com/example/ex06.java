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
		
		//Post����� �� ���ڵ� ���(����)
		request.setCharacterEncoding("euc-kr");
		
		//����ڰ� �Է��� ������ �������� ��� 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("pw1");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String date = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String talk = request.getParameter("talk");
		
		//hobby�� �ߺ�����.. �迭��...
		String hobby_res = ""; // �ʱⰪ���� 
		
		for(int i=0; i<hobby.length; i++) {
			hobby_res = hobby_res + hobby[i];
			
		}
		
		// ���� ������(response)
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		

		
		out.print("���̵�: " + id + "<br>");
		out.print("��й�ȣ: " + pw + "<br>");
		out.print("��й�ȣȮ��: " + pw1 + "<br>");
		out.print("����: " + gender + "<br>");
		out.print("������: " + blood + "<br>");
		out.print("����: " + date + "<br>");
		out.print("���: " + hobby_res + "<br>");
		out.print("�����ϴ»�: " + color + "<br>");
		out.print("�ϰ������: " + talk + "<br>");
		

		
	}

}
