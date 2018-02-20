package servlet.friend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class RemoveFriend {

	public RemoveFriend(){}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String key=req.getParameter("key");
		String id_friend=req.getParameter("id_friend");
		
		try{
			JSONObject reponse=service.friend.RemoveFriend.removeFriend(key, Integer.parseInt(id_friend));
			
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
