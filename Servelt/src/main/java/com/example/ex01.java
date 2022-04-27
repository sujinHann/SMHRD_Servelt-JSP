package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex01")
public class ex01 extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Servelt : Server + Applet
		//			WAS(Tomcat)���� ��ġ�Ǿ� �����ϴ� �������α׷� 
		//			Jave=main / Servlet=service
		// �� ������ �ּ�: 59.0.234.149
		System.out.println("������ ����");
		
		//request : �������α׷��� ��û�ϴ� ������� ��� �����͸� �����ִ� ��ü
		String IP = request.getRemoteAddr(); //������� IP�� ������ �� �ִ� ���
		System.out.println("������ ����� IP : " + IP);
		
		//response : �������α׷����� ����ڿ��� ������ �� �� �ְ� ���ִ� ��ü 
		response.setContentType("text/html;charset=euc-kr");
		//�����ϴ� ������ �����ϰ� ���ڵ���� ����
		PrintWriter out = response.getWriter();
		//�����ϴ� ���ϰ� ���� �۾��ϰ� �ִ� Servlet������ �̾��ִ� ��ΰ�ü ���� 
		out.print("����������<br>");
		
		// ������ �������� ���� "������ ȯ���մϴ�"�� ��� 59.0.249.7
		// ������ �������� ���� "���� ȯ���մϴ�"�� ���
		// �ٸ� ������� �������� ���� "�մ� ȯ���մϴ�"�� ���
		
		if(IP.equals("59.0.249.7")){
			System.out.println("������ ȯ���մϴ�");		
			out.print("������ ȯ���մϴ�");	
		}else if(IP.equals("211.223.37.142")||IP.equals("211.48.213.202")||IP.equals("220.93.229.247")) {
			System.out.println("���� ȯ���մϴ�");	
			out.print("���� ȯ���մϴ�");
		}else {
			System.out.println("�մ� ȯ���մϴ�");	
			out.print("�մ� ȯ���մϴ�");
		}
		
		
	}

}
