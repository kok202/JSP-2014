<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	
	
	<form action="jspRequest.jsp" method="post">
		�̸� : <input type="text" name="name" size="10"><br/>
		���̵� : <input type="text" name="id" size="10"><br/>
		��й�ȣ : <input type="password" name="pw" size="10"><br/>
		��� : <input type="checkbox" name="hobby" value="read">����
		<input type="checkbox" name="hobby" value="cook">�丮
		<input type="checkbox" name="hobby" value="run">����
		<input type="checkbox" name="hobby" value="swim">����
		<input type="checkbox" name="hobby" value="sleep">��ħ<br/>
		���� : <input type="radio" name="major" value="kor">����
		<input type="radio" name="major" value="eng" checked="checked">����
		<input type="radio" name="major" value="mat" >����
		<input type="radio" name="major" value="des" >������<br/>
		<select name="protocol">
			<option value="http">http</option>
			<option value="ftp" selected="selected">ftp</option>
			<option value="smtp">smtp</option>
			<option value="pop">pop</option>
		</select><br/>
		<input type="submit" value="����">
		<input type="reset" value="�ʱ�ȭ">
	</form>
	
	
	
</body>
</html>