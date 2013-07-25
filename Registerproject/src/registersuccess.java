

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/registersuccess")
public class registersuccess extends HttpServlet {
	


	String skill="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String age=request.getParameter("age");
		 String email=request.getParameter("email");
		 String address=request.getParameter("address");
		 String gender=request.getParameter("gender");
		 String skills[]=request.getParameterValues("skills");
		 String education=request.getParameter("education");
		// String resume=request.getParameter("resume");
		// Part filePart = request.getPart("resume");
		 //InputStream inputStream = null;
		 //String message = null; 
	        //if (filePart != null) {
	            // prints out some information for debugging
	        ///    System.out.println(filePart.getName());
	           // System.out.println(filePart.getSize());
	           // System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	         //   inputStream = filePart.getInputStream();
	      //  }
try
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
	Statement stmt=con.createStatement();
	
	for(int i=0;i<skills.length;i++)
	{
		skill=skill+skills[i];
	}
	String sql="insert into iyap(username,password,age,email,gender,address,skills,education,resume)values(?,?,?,?,?,?,?,?,?)";
	File file = new File("/home/iyappan/Downloads/iyappan resume(latest)(1).doc");
	PreparedStatement statement = con.prepareStatement(sql);
	FileInputStream fis = new FileInputStream(file);
	statement.setBinaryStream(9,fis,fis.available());
	statement.setString(9, "Tim");
	  statement.setString(1, username);
      statement.setString(2,  password);
      statement.setString(3, age);
      statement.setString(4,  email);
      statement.setString(5,address);
      statement.setString(6,gender);
      statement.setString(7, skill);
      statement.setString(8, education);
       
     // if (inputStream != null) {
          // fetches input stream of the upload file for the blob column
          //statement.setBlob(9, inputStream);
     // }

      // sends the statement to the database server
      int row = statement.executeUpdate();
      if (row > 0)
      {
         // message = "File uploaded and saved into database";
      }
  } catch (SQLException | ClassNotFoundException ex) {
   //   message = "ERROR: " + ex.getMessage();
      ex.printStackTrace();
  }
	//stmt.execute(sql);
	//out.print("RegisteredSuccessfully");
	
}


/*catch(Exception e)
{  
    System.out.println("Exception is ;"+e);  
    }  


}*/
}
	
