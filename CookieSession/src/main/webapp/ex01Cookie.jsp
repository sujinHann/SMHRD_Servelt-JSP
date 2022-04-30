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
   //cookie : 사용자의 pc에 서버페이지에서 공유할 데이터를 저장하는 기술
   Cookie cook = new Cookie("NewCookie","SujinHan");
   //         					name      value
   //cook에 쿠키라는 데이터가 저장됨 
   
   //이걸 접속한 사용자에게 보내준다 = 응답 = response
   response.addCookie(cook); //사용자에게 쿠키를 응답
   
   %>
   <h1>쿠키생성완료</h1>
	
</body>
</html>