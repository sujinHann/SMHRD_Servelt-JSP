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
   //cookie : ������� pc�� �������������� ������ �����͸� �����ϴ� ���
   Cookie cook = new Cookie("NewCookie","SujinHan");
   //         					name      value
   //cook�� ��Ű��� �����Ͱ� ����� 
   
   //�̰� ������ ����ڿ��� �����ش� = ���� = response
   response.addCookie(cook); //����ڿ��� ��Ű�� ����
   
   %>
   <h1>��Ű�����Ϸ�</h1>
	
</body>
</html>