package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class AddComment extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2318817593734125082L;

	public AddComment(){}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String key=req.getParameter("key");
		String text=req.getParameter("text");
		
		try{
			JSONObject reponse=service.message.AddComment.addComment(key, text);
			
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
