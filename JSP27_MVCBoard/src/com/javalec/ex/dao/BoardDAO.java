package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.dto.BoardDTO;

public class BoardDAO 
{
	DataSource dataSource; // DBCP
	
	
	
	public BoardDAO() 
	{
		try 
		{
			// DBCP를 만듭니다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	

	// 글 목록을 반환 받습니다.
	public ArrayList<BoardDTO> list() 
	{
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try 
		{
			connection = dataSource.getConnection();
			
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) 
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				BoardDTO dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(resultSet != null) 
					resultSet.close();
				if(preparedStatement != null) 
					preparedStatement.close();
				if(connection != null) 
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	
	// 글을 작성합니다.
	public void write(String bName, String bTitle, String bContent) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			int rn = preparedStatement.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null) 
					preparedStatement.close();
				if(connection != null) 
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
	
	
	
	// 글 내용을 반환 받습니다.
	public BoardDTO contentView(String strID) 
	{
		upHit(strID);
		
		BoardDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try 
		{
			connection = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) 
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	
	
	// 글을 수정합니다.
	public void modify(String bId, String bName, String bTitle, String bContent) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			int rn = preparedStatement.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
	
	
	
	// 글을 삭제합니다.
	public void delete(String strId) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			// 근데 버그 있음 
			// 0
			//  1
			//   2
			//  3
			//   4
			// 일 때 1을 삭제하면 1 만 삭제됨
			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strId));
			int rn = preparedStatement.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
	}
	
	
	
	// 답글 작성 창을 가져옵니다.
	public BoardDTO reply_view(String str) 
	{
		BoardDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(str));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) 
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				dto = new BoardDTO(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
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
				if(preparedStatement != null) 
					preparedStatement.close();
				if(connection != null) 
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	
	
	// 답글 작성을 요청합니다.
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) 
	{
	
		replyShape(bGroup, bStep);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = preparedStatement.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	// 답글 작성을 요청합니다. (reply 메소드 안에서 호출됨)
	private void replyShape(String strGroup, String strStep) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strGroup));
			preparedStatement.setInt(2, Integer.parseInt(strStep));
			
			int rn = preparedStatement.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	
	
	// 조회수를 늘립니다.
	private void upHit( String bId) 
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			
			int rn = preparedStatement.executeUpdate();
					
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null) 
					connection.close();
			} 
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
}
