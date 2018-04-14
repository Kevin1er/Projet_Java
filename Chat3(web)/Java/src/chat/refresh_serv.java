package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class refresh_serv
 */
@WebServlet("/refresh_serv")
public class refresh_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refresh_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/xml");
		
	     PrintWriter writer = response.getWriter();
	     
//	     Date date=new Date();
//	     String date1=date.toString();
//		
//	     writer.println(date1);
//	     
//	      writer.close(); 

	     Connexion cnx=new Connexion();
	     ResultSet rs=null;
	     //recupere les msg
	     try {
			 rs=cnx.affichagemessage();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     if (rs!=null)
	     {
	     	try {
				while (rs.next())
				{
					
					String txt=rs.getString("msg");
					String username=rs.getString("username");
					String date=rs.getString("date");
					
					writer.println("<p><span>"+date+"|"+username+":</span>"+txt+"</p>");
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ici erreur");
			}
	     }
	     
	     try {
	    	
	    	
			cnx.closeall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
