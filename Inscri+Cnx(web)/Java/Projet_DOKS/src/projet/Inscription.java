package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Inscription {

public static Statement st ;
	
	public Inscription() {

		try {
			//charger pilotes
			Class.forName("com.mysql.jdbc.Driver");
			//connexion a la bd
			Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/Projet_DOKS"
			,"root","");
			//creation statement de la cnx
			 st=cnx.createStatement();
		

			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		
			
	}
	}
	
	
	
	public boolean existe(User usr) throws SQLException
	{
		boolean bol = false;
	String username=usr.getUsername();
		
		String Query="Select username from Users Where username='"+username+"';";
    	
    	//System.out.println("--------------------" +Query);
		ResultSet res=st.executeQuery(Query);
		//System.out.println(res.getInt(0));
		 while(res.next()) {
			
        if(!res.wasNull()) 
        { 
       bol=true;
        }
   

		 }
		
	return bol;
	}
	
	
	public boolean passvalid(User usr) throws SQLException
	{
		boolean bol=true;
		
	String username=usr.getUsername();
	String password=usr.getPassword();
		
		String Query="Select username from Users Where username='"+username+"' AND password='"+password+"';";
    	
    	
		ResultSet res=st.executeQuery(Query);
		
		 while(res.next()) {
			
        if(!res.wasNull()) 
        { 
       bol=false;
        }
   

		 }
		
		
		
		return bol;
	}
	
	public  void ajoutuser(User usr)
	{

	String name=usr.getName();
	String lname=usr.getLname();
	String username=usr.getUsername();
	String password=usr.getPassword();
	String email=usr.getEmail();
	
			    
			  
			    
// on va tester si personne existe : 
			    try {
//			    	String Query="Select username from Users Where username='"+username+"';";
//			    	
//			    	//System.out.println("--------------------" +Query);
//					ResultSet res=st.executeQuery(Query);
//					//System.out.println(res.getInt(0));
//					 while(res.next()) {
//						
//			        if(!res.wasNull()) 
//			        { 
//			        //	System.out.println("Erreur! cette personne existe deja !!");
//			        	
//			        	System.exit(0);
//			        }
//			   
//			        
//			        	
//			        	
//			        	
//			        
//					 }
					//on ajoute a la base si il existe pas id 
			        	String Query2="insert into Users VALUES";
			        	Query2=Query2+"('"+name+"','"+lname+"','"+username+"','"+password+"','"+email+"');" ;
			     //  System.out.println(Query2);
			        
			        	boolean res2=st.execute(Query2);
					
					 
					 
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.print("ici");
				}
			    
	}
	
	
	

	

}
