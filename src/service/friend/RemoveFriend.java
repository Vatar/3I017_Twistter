package service.friend;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class RemoveFriend {

public static JSONObject removeFriend(String key, int id_friend) throws JSONException{
		
		
		if(key==null || id_friend<0 ){
			return ErrorJSON.serviceRefused("null parameters", 100);
		}
		
		if(!tools.UserTools.isConnected(key)|| !tools.UserTools.isKeyValid(key) ){
			return ErrorJSON.serviceRefused("Requesting user isn't connected", 101);
		}
		
		int id_user=tools.UserTools.getIDUserByKey(key);
		
		if(id_user==-1){
			return ErrorJSON.serviceRefused("Non existing user_id", 1000);
		}
		
		
		if(tools.FriendTools.removeFriend(id_user, id_friend)){
			return ErrorJSON.serviceAccepted();
		}
		
		return ErrorJSON.serviceRefused("Adding Friend Error", 1001);
	}
	
}
