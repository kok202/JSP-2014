<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>




	<jsp:include page="cookieTest.jsp"/>
	<%
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++)
		{
			String str = cookies[i].getName();
			if(str.equals("cookieName"))
			{
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<br/>
	<jsp:include page="cookieTest.jsp"/>
	
	
	
	
	<a href="cookieTest.jsp"> cookie Test</a>




</body>
</html>