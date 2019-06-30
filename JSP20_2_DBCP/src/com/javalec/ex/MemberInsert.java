package com.javalec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert")
public class MemberInsert extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	
	public MemberInsert() 
    {
        super();
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		MemberForPreDAO memberForPreDAO = new MemberForPreDAO();
		if(memberForPreDAO.memberInsert() == true)
		{
			response.sendRedirect("memberDataView.jsp?InsertResult=1");
		}
		else 
		{
			response.sendRedirect("memberDataView.jsp?InsertResult=0");
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
