package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Logout(){}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String key=req.getParameter("key");
		
		try{
			JSONObject reponse=service.user.Logout.logout(key);
			
			PrintWriter out = res.getWriter();
			res.setContentType("text/plain");
			out.println(reponse.toString());
			
		}catch(Exception e){
			res.setContentType("text / plain " );
			PrintWriter out = res.getWriter();
			out.println("Exception Error \n");
		}
		
	}
	
}
