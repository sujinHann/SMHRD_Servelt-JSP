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
		<!-- 1~20������ ���ڸ� �Ʒ��� td�±׿� ����Ͻÿ�(for)  -->
		
<%-- 			<%
			for(int i =1;i<=20;i++){
				
				out.print("<td>"+i+"</td>");
			} %>
			
			
		
			
			<!--1. 1~20 ���� td�±׸� ��� 
				2. ���ڸ��� 3, 6, 9 �϶��� ���� �ʷϻ�
				3. ���ڸ��� 5�� ���� ���� �Ķ���  -->
						
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
			
			<!--ex04.html ������ ���� �Է¹޴� ����ŭ �Ʒ� �ݺ��Ͻÿ�  -->
			
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