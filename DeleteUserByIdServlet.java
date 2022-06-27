package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/deleteuserbyid")
public class DeleteUserByIdServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
     int id=Integer.parseInt(request.getQueryString());
      
      try
      {
    	  Connection con = DBConnection.getConnection();
    	  
    PreparedStatement pstmt = con.prepareStatement("delete from userregistration where id=?");
    	 pstmt.setInt(1,id); 
    	
    	 int n = pstmt.executeUpdate();
    	 
    	 if(n>0)
    	 {
    		response.sendRedirect("deleteusers");
    	 }
    	 else
    	 {
    		 out.println("Fail to Delete");
    	 }
    	 pstmt.close();
    	 con.close();
    
      }
      catch(Exception e)
      {
    	  out.println(e);
      }
      
  }
}