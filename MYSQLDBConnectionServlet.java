package demo;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/dbconnection")
public class MYSQLDBConnectionServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      out.println("Servlet program for database connection");
      try
      {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        out.println("Driver class loaded");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/epjdbc?useSSL=false" ,"root", "Anuhy@2002");
        out.println("Connection established successfully");
        
      }
      catch (Exception e) {
    
        out.println(e);
  }
    }
    
  }