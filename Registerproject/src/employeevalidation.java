

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeevalidation")
public class employeevalidation extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		ServletContext sc=getServletContext();
		sc.setAttribute("name","u");
		if(logindb.validate(u,p))
		{
			RequestDispatcher rd=request.getRequestDispatcher("employeswelcome");
			rd.forward(request, response);
			
		}
		else
		{   out.println("sorry username or passworderror");
			RequestDispatcher rd=request.getRequestDispatcher("employeslogin.html");
			rd.include(request, response);
			
		}
	}
}
			
	


