package tools;

import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MessageTools {

	public static void addMessage(int userId, String content) throws UnknownHostException{
		String date=new java.util.GregorianCalendar().getTime().toString();
		DBCollection message=Database.getMongoCollection("message");
		BasicDBObject dbo=new BasicDBObject();
		dbo.put("user_id",userId);
		dbo.put("content",content);
		dbo.put("date",date);
		message.insert(dbo);
	}
	
	
	public static JSONArray getMessageByUser(String userId) throws UnknownHostException, JSONException{
	
		DBCollection message=Database.getMongoCollection("message");
		BasicDBObject query=new BasicDBObject("user_id",userId);
		DBCursor msg=message.find(query);
		JSONArray userMessage=new JSONArray();
		while(msg.hasNext()){
			JSONObject json=new JSONObject();
			DBObject document=msg.next();
			json.put("content", document.get("content"));
			json.put("id", document.get("id"));
			userMessage.put(json);
		}
		return userMessage;
	}
	
	
	public static JSONArray getMessageByUsers(int [] userId) throws JSONException, UnknownHostException{
		DBCollection message=Database.getMongoCollection("message");
		BasicDBObject query=new BasicDBObject();
		query.put("user_id",new BasicDBObject("$in",userId));
		DBCursor msg=message.find(query);
		JSONArray userMessage=new JSONArray();
		while(msg.hasNext()){
			JSONObject json=new JSONObject();
			DBObject document=msg.next();
			json.put("content", document.get("content"));
			json.put("id", document.get("id"));
			userMessage.put(json);
		}
		return userMessage;
		
	}
	
	
}
