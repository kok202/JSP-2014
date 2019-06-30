<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% 
	String name = (String) session.getAttribute("name"); 
	String id = (String) session.getAttribute("id"); 
	out.println("" + name + "님,  ID : " + id + "으로 접송하셨습니다.");
%>

로그인이 정상 처리 되었습니다.<br />
<a href="modify.jsp">회원정보 수정</a>

</body>
</html>