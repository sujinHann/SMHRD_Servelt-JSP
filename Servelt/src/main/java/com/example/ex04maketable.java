package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex04maketable")
public class ex04maketable extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String num = request.getParameter("num");
		
		int num1 = Integer.parseInt(num);
		
		// 응답 데이터(response)
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("몇개의 방을 만들까요? ");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("table,td{border: 1px solid;}");
		out.print("</style>");
		out.print("</head>");
	
		out.print("<body>");
		
		out.print("<table border = 1>");
		out.print("<tr>");
		for(int i=1; i<=num1; i++) {
			out.print("<td>"+i+"</td>");
		}
		out.print("</tr>");
		out.print("</table>");

		out.print("</body>");
		out.print("</html>");
		
	}

}
