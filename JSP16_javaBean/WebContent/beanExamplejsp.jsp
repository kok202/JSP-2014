<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="studentTemp" class="com.javalec.ex.Student" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:setProperty name="studentTemp" property="name" value="ȫ�浿"/>
	<jsp:setProperty name="studentTemp" property="age" value="13"/>
	<jsp:setProperty name="studentTemp" property="grade" value="6"/>
	<jsp:setProperty name="studentTemp" property="studentNum" value="7"/>
	�̸� : <jsp:getProperty name="studentTemp" property="name" /><br />
	���� : <jsp:getProperty name="studentTemp" property="age" /><br />
	�г� : <jsp:getProperty name="studentTemp" property="grade" /><br />
	��ȣ : <jsp:getProperty name="studentTemp" property="studentNum" /><br />
	
	<jsp:setProperty name="studentTemp" property="name" value="�׽�Ʈ"/>
	�̸� : <jsp:getProperty name="studentTemp" property="name" /><br />
	���� : <jsp:getProperty name="studentTemp" property="age" /><br />
	�г� : <jsp:getProperty name="studentTemp" property="grade" /><br />
	��ȣ : <jsp:getProperty name="studentTemp" property="studentNum" /><br />


</body>
</html>