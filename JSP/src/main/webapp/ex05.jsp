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
	//response.setContentType("text/html;charset=euc-kr"); // �̹� ���� �Ǿ� ���� 
	//PrintWriter out = response.getWriter();

	//response.sendRedirect("https://www.naver.com/"); // �ܺ�,������������ �̵��ϴ� ���
	
	request.setCharacterEncoding("euc-kr");

	response.sendRedirect(request.getParameter("site"));
	
	
	%>

</body>
</html>