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
		out.println("서버 : " + request.getServerName() + "<br/>");
		out.println("포트 : " + request.getServerPort() + "<br/>");
		out.println("요청 : " + request.getMethod() + "<br/>");
		out.println("URL : " + request.getRequestURL() + "<br/>");
		out.println("URI : " + request.getRequestURI() + "<br/>");
		out.println("프로토콜 : " + request.getProtocol() + "<br/>");
	%>
	

	
	<%
		request.setCharacterEncoding("EUC-KR");
		String[] hobbys = request.getParameterValues("hobby");
		out.println("fromForm(이름) : " + request.getParameter("name") + "<br/>");
		out.println("fromForm(비번) : " + request.getParameter("password") + "<br/>");
		out.println("fromForm(프로토콜) : " + request.getParameter("protocol") + "<br/>");
		out.println("fromForm(취미) : " + Arrays.toString(hobbys) + "<br/>");
	%>
	

	
	
	<form action="ageCheck.jsp" method="post">
		나이는 : <input type="text" name="age" size="5"><br/>
		<input type="submit" value="전송">
	</form>
	
	
</body>
</html>