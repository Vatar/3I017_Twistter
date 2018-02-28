package service.message;

import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

import service.ErrorJSON;
import tools.UserTools;

public class AddComment {


	public static JSONObject addComment(String key, String text) throws JSONException{

		try {

			if(key==null || text==null ){
				return ErrorJSON.serviceRefused("null parameters", 100);
			}

			if(!tools.UserTools.isConnected(key) || !tools.UserTools.isKeyValid(key) ){
				return ErrorJSON.serviceRefused("Requesting user isn't connected", 101);
			}

			int userid=UserTools.getIDUserByKey(key);
			
			tools.MessageTools.addMessage(userid, text);
			return ErrorJSON.serviceAccepted();

		} catch (NumberFormatException e) {

			return ErrorJSON.serviceRefused("Bad key format", 102);

		} catch (UnknownHostException e) {

			return ErrorJSON.serviceRefused("Host error", 1000);

		}

	}

}
