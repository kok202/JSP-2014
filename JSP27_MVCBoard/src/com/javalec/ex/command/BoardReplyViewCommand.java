package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;

public class BoardReplyViewCommand implements BoardCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		
		String bId = request.getParameter("bId");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.reply_view(bId);
		request.setAttribute("reply_view", dto);
		
	}

}
