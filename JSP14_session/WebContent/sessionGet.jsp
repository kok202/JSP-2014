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

		out.println(session.getId() + "<br/>");
		out.println(session.getMaxInactiveInterval() + "<br/>");
		
		
		
		out.println("================<br/>");
		Object obj1 = session.getAttribute("sessionName1");
		Object obj2 = session.getAttribute("sessionName2");
		String objBySession1 = (String) obj1;
		String objBySession2 = (String) obj2;
		out.println(objBySession1 + "<br/>");
		out.println(objBySession2 + "<br/>");
		
		
		
		out.println("================<br/>");
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.println("name : " + name + "<br/>");
			out.println("value : " + value + "<br/>");
		}
		
		
		
		out.println("================<br/>");
		session.removeAttribute("sessionName1");
		enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement().toString();
			String value = session.getAttribute(name).toString();
			out.println("name : " + name + "<br/>");
			out.println("value : " + value + "<br/>");
		}
		
		
		
		out.println("================<br/>");
		session.invalidate();
		if(request.isRequestedSessionIdValid()) 
		{
			out.println("session valid");
		} 
		else 
		{
			out.println("session invalid");
		}
		
	%>
	
</body>
</html>