package crudoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import demo.DBConnection;

@WebServlet("/checkuser")
public class CheckUserServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
     
      String uname=request.getParameter("uname");
      String pwd=request.getParameter("pwd");
      
      try
      {
    	  Connection con = DBConnection.getConnection();
    	
    	  PreparedStatement pstmt = con.prepareStatement("select * from userregistration where username=? and password=?");
    	  
    	  pstmt.setString(1, uname);
    	  pstmt.setString(2, pwd);
    	  
          ResultSet rs = pstmt.executeQuery();
          if(rs.next())
          {
        	 HttpSession session = request.getSession();
        	 session.setAttribute("username", uname);
        	 response.sendRedirect("userhome");
          }
          else
          {
        	  response.sendRedirect("userlogin.html");
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