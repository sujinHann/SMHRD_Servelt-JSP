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
		Cookie[] cookies = request.getCookies(); // 사용자가 가지는 쿠키는 한두개가 아니므로 배열로 받음
		// 사용자의 PC에 있는 쿠기값을 가져옴
		
		for(int i=0;i<cookies.length; i++){
			out.print(cookies[i].getName()+"<br>");
			out.print(cookies[i].getValue()+"<br>");
		}
	
	%>

</body>
</html>