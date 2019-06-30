package com.javalec.ex;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/JoinCheck")
public class JoinCheck extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	
	
    public JoinCheck() 
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		String query = "insert into member values('" + name + "', '" + id + "', '" + pw + "', '" + phone1 + "', '" + phone2 + "', '"+ phone3 + "', '" + gender + "')";
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "scott" , "tiger");
			Statement statement = connection.createStatement();
			int queryResult = statement.executeUpdate(query);
			
			if(queryResult == 1)
			{
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp");
			} 
			else 
			{
				System.out.println("insert fail");
				response.sendRedirect("join.html");
			}

			if(statement != null) 
				statement.close();
			if(connection != null) 
				connection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
