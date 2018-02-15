package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTest {

	public static void main(String[] args) {
		try {
			Connection c =tools.ConnectionTools.getMySQLConnection();
			Statement st=c.createStatement();
			
			String prequery="CREATE TABLE user(id INTEGER PRIMARY KEY AUTO_INCREMENT,"
					+ "login VARCHAR(255) UNIQUE,"
					+ "pwd BINARY(64),"
					+ "nom VARCHAR(255),"
					+ "prenom VARCHAR(255))";
		/*	String query="CREATE TABLE Session (id INTEGER PRIMARY KEY AUTO_INCREMENT,"
					+ "skey VARCHAR(32) UNIQUE,"
					+ "id_user INTEGER,"
					+ "sdate TIMESTAMP,"
					+ "root boolean,"
					+ "CONSTRAINT user_constraint FOREIGN KEY (id_user) REFERENCES user(id))";
			*/
			String query2="INSERT INTO user (login,pwd,nom,prenom) VALUES(\"Alice\",\"BOB\",\"Aliot\",\"Alice\" )";
			String query3="INSERT INTO user (login,pwd,nom,prenom) VALUES(\"Bob\",\"ALICE\",\"Bliot\",\"Bob\" )";

			st.executeUpdate(prequery);
			//st.executeUpdate(query);
			st.executeUpdate(query2);
			st.executeUpdate(query3);
			/*String delet="DROP TABLE ?";
			st.executeUpdate(delet);
			*/
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		
	}

}
