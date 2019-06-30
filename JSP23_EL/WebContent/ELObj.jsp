<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<form action="ELObjCheck.jsp" method="get">
		아이디 : <input type="text" name="id"><br />
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="login">
	</form>
	
	<% 
		application.setAttribute("application_name", "app123");
		session.setAttribute("session_name", "sess123");
		pageContext.setAttribute("page_name", "page123");
		request.setAttribute("request_name", "req123");
	%>
	
</body>
</html>