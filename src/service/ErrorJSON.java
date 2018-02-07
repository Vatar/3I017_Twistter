package service;

import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {

	public ErrorJSON(){super();}
	
	public static JSONObject serviceRefused(String message, int codeErreur) throws JSONException{
		JSONObject response=new JSONObject();
		response.put(message, codeErreur);
		return response; 
	}
	
	public static JSONObject serviceAccepted() throws JSONException{
		JSONObject response=new JSONObject();
		response.put("status","OK");
		return response;
	}
	
}

