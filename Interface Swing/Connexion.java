package interface_jee;

import java.sql.*;

public class Connexion {

	Connection c;
	
	public Connexion()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdd_jee","root","");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean connect(String name, String pwd) throws SQLException{
		
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("SELECT pseudo, motdepasse FROM utilisateur WHERE pseudo = '"+name+"' AND motdepasse ='"+pwd+"';");
		String result ="";
		String result2 ="";
		while(rs.next()){
			result = rs.getString("pseudo");
			result2 = rs.getString("motdepasse");
		}
		if(result.equals(name) && result2.equals(pwd)){
			rs.close();
			st.close();
			return true;
		}
		else {
			rs.close();
			st.close();
			return false;
		}
	}
	
	public boolean register(String name, String pwd) throws SQLException{
		Statement st = c.createStatement();
		
		int rs = st.executeUpdate("INSERT INTO utilisateur VALUES ('"+name+"','"+pwd+"')");
		st.close();
		
		return true;
	}
	
	public static void main(String[] args) throws SQLException{
		Connexion c = new Connexion();
		
		
	}
	
	
}