<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>



<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	String query = "select * from member";
%>



<%
	Connection connection;
	Statement  statement;
	ResultSet  resultSet;
	try
	{
		Class.forName(driver);
		connection = DriverManager.getConnection(url, uid, upw);
		statement  = connection.createStatement();
		resultSet  = statement.executeQuery(query);
		
		while(resultSet.next())
		{
			String id = resultSet.getString("id");
			String pw = resultSet.getString("pw");
			String nm = resultSet.getString("name");
			String ph = resultSet.getString("phone");
			out.println("ID : " + id + "\tPW : " + pw + "\tName : " + nm + "\tPhone : " + ph + "<br/>");
		}
		
		if(resultSet != null) 
			resultSet.close();
		if(statement != null) 
			statement.close();
		if(connection != null) 
			connection.close();
	}
	catch(Exception e)
	{
		
	}
%>



</body>
</html>