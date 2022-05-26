<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<a href="join.html"><button>회원가입</button></a>
	<a href="Delete.html"><button>회원삭제</button></a>
	<a href="Update.html"><button>회원수정</button></a>

	<a href="Select.jsp"><button>회원전체검색</button></a>
	<a href="OneSelect.html"><button>회원검색</button></a>

 	<%
/*	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("loginid")) {
		out.print("<a href='#'><button>로그아웃</button></a>");
			}
			if (cookies[i].getName() == null) {
		out.print("<a href='Login.html'><button>로그인</button></a>");
			}
		}
	} else{
		out.print("<a href='Login.html'><button>로그인</button></a>");
	} */
	// 쿠키를 통한 로그인처리(로그인/로그아웃버튼 생성)
	
		String login = (String)session.getAttribute("loginid"); // 세션에서 가져오는거 
	
		if(login==null){
			out.print("<a href='Login.html'><button>로그인</button></a>");
		}else{
			out.print("<br>"+ login + "님 접속을 환영합니다");
			out.print("<a href='LogoutCon'><button>로그아웃</button></a>");
		}
	
	
	%>


</body>
</html>