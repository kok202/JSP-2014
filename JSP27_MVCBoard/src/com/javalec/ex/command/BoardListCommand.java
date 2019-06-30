package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BoardDAO;
import com.javalec.ex.dto.BoardDTO;


public class BoardListCommand implements BoardCommand 
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
	
}