package service.message;

import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONException;
import tools.MessageTools;
import tools.UserTools;

public class Search {
	
	

	public static JSONArray search(String key, String query, String tableau_user) throws JSONException, UnknownHostException{

		try {

			if(tableau_user==null && query==null&&key==null) {
				return MessageTools.getAllMessage();
			}
			
			if(tableau_user==null && query==null){
				return MessageTools.getMessageFriend(UserTools.getIDUserByKey(key));
			}
			
			if(tableau_user!=null){
				int[] users= new int[tableau_user.length()];
				for(int i=0;i<tableau_user.length();i++){
					users[i]=Integer.parseInt(tableau_user.charAt(i)+"");
				}
				
				return MessageTools.getMessageByUsers(users);
			}
			

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return MessageTools.getAllMessage();

	}
	
}
