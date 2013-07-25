import java.sql.*;
public class logindb 
{
public static boolean validate(String u,String p)
{
	boolean status =false;
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		   Connection con =DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
			PreparedStatement ps=con.prepareStatement("select * from iyap where username=? and password=?");
			ps.setString(1,u);
			ps.setString(2,p);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
	}

	catch(Exception e){System.out.println(e);}
	return false;
	
	}
	
}
