package com.javalec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//----------------------------------------------------------------
//확장자 패턴 어떤 파일의 이름이던 확장자가 .do이면 이쪽으로 와라
//----------------------------------------------------------------
@WebServlet("*.do")
public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	
	
    public FrontController() 
    {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("doGet");
		actionDo(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("actionDo");
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);

		
		
		if(command.equals("/insert.do"))
		{
			System.out.println("insert");
			System.out.println("----------------");
		}
		else if(command.equals("/update.do"))
		{
			System.out.println("update");
			System.out.println("----------------");
		}
		else if(command.equals("/select.do"))
		{
			System.out.println("select");
			System.out.println("----------------");
		}
		else if(command.equals("/delete.do"))
		{
			System.out.println("delete");
			System.out.println("----------------");
		}
	}

}
