<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
/* 	request.getParameter("");
	request.setCharacterEncoding("euc-kr");

	response.setContentType("");
	response.getWriter(); */
	
	//내장객체 : JSP에서는 Servlet에서 자주 사용되는 객체를 미리 선언

	out.print("Hello");
	%>


	<table border="1">
		<tr>
			<%for(int i =1;i<=10;i++){
				
				out.print("<td>"+i+"</td>");
			} %>

		</tr>
	</table>
	
	<%
		GregorianCalendar gre = new GregorianCalendar(Locale.KOREA);
		//현재 날짜와 시간을 가져오는 객체 
	
		int year = gre.get(gre.YEAR);
		int month = gre.get(gre.MONTH);
		int date = gre.get(gre.DATE);
		int hour = gre.get(gre.HOUR);
		int min = gre.get(gre.MINUTE);
		int sec = gre.get(gre.SECOND);
	
	%>
	
	<%=year %>년 <%=month %>월 <%=date %>일<br>
	<%=hour %>시 <%=min %>분 <%=sec %>초

</body>
</html>