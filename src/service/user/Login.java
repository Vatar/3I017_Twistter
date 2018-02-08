package service.user;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class Login {

public Login(){super();}
	
	public static JSONObject login(String login,String pwd) throws JSONException{
		
		
		if(pwd==null || login==null || !login.matches("^[a-zA-Z]+$") ){
			return ErrorJSON.serviceRefused("Null parameters", 100);
		}
	
		try{
		
			if(!userExists(login)){
				return ErrorJSON.serviceRefused("User id doesn't exist", 101);
			}
			
			if(!checkPwd(login,pwd)){
				return ErrorJSON.serviceRefused("Wrong credentials", 102);
			}
			
			String key=logUser(login,pwd);
		
		}
		catch(SQLException e){
			
			return ErrorJSON.serviceRefused("SQL error", 1000);
		}
		JSONObject json=ErrorJSON.serviceAccepted();
		json.put(key, key);
		return json;
	}
	
}
