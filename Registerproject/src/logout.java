


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class logout extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;  
		  Statement stmt = null;
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		 
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
				
				 stmt=con.createStatement();
					ServletContext sc=getServletContext();
					String p =(String) sc.getAttribute("name");
				
		    Date today = new Date();
		    String sql="insert into iyappan(name,endingtime)values('"+p+"','"+today+"')";
	      stmt.execute(sql);
	   	   	out.print("<h1>your logout time is : </h1>");
	   	   
	   	 out.println(today);
	    out.print("<a href='employeslogin.html'>loginpage</a>");
	    

	      out.close();
	      stmt.close();
	      con.close();
	      
		     }
			catch(Exception e)
			{  
			    System.out.println("Exception is ;"+e);  
			    }  
	}
	}
