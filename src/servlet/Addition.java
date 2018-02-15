package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/** 
 * Servlet implementation class Addition
 */
public class Addition extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

/**
 * Default constructor.
 */
 public Addition() {
 }
 
 /*
 * This method will handle all GET request.
 */
 protected void doGet(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {
	 
	try{
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String operation=request.getParameter("type");

		
		int c=0;
		String signe="";
	
		if (operation.equals("addition")){
			c=a+b;
			signe=" + ";
		}
		if (operation.equals("division")){
			c=a/b;
			signe=" / ";
		}
		if (operation.equals("multiplication")){
			c=a*b;
			signe=" * ";
		}
		
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		out.println( a + signe + b + " = " + c );
		}
		catch(Exception e){
			response.setContentType( " text / plain " );
			/*PrintWriter out = response.getWriter ();
			out.println("");*/
		}
	
 }
 

}