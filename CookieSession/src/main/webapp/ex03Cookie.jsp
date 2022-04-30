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
		Cookie cook = new Cookie("NewCookie", "");
		
		cook.setMaxAge(0); // 쿠키의 생명 주기 , 0초면 생기다가 바로 사라짐 -> 삭제
		
		response.addCookie(cook);
	%>

</body>
</html>