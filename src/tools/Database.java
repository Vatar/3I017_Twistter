package tools;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bd.DBStatic;



public class Database {

	private DataSource dataSource;
	
	public Database(String jndiname) throws SQLException{
		try{
			dataSource= (DataSource) new InitialContext().lookup("java:comp/env/"+jndiname);
			
		}catch(NamingException e){
			throw new SQLException(jndiname + " is missing in KNDI! :" + e.getMessage() );
		}
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static MongoCollection<Document> getMongoCollection(String nom_collection) throws UnknownHostException{

		com.mongodb.client.MongoClient mongo = MongoClients.create();
		MongoDatabase mDB= mongo.getDatabase(DBStatic.mongo_db);
		
		return mDB.getCollection(nom_collection);
	}

}
