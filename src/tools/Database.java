package tools;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bd.DBStatic;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

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
	
	public static DBCollection getMongoCollection(String nom_collection) throws UnknownHostException{
		MongoClient m;
	
		m = new MongoClient(DBStatic.mongo_url);
		DB db=m.getDB(DBStatic.mongo_url);
		return db.getCollection(nom_collection);
	}
	
	
}
