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
	//response.setContentType("text/html;charset=euc-kr"); // 이미 정의 되어 있음 
	//PrintWriter out = response.getWriter();

	//response.sendRedirect("https://www.naver.com/"); // 외부,내부페이지로 이동하는 기능
	
	request.setCharacterEncoding("euc-kr");

	response.sendRedirect(request.getParameter("site"));
	
	
	%>

</body>
</html>