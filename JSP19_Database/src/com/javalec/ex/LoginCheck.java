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




@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
    public LoginCheck() 
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
		String name = "";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String query = "select * from member where id = '" + id + "' and pw ='" + pw + "'";
		System.out.println(query);
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "scott" , "tiger");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			boolean findData = false;

			while(resultSet.next())
			{
				name = resultSet.getString("name");
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
				findData = true;
				break;
			}

			if(resultSet != null)
				resultSet.close();
			if(statement != null) 
				statement.close();
			if(connection != null) 
				connection.close();
			
			if(findData == true)
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("name", name);
				httpSession.setAttribute("id", id);
				httpSession.setAttribute("pw", pw);
				response.sendRedirect("loginResult.jsp");
			}
			else
			{
				response.sendRedirect("login.html");
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
