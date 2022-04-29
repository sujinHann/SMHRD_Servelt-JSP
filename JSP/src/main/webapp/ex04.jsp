<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
		<!-- 1~20까지의 숫자를 아래의 td태그에 출력하시오(for)  -->
		
<%-- 			<%
			for(int i =1;i<=20;i++){
				
				out.print("<td>"+i+"</td>");
			} %>
			
			
		
			
			<!--1. 1~20 까지 td태그를 출력 
				2. 끝자리가 3, 6, 9 일때는 배경색 초록색
				3. 끝자리가 5일 때는 배경색 파란색  -->
						
			<%
			for (int i = 1; i <= 20; i++) {
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					out.print("<td bgcolor = 'green'>" + i + "</td>");
				} else if (i % 10 == 5) {
					out.print("<td bgcolor = 'blue'>" + i + "</td>");
				} else {
					out.print("<td>" + i + "</td>");
				}

			}
			%> --%>
			
			<!--ex04.html 파일을 만들어서 입력받는 값만큼 아래 반복하시오  -->
			
			<%
	
			int num = Integer.parseInt(request.getParameter("num"));
			
			//String num = request.getParameter("num");
			//int num_num = Integer.parseInt(num);
			//for (int i = 1; i <= num_num; i++) {
			
			for(int i =1;i<=num;i++){
				
				out.print("<td>"+i+"</td>");
			} 
			
			
			for (int i = 1; i <= num; i++) {
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					out.print("<td bgcolor = 'green'>" + i + "</td>");
				} else if (i % 10 == 5) {
					out.print("<td bgcolor = 'blue'>" + i + "</td>");
				} else {
					out.print("<td>" + i + "</td>");
				}

			}
			%>
			


		</tr>
	</table>

</body>
</html>