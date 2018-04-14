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
			ResultSet rs = st.executeQuery("select pseudo, motdepasse from utilisateur where pseudo = '"+name+"' and motdepasse ='"+pwd+"';");
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
	
	public static void main(String[] args) throws SQLException{
		Connexion c = new Connexion();
		
		System.out.println(c.connect("dan", "rob"));
	}
	
	
}