package com.javalec.ex;

public class MemberForPreDTO 
{

	private String name;
	private String id;
	private String pw;
	private String phone;
	
	
	
	public MemberForPreDTO(String name, String id, String pw, String phone) 
	{
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}



	public String getName() 
	{
		return name;
	}



	public void setName(String name) 
	{
		this.name = name;
	}



	public String getId() 
	{
		return id;
	}



	public void setId(String id) 
	{
		this.id = id;
	}



	public String getPw() 
	{
		return pw;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public void setPw(String pw) 
	{
		this.pw = pw;
	}

	
}
