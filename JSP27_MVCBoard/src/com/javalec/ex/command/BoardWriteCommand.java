package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;

public class BoardWriteCommand implements BoardCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = new BoardDAO();
		dao.write(bName, bTitle, bContent);
	}
	
}
