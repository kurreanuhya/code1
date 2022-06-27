package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import demo.DBConnection;

@WebServlet("/deleteusers")
public class DeleteUsersServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      //out.println("I am in delete users servlet");
      try
      {
    	  Connection con = DBConnection.getConnection();
    	  ResultSet rs = con.createStatement().executeQuery("select * from userregistration ");
    	  
    	  
    	  out.println("<h3>Deleting User</h3>");
    	  out.println("<table align=center border=1>");
    	  out.println("<tr>");
    	  out.println("<th>ID</th>");
    	  out.println("<th>Full Name</th>");
    	  out.println("<th>Gender</th>");
    	  out.println("<th>DOB</th>");
    	  out.println("<th>Email</th>");
    	  out.println("<th>Username</th>");
    	  out.println("<th>Mobile No.</th>");
    	  out.println("<th>Location</th>");
    	  out.println("<th>Action</th>");
    	  
    	  out.println("</tr>");
    	 
    	  while(rs.next())
    	  {
    		  out.println("<tr>");
    		  out.println("<td>"+rs.getInt(1)+"</td>");
    		  out.println("<td>"+rs.getString(2)+"</td>");
    		  out.println("<td>"+rs.getString(3)+"</td>");
    		  out.println("<td>"+rs.getString(4)+"</td>");
    		  out.println("<td>"+rs.getString(5)+"</td>");
    		  out.println("<td>"+rs.getString(6)+"</td>");
    		  out.println("<td>"+rs.getString(8)+"</td>");
    		  out.println("<td>"+rs.getString(9)+"</td>");
    		  out.println("<td><a href=deleteuserbyid?"+rs.getInt(1)+">Delete</a></td>");
    		  
    		  out.println("</tr>");
    	  }
    	  out.println("</table>");
    	 
      }
      catch(Exception e )
      {
    	  out.println(e);
      }
  }
}