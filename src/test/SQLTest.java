package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class SQLTest {

	public static void main(String[] args) {
		try {
			Connection c =tools.ConnectionTools.getMySQLConnection();
			
			
			
			Statement st=c.createStatement();

			
			
			
			
			String prequery="CREATE TABLE user(id INTEGER PRIMARY KEY AUTO_INCREMENT,"
					+ "login VARCHAR(255) UNIQUE,"
					+ "pwd BLOB,"
					+ "nom VARCHAR(255),"
					+ "prenom VARCHAR(255))";
			String query="CREATE TABLE session (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
					+ "skey VARCHAR(36) UNIQUE,"
					+ "id_user INTEGER,"
					+ "sdate TIMESTAMP,"
					+ "root boolean,"
					+ "CONSTRAINT user_constraint FOREIGN KEY (id_user) REFERENCES user(id))";

			String queryq="CREATE TABLE friend(id INTEGER PRIMARY KEY AUTO_INCREMENT, id_user INTEGER, id_friend INTEGER)";


			st.executeUpdate(queryq);
			st.executeUpdate(prequery);
			st.executeUpdate(query);
			
			try {
				
				// TEST CREATE USER
				service.user.CreateUser.createUser("xXxAlicexXx", "123456789", "A", "Alice");
				service.user.CreateUser.createUser("Boblepuissant", "motdepasse", "B", "Bob");
				service.user.CreateUser.createUser("GrandManitou", "11112011", "G", "M");
				
				
				// TEST LOGIN
				service.user.Login.login("xXxAlicexXx", "Bob");
				JSONObject jsonalice=service.user.Login.login("xXxAlicexXx", "123456789");
				service.user.Login.login("GrandManitou", "11112011");
				JSONObject json=service.user.Login.login("Boblepuissant", "motdepasse");
				service.user.Logout.logout(json.getString("key"));
				
				//
				
				//TEST FRIEND 
				
				service.friend.AddFriend.addFriend(json.getString("key"), 1); //Bob essaye d'ajouter Alice mais pas connecté
				
				JSONObject json2=service.user.Login.login("Boblepuissant","motdepasse"); //Bob se connecte
				
				service.friend.AddFriend.addFriend(json2.getString("key"),1); // Bob ré-essaye, ça marche
				
				//Resultat attendu: Bob & Alice ami
				
				//TEST ADDCOMMENT
				
				service.message.AddComment.addComment(json2.getString("key"), "Moi, Boblepuissant à maintenant " + (int)(Math.random()*10000) +"€ ;)").toString();
				service.message.AddComment.addComment(jsonalice.getString("key"), "Moi, xXxAlicexXx à couru " + (int)(Math.random()*10) +" km aujourd'hui :<").toString();

				//TEST SEARCH SES MESSAGES
				
				System.out.println(service.message.Search.search(null, null, null).toString());
				System.out.println("\n");
				System.out.println(service.message.Search.search(json2.getString("key"), null, null).toString());
				System.out.println("\n");
				System.out.println(service.message.Search.search(json2.getString("key"), "true", "1").toString());
				
				//Resultat attendu: tout message - message des amis de bob donc messages de alice - messages de alice
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			Scanner scanner = new Scanner(System.in);
			try {
				System.out.println("Please input a key to delete the tables");
				String line = scanner.nextLine();
			} catch(Exception e) {
				System.out.println("System.in was closed; exiting");
			}
			
			
			String delet="DROP TABLE session";

			st.executeUpdate(delet);
			delet="DROP TABLE user";
			st.executeUpdate(delet);
			delet="DROP TABLE friend";
			st.executeUpdate(delet);
			
		} catch (SQLException e) {
			e.printStackTrace();


		}



	}

}
