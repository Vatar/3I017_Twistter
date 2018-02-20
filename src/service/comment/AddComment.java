package service.comment;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class AddComment {

public static JSONObject addComment(String key, String text) throws JSONException{
		
		
		if(key==null || text==null ){
			return ErrorJSON.serviceRefused("null parameters", 100);
		}
		
		if(!tools.UserTools.isConnected(key)){
			return ErrorJSON.serviceRefused("Requesting user isn't connected", 101);
		}
		
		
				
		if(tools.CommentTools.addComment(key, text)){
			return ErrorJSON.serviceAccepted();
		}
		
		return ErrorJSON.serviceRefused("Adding Friend Error", 1001);
	}
	
}
