<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
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
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement().toString();
			String value = session.getAttribute(name).toString();
			if(value.equals("abcde"))
			{
				out.println("abcde�� �ݰ����ϴ�.<br/>");
				session.removeAttribute(name);
			}
		}
	%>
	
	<a href="logout.jsp">�α׾ƿ�</a>
	<br/>
	<jsp:include page="sessionTest.jsp"/>
	
	

</body>
</html>