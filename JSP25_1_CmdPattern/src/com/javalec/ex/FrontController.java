package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//----------------------------------------------------------------
//Ȯ���� ���� � ������ �̸��̴� Ȯ���ڰ� .do�̸� �������� �Ͷ�
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
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		if(command.equals("/membersAll.do")) 
		{
			response.setContentType("text/html; charset=EUC-KR");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			
			
			// memersAll ��û�� �� ��� membersAllService Ŭ������ ó���ϵ����ض�.
			Service service = new MembersAllService();
			ArrayList<MemberDto> dtos = service.execute(request, response);
			
			
			
			for (int i = 0; i < dtos.size(); i++) 
			{
				MemberDto dto = dtos.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				String name = dto.getName();
				String eMail = dto.geteMail();
				Timestamp rDate = dto.getrDate();
				String address = dto.getAddress();
				
				writer.println(id + ", " + pw + ", " + name + ", " + eMail + ", " + rDate.toLocalDateTime() + ", " + address + "<hr />");
			}
			
			writer.println("</body></html>");
		}
	}

}
