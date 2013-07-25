

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employeinformation")
public class employeinformation extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String u=request.getParameter("username");
		
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
	    Class.forName("com.mysql.jdbc.Driver");
	    con =DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
				
		ps = con.prepareStatement("Select * from iyap where username=?");
		ps.setString(1,u);
		pw.print("<table>");
		rs = ps.executeQuery();
		/*ResultSetMetaData rsmd=rs.getMetaData();
		int total=rsmd.getColumnCount();
		pw.println("<tr>");
		for(int i=1;i<=total;i++)
		{
			pw.print(rsmd.getColumnName(i));
		}
		pw.println("</tr>");*/
		
		while(rs.next())
		{
			   String username  = rs.getString(1);
			   String password  = rs.getString(2);
			   int  age  = rs.getInt(3);
			   String email  = rs.getString(4);
			   String gender  = rs.getString(5);
			   String address = rs.getString(6);
			   String skills  = rs.getString(7);
			   String education = rs.getString(8);
			   Blob resume = rs.getBlob(9);
	            //Display values
	            pw.println("USERNAME: " +username + "<br>");
	            pw.println(", PASSWORD: " + password + "<br>");
	            pw.println(", AGE: " + age + "<br>");
	            pw.println(", EMAIL: " + email+ "<br>");
	            pw.println(", GENDER: " + gender + "<br>");
	            pw.println(", ADDRESS: " + address + "<br>");
	            pw.println(", SKILLS: " + skills+ "<br>");
	            pw.println(", EDUCATION: " + education+ "<br>");
	            pw.println(", RESUME: " + resume + "<br>");
		//pw.println("<tr><td>"+rs.getString(1)+"</td><td> "+rs.getString(2) + " </td><td>" + rs.getInt(3) +"</td><td> "+rs.getString(4)+"</td><td> "+rs.getString(5) + "</td><td> " + rs.getString(6)+ "</td><td> "+rs.getString(7)+ "</td><td> "+rs.getString(8)+"</td><td> "+rs.getString(9)+"</td></tr>");
		}
		pw.print("</table>");
		}
		catch (Exception e)
		{
		pw.println(e);
		}
		
	}

}
