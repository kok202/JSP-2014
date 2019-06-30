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
			request.setAttribute("id", "abcde");
			request.setAttribute("pw", "12345");
			response.sendRedirect("ForwardingHttpServlet");
			
			// request에 어트리뷰트를 실어 보내지만 
			// response.sendRedirect()를 이용할 경우 (즉 HttpServletResponse를 이용할 경우)
			// 웹 클라이언트를 거쳐서 포워딩 되기 때문에 
			// ForwardingHttpServlet에서 받은 request는 값이 다를 수 밖에 없다.
		%>

</body>
</html>