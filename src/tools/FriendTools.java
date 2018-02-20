package tools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendTools {
	
	public static boolean addFriend(int id_user, int id_friend){
		try(Connection c=tools.ConnectionTools.getMySQLConnection();){
			Statement st=c.createStatement();
			String query="INSERT INTO friend(id_user,id_friend) VALUES( \""+id_user+"\",\""+id_friend+"\" )";
			int res=st.executeUpdate(query);
		
			if(res>0){
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean removeFriend(int id_user, int id_friend) {
		try(Connection c=tools.ConnectionTools.getMySQLConnection();){
			Statement st=c.createStatement();
			String query="DELETE FROM friend WHERE id_user=\""+id_user+"\" AND \""+id_friend+"\" )";
			int res=st.executeUpdate(query);
		
			if(res>0){
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return false;
	
	}
	

}
