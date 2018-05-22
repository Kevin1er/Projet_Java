package z_clientlourd;

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
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projet_doks","root","");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean connect(String name, String pwd) throws SQLException{
		
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("SELECT username, password FROM users WHERE username = '"+name+"' AND password ='"+pwd+"';");
		String result ="";
		String result2 ="";
		while(rs.next()){
			result = rs.getString("username");
			result2 = rs.getString("password");
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
	
	public boolean register(String _nom, String _prenom, String _username, String _password, String _email) throws SQLException
        {
		Statement statement = c.createStatement();
		
		int rs = statement.executeUpdate("INSERT INTO users VALUES ('"+_nom+"','"+_prenom+"','"+_username+"','"+_password+"','"+_email+"')");
		statement.close();
		
		return true;
	}
	
	public static void main(String[] args) throws SQLException{
		Connexion c = new Connexion();
		
		
	}
	
	
}