package service.message;

import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONException;
import tools.MessageTools;
import tools.UserTools;

public class Search {
	
	

	public static JSONArray search(String key, String query, String friends) throws JSONException, UnknownHostException{

		try {

			if(key==null){
				return MessageTools.getAllMessage();
			}
			
			if(friends==null){
				return MessageTools.getMessageByUser(UserTools.getIDUserByKey(key));
			}
			
			if(friends=="true"){
				return MessageTools.getMessageFriend(UserTools.getIDUserByKey(key));
			}
			

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return MessageTools.getAllMessage();

	}
	
}
