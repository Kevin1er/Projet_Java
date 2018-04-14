package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class Connexion {

public static	Connection cnx;
public static Statement st ;

public Connexion() {
	try {
		//charger pilotes
		Class.forName("com.mysql.jdbc.Driver");
		//connexion a la bd
		cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/Chat_jee"
		,"root","");
		//creation statement de la cnx
		 st=cnx.createStatement();
	

		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	
		
}
}

	public  void ajoutmessage(Message msg) throws SQLException
	{
		String idproject=msg.getIdproject();
		String username=msg.getUsername();
		String msgc=msg.getMsg();
		String date=msg.getDate();
		
		String Query="insert into Messages VALUES";
    	Query=Query+"('"+idproject+"','"+username+"','"+msgc+"','"+date+"');" ;
 //  System.out.println(Query2);
    
    	boolean res=st.execute(Query);
    	
	}
	
	public ResultSet affichagemessage() throws SQLException
	{ 	
	String Query="select * from Messages where idproject='AA1' ORDER BY date ASC";
	 ResultSet rs = st.executeQuery(Query);
	 //System.out.println(rs);
	return rs;
	}

	public void closeall() throws SQLException
	{
		Connexion.st.close();
		Connexion.cnx.close();
	
	}
	
}
