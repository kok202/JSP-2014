<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import= "java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>HelloWorld!</h1>
	<%!
		String comment1 = "String in declaration";
		public int multiply(int a, int b)
		{
			return a * b;
		}
	%>
	
	
	
	
	
	<%
		String comment2 = "String in scriptlit";
	%>
	
	
	
	
	
	<%
	out.println("" + comment1 + "</br>");
	out.println("" + comment2 + "</br>");
	for(int i = 1; i < 10; i++)
	{

		for(int j = 1; j < 10; j++)
		{
			int result = multiply(i, j);
			out.println("" + i + " * " + j + " = " + result + "</br>");
		}
	}
	%>
	
	
	
	
	<%@ include file="jspInclude.jsp" %>
</body>
</html>