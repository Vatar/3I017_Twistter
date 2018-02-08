package service.user;

import java.sql.SQLException;

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
			if(!bd.usertools.isConnected(key)){
				return ErrorJSON.serviceRefused("User is not connected", 101);
			}
			bd.usertools.removeConnection(key);
		
		}
		catch(SQLException e){
			return ErrorJSON.serviceRefused("SQL error", 1000);
		}
		JSONObject json=ErrorJSON.serviceAccepted();
		return json;
	}
	
}
