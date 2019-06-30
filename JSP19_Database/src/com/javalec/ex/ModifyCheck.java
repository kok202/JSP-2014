package com.javalec.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ModifyCheck")
public class ModifyCheck extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	
	
    public ModifyCheck() 
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
		HttpSession httpSession = request.getSession();
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		if(passwordConfirm(httpSession, pw))
		{
			System.out.println("OK");
			String query = "update member set name ='" + name + "', phone1= '" + phone1 + "', phone2 = '" + phone2 + "', phone3 = '" + phone3 + "', gender = '" + gender + "'";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "scott" , "tiger");
				Statement statement = connection.createStatement();
				int i = statement.executeUpdate(query);
				if(i == 1)
				{
					System.out.println("update success");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				} 
				else 
				{
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}

				if(statement != null) 
					statement.close();
				if(connection != null) 
					connection.close();
			}
			catch(Exception e)
			{
				
			}
		}
		else
		{
			System.out.println("update fail");
			response.sendRedirect("modify.jsp");
		}
	}
	
	
	
	private boolean passwordConfirm(HttpSession httpSession, String pw) 
	{
		String sessionPw =  (String)httpSession.getAttribute("pw");
		if(sessionPw.equals(pw)) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

}
