package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ForwardingHttpServlet")
public class ForwardingHttpServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    

	
	 public ForwardingHttpServlet() 
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
		String id = (String) request.getAttribute("id");
		String pw = (String) request.getAttribute("pw");
		
		response.setContentType("text/jhtml; charset=EUC-KR");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>");
		writer.print("RequestObj" + "<hr />");
		writer.print("id : " + id + "<br />");
		writer.print("pw : " + pw);
		writer.print("</body></html>");
		
	}

}
