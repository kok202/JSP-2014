<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		int i = 0;
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements())
		{
			i++;
			String name = enumeration.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.println("name : " + name + "<br/>");
			out.println("value : " + value + "<br/>");
		}
		if(i==0)
			out.println("세션이 삭제 되었습니다.");
	%>
	
</body>
</html>