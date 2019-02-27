package tools;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class MessageTools {

	public static void addMessage(int userId, String content) throws UnknownHostException{
		String date=new java.util.GregorianCalendar().getTime().toString();
		MongoCollection<Document> message=Database.getMongoCollection("message");
		Document query = new Document();
		query.append("user_id", userId);
		query.append("content",content);
		query.append("date", date);
		message.insertOne(query);
	}
	
	
	public static JSONArray getMessageByUser(int userId) throws UnknownHostException, JSONException{
	
		MongoCollection<Document> message=Database.getMongoCollection("message");
		Document query=new Document("user_id",userId);
		MongoCursor<Document> msg=message.find(query).iterator();
		JSONArray userMessage=new JSONArray();
		while(msg.hasNext()){
			JSONObject json=new JSONObject();
			Document document=msg.next();
			json.put("content", document.get("content"));
			json.put("id", document.get("id"));
			userMessage.put(json);
		}
		return userMessage;
	}
	
	
	public static JSONArray getMessageByUsers(int [] userId) throws JSONException, UnknownHostException{
		MongoCollection<Document> collection=Database.getMongoCollection("message");
		Document query=new Document(); 
		
		ArrayList<Integer> array=new ArrayList<Integer>();
		
		for(int i =0;i<userId.length;i++){
			array.add(userId[i]);
		}
		
		if(array.size()==0) {return new JSONArray();}
		query.append("user_id",new Document("$in",array));
		
	
		
		FindIterable<Document> col= collection.find(query);
		
		if(col==null) {return new JSONArray();}
		
		MongoCursor<Document> msg= col.iterator();
		JSONArray userMessage=new JSONArray();
		while(msg.hasNext()){
			JSONObject json=new JSONObject();
			Document document=msg.next();
			json.put("content", document.get("content"));
			json.put("id", document.get("id"));
			userMessage.put(json);
		}
		return userMessage;
		
	}
	
	
	public static JSONArray getMessageFriend(int userId) throws UnknownHostException, JSONException{
		int [] friendsid = FriendTools.getFriends(userId);
		if(friendsid.length==0) {
			return new JSONArray();
		}
		return getMessageByUsers(friendsid);
		
	}


	public static JSONArray getAllMessage() throws UnknownHostException, JSONException {
		MongoCollection<Document> message=Database.getMongoCollection("message");
		MongoCursor<Document> msg=message.find().iterator();
		JSONArray userMessage=new JSONArray();
		while(msg.hasNext()){
			JSONObject json=new JSONObject();
			Document document=msg.next();
			json.put("content", document.get("content"));
			json.put("id", document.get("id"));
			userMessage.put(json);
		}
		return userMessage;
	}
	
}
