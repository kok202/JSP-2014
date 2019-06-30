package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;


public class BoardContentCommand implements BoardCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String bId = request.getParameter("bId");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(bId);
		request.setAttribute("content_view", dto);
	}

}
