package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;


public class UserTools {

	public static boolean userExists(String login){
		try(Connection c=tools.ConnectionTools.getMySQLConnection();){
			Statement st=c.createStatement();
			String query="SELECT * FROM user WHERE login = \"" +login+ "\"";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean createUser(String login,String password,String nom,String prenom){
		
		try(Connection c = tools.ConnectionTools.getMySQLConnection()){
			if(login==null || password==null || nom==null || prenom==null){
				return false;
			}
			Statement st=c.createStatement();
			String query="INSERT INTO user(login,pwd,nom,prenom) VALUES(\""+login+"\",HASHBYTES(\"SHA2_512\",\""+password+"\"),\""+nom+"\",\""+prenom+"\") ";
			int colnet=st.executeUpdate(query); 
			
			if(colnet>0){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean checkPwd(String login, String password){
		try(Connection c = tools.ConnectionTools.getMySQLConnection()) {
			Statement st=c.createStatement();
			String query="SELECT * FROM user WHERE login=\""+login +"\" AND pwd=HASHBYTES(\"SHA2_512\",\""+password+"\") ";
			if(st.executeQuery(query).next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getIDUser(String login){
		try(Connection c = tools.ConnectionTools.getMySQLConnection()) {
			Statement st=c.createStatement();
			String query="SELECT id FROM user WHERE login=\""+login +"\"  ";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static int getIDUserByKey(String key){
		try(Connection c = tools.ConnectionTools.getMySQLConnection()) {
			Statement st=c.createStatement();
			String query="SELECT id_user FROM session WHERE skey=\""+key +"\"  ";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
				return rs.getInt("id_user");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public static String insertSession(int id_user,boolean root){
		String newkey=null;
		if(root=false){
			newkey=UUID.randomUUID().toString();
		}
		try(Connection c = tools.ConnectionTools.getMySQLConnection()) {
			Statement st=c.createStatement();
			String query="INSERT INTO session(skey,id_user,sdate,root) VALUES( \""+newkey+"\",\""+id_user+"\",NOW(),\""+root+"\")";
			int rs=st.executeUpdate(query);
			if(rs>0){
				return newkey;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newkey;
	}
	
	public static boolean isConnected(String key){
		try(Connection c=tools.ConnectionTools.getMySQLConnection();){
			Statement st=c.createStatement();
			String query="SELECT * FROM session WHERE skey = \"" +key+ "\"";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}

	public static boolean removeConnection(String key) {
		try(Connection c = tools.ConnectionTools.getMySQLConnection()) {
			Statement st=c.createStatement();
			String query="DELETE FROM session WHERE skey=\""+key+"\"";
			int rs=st.executeUpdate(query);
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
}
