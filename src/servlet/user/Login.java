package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Login extends HttpServlet{

	public Login(){}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String login=req.getParameter("login");
		String pwd=req.getParameter("pwd");
		
		try{
			JSONObject reponse=service.user.Login.login(login, pwd);
			
			PrintWriter out = res.getWriter();
			res.setContentType("text/plain");
			out.println(reponse.toString());
			
		}catch(Exception e){
			res.setContentType( " text / plain " );
			PrintWriter out = res.getWriter();
			out.println("Exception Error \n");
		}
		
	}
	
}
 