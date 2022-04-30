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
	// 형변환 필요 : Object로 반환하므로 
	String str = (String) session.getAttribute("NewSession");
	%>
	NewSession에 있는 데이터 : <%=str %>
	
	<a href = "ex03Session.jsp">세선삭제하기</a>

</body>
</html>