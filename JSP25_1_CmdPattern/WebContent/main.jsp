<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 세션에 로그인이 안된 상태이면 login 페이지로 넘김
	if(session.getAttribute("ValidMem") == null) 
	{
%>
		<<jsp:forward page="login.jsp" />
<%
	}

	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h1><%= name %>님 안녕하세요.</h1> <br />
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp;
		<input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
	</form>

</body>
</html>