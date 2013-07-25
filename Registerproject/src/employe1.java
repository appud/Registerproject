

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

	@WebServlet("/employe1")
	public class employe1 extends HttpServlet 
	{
		protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{

	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	String u=request.getParameter("username");
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	try
	{
    c
	stmt = con.createStatement();
	rs = stmt.executeQuery("Select * from iyap");
	pw.println("Id "+ " Name" +" Address" + "<br>");
	while(rs.next())
	{
	pw.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + "<br>");
	}
	}
	catch (Exception e){
	pw.println(e);
	}
	}
	}