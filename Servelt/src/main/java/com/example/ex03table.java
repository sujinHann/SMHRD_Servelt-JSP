package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03table")
public class ex03table extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���� ������(response)
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		
		out.print("<head>");
		out.print("<style>");
		out.print("table,td{border: lpx solid;}");
		out.print("</style>");
		out.print("</head>");
		
		
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		for(int i=1; i<=6; i++) {
			out.print("<td>"+i+"</td>");
		}
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		
		
		out.print("</html>");
	}

}
