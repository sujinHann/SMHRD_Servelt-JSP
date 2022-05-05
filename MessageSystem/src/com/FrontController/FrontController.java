package com.FrontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.POJO.DeleteCon;
import com.POJO.IdCheckCon;
import com.POJO.JoinCon;
import com.POJO.LogOutCon;
import com.POJO.LoginCon;
import com.POJO.UpdateCon;

//확장자패턴 사용: 어떤 요청이던 간에 뒤에 .do가 붙어 있으면 이 서블릿에서 받아서 처리 
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("도착");

		// 요청내용
		String reqURI = request.getRequestURI();
		System.out.println("요청 URI : " + reqURI);

		// 프로젝트 명
		String path = request.getContextPath();
		System.out.println("프로젝트 명: " + path);

		// 문자열 자르기 -> reqURI - 프로젝트명
		String result = reqURI.substring(path.length() + 1);
		System.out.println(result);

		Command command = null;

		if (result.equals("LoginCon.do")) {
			// LoginCon(Command 구현)
			// execute 메서드 호출
			command = new LoginCon();

		} else if (result.equals("JoinCon.do")) {

			command = new JoinCon();

		} else if (result.equals("UpdateCon.do")) {

			command = new UpdateCon();

		} else if (result.equals("DeleteCon.do")) {

			command = new DeleteCon();

		} else if (result.equals("LogOutCon.do")) {

			command = new LogOutCon();

		} else if (result.equals("IdCheckCon.do")) {

			command = new IdCheckCon();

		}

		String url = command.execute(request, response);

		if (url.equals("true") || url.equals("false")) {
			PrintWriter out = response.getWriter();
			out.print(url);		
		} else if(url.equals("joinSuccess.jsp")){
			//포워딩 방식으로 이동할 경로 지정
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);			
		} else {
			response.sendRedirect(url);
		}

	}
}
