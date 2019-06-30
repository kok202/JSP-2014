<%@page import="com.javalec.ex.MemberForPreDTO"%>
<%@page import="com.javalec.ex.MemberForPreDAO"%>
<%@page import="java.util.ArrayList"%>
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
	
	<%
		
		String reqString = request.getParameter("InsertResult");
		if(reqString == null)
		{
			out.println("회원 정보 보기만 요청<br/>");
		}
		else
		{
			if(Integer.parseInt(reqString) == 1)
			{
				out.println("Success : 회원 정보 삽입 성공<br/>");
			}
			else
			{
				out.println("Error : 회원 정보 삽입 실패<br/>");
			}
		}
	%>
	
	
	
	<%
		MemberForPreDAO memberForPreDAO = new MemberForPreDAO();
		ArrayList<MemberForPreDTO> memberArray = memberForPreDAO.memberSelect();
		int length = memberArray.size();
		for(int i = 0; i < length; i++)
		{
			String id = memberArray.get(i).getId();
			String pw = memberArray.get(i).getPw();
			String name = memberArray.get(i).getName();
			String phone = memberArray.get(i).getPhone();
			out.println("아이디 : " + id + " ");
			out.println("비밀번호 : " + pw + " ");
			out.println("이름 : " + name + " ");
			out.println("핸드폰 : " + phone + " <br/>");
			
		}
	%>
	
</body>
</html>