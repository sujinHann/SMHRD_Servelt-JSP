<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	
	<%-- ��ũ��Ʋ��(Scriptlet) <% ~ :jsp���� �ڹ� �ڵ带 ������ �� �ִ� ���� --%>

	 	<!-- jsp (Java Server Page)	
		�����ϴ� �������� ���� ���� �� �ִ� ���������� (�����ڸ� ����!)
		�����ϴ°���(ó��): ��û-> JSP -> Tomcat -> Servlet -> Class -> �޸����� -> HTML ->���� 
		�������(�ι�°����) : ��û ->JSP -> �޸𸮿� ����� class -> HTML ->���� -->
		

	<!-- request.getParameter("id") jsp�� �̰� �������� ���°� �Ƚᵵ��! -->
	
	<%
	int num = 10;
	%>

	num���� �ȿ� �ִ� ��: <b><%=num%></b>
	
	<%--ǥ���� :jsp������ ������ �޼ҵ带 ����� �� �ִ� ����--%>

	<%--���� 1) 1~100������ �� --%>
	<%
	int sum = 0;
	for (int i = 1; i <= 100; i++) {
		sum += i;
	}
	%>
	<br>1~100������ �� :
	<b><%=sum%></b>

	<%--���� 2) td�� 10�� �ݺ��ϼ��� --%>

	<table border="1">
		<tr>
			<%for(int i =1;i<=10;i++){%>
			<td><%=i%></td>
			<% } %>

		</tr>
	</table>
	
	<%! // ����: JSP������ �޼ҵ峪 ����� ����(X) .java������ ���� �޼ҵ带 ����
	public void sum(int num1, int num2){
		System.out.print(num1+num2);
	}
	
	
	
	
	%>

</body>
</html>