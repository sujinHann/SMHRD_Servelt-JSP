<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>����������</h1>
	<a href="join.html"><button>ȸ������</button></a>
	<a href="Delete.html"><button>ȸ������</button></a>
	<a href="Update.html"><button>ȸ������</button></a>

	<a href="Select.jsp"><button>ȸ����ü�˻�</button></a>
	<a href="OneSelect.html"><button>ȸ���˻�</button></a>

 	<%
/*	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("loginid")) {
		out.print("<a href='#'><button>�α׾ƿ�</button></a>");
			}
			if (cookies[i].getName() == null) {
		out.print("<a href='Login.html'><button>�α���</button></a>");
			}
		}
	} else{
		out.print("<a href='Login.html'><button>�α���</button></a>");
	} */
	// ��Ű�� ���� �α���ó��(�α���/�α׾ƿ���ư ����)
	
		String login = (String)session.getAttribute("loginid"); // ���ǿ��� �������°� 
	
		if(login==null){
			out.print("<a href='Login.html'><button>�α���</button></a>");
		}else{
			out.print("<br>"+ login + "�� ������ ȯ���մϴ�");
			out.print("<a href='LogoutCon'><button>�α׾ƿ�</button></a>");
		}
	
	
	%>


</body>
</html>