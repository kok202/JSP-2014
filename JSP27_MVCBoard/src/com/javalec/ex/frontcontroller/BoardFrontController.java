package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BoardCommand;
import com.javalec.ex.command.BoardContentCommand;
import com.javalec.ex.command.BoardDeleteCommand;
import com.javalec.ex.command.BoardListCommand;
import com.javalec.ex.command.BoardModifyCommand;
import com.javalec.ex.command.BoardReplyCommand;
import com.javalec.ex.command.BoardReplyViewCommand;
import com.javalec.ex.command.BoardWriteCommand;


@WebServlet("*.do")
public class BoardFrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	

    public BoardFrontController() 
    {
        super();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		actionDo(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		actionDo(request, response);
	}

	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("EUC-KR");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String cmdPath = uri.substring(conPath.length());
		System.out.println(cmdPath);

		
		String responseViewPage = null;	//� �������� ������ ���ΰ�
		BoardCommand command = null;	//� ������ ������ ���ΰ�
		if(cmdPath.equals("/write_view.do"))
		{
			responseViewPage = "write_view.jsp";
		}
		else if(cmdPath.equals("/write.do"))
		{
			// list.do �� �̵��ϸ� �ٽ��ѹ� front controller�� ���ͼ�
			// list.do �б⿡ ���� list.jsp�� �̵��մϴ�.
			responseViewPage = "list_view.do";
			command = new BoardWriteCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/list_view.do"))
		{
			// ���⸸  list.jsp��
			responseViewPage = "list_view.jsp"; 
			command = new BoardListCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/content_view.do"))
		{
			responseViewPage = "content_view.jsp";
			command = new BoardContentCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/modify.do"))
		{
			responseViewPage = "list_view.do";
			command = new BoardModifyCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/delete.do"))
		{
			responseViewPage = "list_view.do";
			command = new BoardDeleteCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/reply_view.do"))
		{
			responseViewPage = "reply_view.jsp";
			command = new BoardReplyViewCommand();
			command.execute(request, response);
		}
		else if(cmdPath.equals("/reply.do"))
		{
			responseViewPage = "list_view.do";
			command = new BoardReplyCommand();
			command.execute(request, response);
		}
		
		// RequestDispatcher�� ������ (request��ü�� �Ȱ��� ���޵�)
		// command�� execute�� ���� request�� DTO �����Ͱ� ���
		RequestDispatcher dispatcher = request.getRequestDispatcher(responseViewPage);
		dispatcher.forward(request, response);
	}

	
	
	
}
