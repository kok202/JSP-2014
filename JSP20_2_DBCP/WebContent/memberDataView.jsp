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
			out.println("ȸ�� ���� ���⸸ ��û<br/>");
		}
		else
		{
			if(Integer.parseInt(reqString) == 1)
			{
				out.println("Success : ȸ�� ���� ���� ����<br/>");
			}
			else
			{
				out.println("Error : ȸ�� ���� ���� ����<br/>");
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
			out.println("���̵� : " + id + " ");
			out.println("��й�ȣ : " + pw + " ");
			out.println("�̸� : " + name + " ");
			out.println("�ڵ��� : " + phone + " <br/>");
			
		}
	%>
	
</body>
</html>