package demo;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletOne extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      ServletConfig sconfig=getServletConfig();
      ServletContext scontext =getServletContext();
      
      out.println(sconfig.getInitParameter("uname"));
      out.println(sconfig.getInitParameter("pwd"));
      
      out.println(scontext.getInitParameter("id"));
      out.println(scontext.getInitParameter("name"));
      
      
  }
}