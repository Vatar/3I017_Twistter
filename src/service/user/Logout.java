package service.user;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class Logout {

	public Logout(){}
	
	
public static JSONObject logout(String key) throws JSONException{
		
		
		if(key==null){
			return ErrorJSON.serviceRefused("Null parameters", 100);
		}
		
		try{
			if(!tools.UserTools.isConnected(key)){
				return ErrorJSON.serviceRefused("User is not connected", 101);
			}
			
			if(!tools.UserTools.removeConnection(key)){
				return ErrorJSON.serviceRefused("Logout Problem", 1000);
			}
		
		}
		catch(Exception e){
			return ErrorJSON.serviceRefused("Unknown Problem", 10000);
		}
		JSONObject json=ErrorJSON.serviceAccepted();
		return json;
	}
	
}
