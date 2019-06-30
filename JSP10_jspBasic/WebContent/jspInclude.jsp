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
	<%
	ArrayList<Integer> temp = new ArrayList<Integer>();
	temp.add(1);
	temp.add(3);
	temp.add(7);
	temp.add(12);
	for(int i = 0; i < temp.size(); i++)
	{
		out.println(temp.get(i));
	}
	%>
</body>
</html>