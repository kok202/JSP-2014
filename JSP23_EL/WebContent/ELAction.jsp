<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="temp" class="com.javalec.ex.Member" scope="page" />
<jsp:setProperty name="temp" property="name" value="����"/>
<jsp:setProperty name="temp" property="id" value="kok202"/>
<jsp:setProperty name="temp" property="pw" value="123456"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	�̸� : <jsp:getProperty name="temp" property="name"/><br/>
	���̵� : <jsp:getProperty name="temp" property="id"/><br/>
	�н����� : <jsp:getProperty name="temp" property="pw"/><br/>
	<hr/>
	�̸� : ${temp.name}<br/>
	���̵� : ${temp.id}<br/>
	�н����� : ${temp.pw}<br/>
	
</body>
</html>