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
	String id = (String) session.getAttribute("id");
	%>
	<table border="1" style="text-align: center;">
		<tr>
			<th> <%=id%>�� ȯ���մϴ�.</th>
		</tr>
		<tr>
			<td><a href=Logout><button>�α׾ƿ�</button></a></td>
		</tr>
	</table>
</body>
</html>