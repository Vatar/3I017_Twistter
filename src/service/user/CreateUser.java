package service.user;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;

public class CreateUser {

	public CreateUser(){super();}
	
	public static JSONObject createUser(String login,String pwd,String nom,String prenom) throws JSONException{
		
		
		if(prenom==null || nom==null || pwd==null || login==null || !login.matches("^[a-zA-Z]+$") ){
			return ErrorJSON.serviceRefused("null parameters", 100);
		}
		
		if(userExists(login)){
			return ErrorJSON.serviceRefused("User id already exists", 101);
		}
		
		addUser(login,pwd,nom,prenom);
		
		return ErrorJSON.serviceAccepted();
	}
	
}
