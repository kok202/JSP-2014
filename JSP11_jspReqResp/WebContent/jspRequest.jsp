<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.Arrays"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>



	<%
		out.println("���� : " + request.getServerName() + "<br/>");
		out.println("��Ʈ : " + request.getServerPort() + "<br/>");
		out.println("��û : " + request.getMethod() + "<br/>");
		out.println("URL : " + request.getRequestURL() + "<br/>");
		out.println("URI : " + request.getRequestURI() + "<br/>");
		out.println("�������� : " + request.getProtocol() + "<br/>");
	%>
	

	
	<%
		request.setCharacterEncoding("EUC-KR");
		String[] hobbys = request.getParameterValues("hobby");
		out.println("fromForm(�̸�) : " + request.getParameter("name") + "<br/>");
		out.println("fromForm(���) : " + request.getParameter("password") + "<br/>");
		out.println("fromForm(��������) : " + request.getParameter("protocol") + "<br/>");
		out.println("fromForm(���) : " + Arrays.toString(hobbys) + "<br/>");
	%>
	

	
	
	<form action="ageCheck.jsp" method="post">
		���̴� : <input type="text" name="age" size="5"><br/>
		<input type="submit" value="����">
	</form>
	
	
</body>
</html>