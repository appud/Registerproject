

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employeswelcome")
public class employeswelcome extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
				Statement stmt=con.createStatement();
				ServletContext sc=getServletContext();
				String p =(String) sc.getAttribute("name");
		    Date today = new Date();
		    out.println("<h1>your login time is : </h1>");
		    out.println(today);
	      String sql="insert into iyappan(name,startingtime)values('"+u+"','"+today+"')";
	      stmt.execute(sql);
	      out.print("<a href='logout'>logout</a>");
	      
	      
		     }
			catch(Exception e)
			{  
			    System.out.println("Exception is ;"+e);  
			    }  
	}
	}