package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberForPreDAO 
{
	private DataSource dataSource;
	
	
	
	public MemberForPreDAO() 
	{
		try 
		{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<MemberForPreDTO> memberSelect() 
	{
		
		ArrayList<MemberForPreDTO> dtos = new ArrayList<MemberForPreDTO>();
		
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from memberforpre");
			
			while (rs.next()) 
			{
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone = rs.getString("phone");
				
				MemberForPreDTO dto = new MemberForPreDTO(name, id, pw, phone);
				dtos.add(dto);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(rs != null) 
					rs.close();
				if(stmt != null) 
					stmt.close();
				if(con != null) 
					con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	
	
	public boolean memberInsert() 
	{
		int result;
		boolean insertSuccess = false;
		ArrayList<MemberForPreDTO> dtos = new ArrayList<MemberForPreDTO>();
		String query = "insert into memberforpre (id, pw, name, phone) values (?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement preStmt = null;
		
		try 
		{
			con = dataSource.getConnection();
			preStmt = con.prepareStatement(query);
			
			preStmt.setString(1, "abc");
			preStmt.setString(2, "123");
			preStmt.setString(3, "È«±æµ¿");
			preStmt.setString(4, "010-1234-5678");
			result = preStmt.executeUpdate();
			
			preStmt.setString(1, "def");
			preStmt.setString(2, "456");
			preStmt.setString(3, "È«±æÀÚ");
			preStmt.setString(4, "010-9012-3456");
			result = preStmt.executeUpdate();
			
			preStmt.setString(1, "ghi");
			preStmt.setString(2, "789");
			preStmt.setString(3, "È«±æ¼ø");
			preStmt.setString(4, "010-7890-1234");
			result = preStmt.executeUpdate();
			
			preStmt.setString(1, "AAA");
			preStmt.setString(2, "111");
			preStmt.setString(3, "ÀÌ±æµ¿");
			preStmt.setString(4, "010-1234-1111");
			result = preStmt.executeUpdate();

			if(result == 1) 
			{
				System.out.println("insert success");
				insertSuccess = true;
			} 
			else 
			{
				System.out.println("insert fail");
				insertSuccess = false;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preStmt != null) 
					preStmt.close();
				if(con != null) 
					con.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		return insertSuccess;
	}
}
