package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;

public class BoardReplyCommand implements BoardCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		BoardDAO dao = new BoardDAO();
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
