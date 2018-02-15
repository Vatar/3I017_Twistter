package service.user;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;
import tools.UserTools;

public class Login {

public Login(){super();}
	
	public static JSONObject login(String login,String pwd) throws JSONException{
		
		
		if(pwd==null || login==null){
			return ErrorJSON.serviceRefused("Null parameters", 100);
		}
	
		try{
		
			if(!tools.UserTools.userExists(login)){
				return ErrorJSON.serviceRefused("Unknown user ", 1);
			}
			
			if(!tools.UserTools.checkPwd(login,pwd)){
				return ErrorJSON.serviceRefused("Wrong credentials ",2);
			}
			
			int id_user=UserTools.getIDUser(login);
			
			if(id_user==-1){return ErrorJSON.serviceRefused("ID Problem", 3);};
			
			String key=UserTools.insertSession(id_user, false);
			
			JSONObject json=new JSONObject();
			json.put("login",login);
			json.put("pwd",pwd);
			json.put("key", key);
			return json;
		
		}
		
		catch(JSONException e){
			return(ErrorJSON.serviceRefused("JSON Problem" + e.getMessage() , 100));
		}
		catch(Exception e){
			return ErrorJSON.serviceRefused("Unknown Problem ", 10000);
		}
	}	
}
