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
		Cookie[] cookies = request.getCookies(); // ����ڰ� ������ ��Ű�� �ѵΰ��� �ƴϹǷ� �迭�� ����
		// ������� PC�� �ִ� ���Ⱚ�� ������
		
		for(int i=0;i<cookies.length; i++){
			out.print(cookies[i].getName()+"<br>");
			out.print(cookies[i].getValue()+"<br>");
		}
	
	%>

</body>
</html>