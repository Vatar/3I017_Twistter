package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
 
/** 
 * Servlet implementation class CreateUser
 */
public class CreateUser extends HttpServlet {
 
 /**
 * Default constructor.
 */
 public CreateUser() {
 }
 
 /*
 * This method will handle all GET request.
 */
 protected void doGet(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {
	 
	try{

		String login=request.getParameter("login");
		String pwd=request.getParameter("pwd");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		
		JSONObject json=service.user.CreateUser.createUser(login, pwd, nom, prenom);
		
		
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		out.println(json.toString());
		}
		catch(Exception e){
			response.setContentType( " text / plain " );
			PrintWriter out = response.getWriter ();
			out.println("Exception Error \n");
		}
	
 }
 

}