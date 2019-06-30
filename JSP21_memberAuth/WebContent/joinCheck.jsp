<%@page import="java.sql.Timestamp"%>
<%@page import="com.javalec.ex.*"%>
<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"/>
<jsp:setProperty name="dto" property="*" />
<!-- setProperty 할 때 *를 쓰면 reg_frm과 클래스 내의 매개변수 명이 같으면 자동으로 입력가능. -->

<%
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		MemberDao dao = MemberDao.getInstance();
		if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) 
		{
%>
			<script language="javascript">
				alert("아이디가 이미 존재 합니다.");
				history.back();
				<!--브라우저를 뒤로 돌립니다.-->
			</script>
<%
		} 
		else 
		{
			int ri = dao.insertMember(dto);
			if(ri == MemberDao.MEMBER_JOIN_SUCCESS) 
			{
				// login 창에 id를 자동으로 입력해주고자
				session.setAttribute("id", dto.getId());
%>
				<script language="javascript">
					alert("회원가입을 축하 합니다.");
					document.location.href="login.jsp";
				</script>
<%
			} 
			else 
			{
%>
				<script language="javascript">
					alert("회원가입에 실패했습니다.");
					document.location.href="login.jsp";
				</script>
<%
			}
		}
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
</body>
</html>