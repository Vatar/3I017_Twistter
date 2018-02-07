package service.user;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class Login {

public Login(){super();}
	
	public static JSONObject login(String login,String pwd) throws JSONException{
		
		
		if(pwd==null || login==null || !login.matches("^[a-zA-Z]+$") ){
			return ErrorJSON.serviceRefused("Null parameters", 100);
		}
		
		if(!userExists(login)){
			return ErrorJSON.serviceRefused("User id doesn't exist", 101);
		}
		
		if(!checkPwd(login,pwd)){
			return ErrorJSON.serviceRefused("Wrong credentials", 102);
		}
		
		String key=logUser(login,pwd);
		
		JSONObject json=ErrorJSON.serviceAccepted();
		json.put(key, key);
		return json;
	}
	
}
