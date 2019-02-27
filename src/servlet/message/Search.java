package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

public class Search extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1426480125961698720L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		String key=req.getParameter("key");
		String query=req.getParameter("query");
		String tableau_user=req.getParameter("tableau_user");
		
		
		
		/*if(key==null || !tools.UserTools.isConnected(key) || !tools.UserTools.isKeyValid(key) ){
			res.setContentType("text / plain " );
			PrintWriter out = res.getWriter();
			out.println("Exception Error \n");
		}*/
		
		JSONArray reponse;
		try {
			reponse = service.message.Search.search(key, query, tableau_user);
			PrintWriter out = res.getWriter();
			res.setContentType("text/plain");
			out.println(reponse.toString());
		} catch (JSONException e) {
			PrintWriter out = res.getWriter();
			res.setContentType("text/plain");
			out.println("Exception Error \n");
		}
		

	}
	
	
}
