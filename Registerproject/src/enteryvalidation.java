

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/enteryvalidation")
public class enteryvalidation extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		if(u.equals("olabsys")&&p.equals("olabsys@123"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request,response);
		}
		
	}

}
