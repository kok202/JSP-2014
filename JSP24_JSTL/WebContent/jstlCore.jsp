<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	
	
	<c:set var="mult" value="2"/>
	<c:forEach var="i" begin="1" end="30" step="1">
		<c:if test="${i%3 == 0}">
			${mult * i}<br/>
		</c:if>
	</c:forEach>
	
	

</body>
</html>