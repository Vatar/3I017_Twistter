package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FriendTools {
	
	public static boolean addFriend(int id_user, int id_friend){
		try{
			Connection c=tools.ConnectionTools.getMySQLConnection();
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
		try{
			Connection c=tools.ConnectionTools.getMySQLConnection();
			Statement st=c.createStatement();
			String query="DELETE FROM friend WHERE id_user=\""+id_user+"\" AND \""+id_friend+"\" ";
			int res=st.executeUpdate(query);
		
			if(res>0){
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return false;
	
	}

	public static int[] getFriends(int userId) {
		ArrayList<Integer> friendlist=new ArrayList<Integer>();
		
		try {
			Connection c=tools.ConnectionTools.getMySQLConnection();
			Statement st=c.createStatement();
			String query="SELECT id_friend FROM friend WHERE id_user= \""+userId+"\" ";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				friendlist.add(rs.getInt("id_friend"));
			}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		int[] friendarray=new int[friendlist.size()];
		
		for(int i=0;i<friendlist.size();i++){
			friendarray[i]=friendlist.get(i);
		}
		
		return friendarray;
	}
	

}
