package projet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class inscription_serv
 */
@WebServlet("/inscription_serv")
public class inscription_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public inscription_serv() {
        super();
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String name = request.getParameter("form-first-name");
		    String lname = request.getParameter("form-last-name");
		    String username = request.getParameter("form-username-insc");
		   String email = request.getParameter("form-email");
		   String password = request.getParameter("form-password");
		   
		  // System.out.println("email"+email);
		 //  System.out.println("usr"+username);
		   
		    
		  Inscription insc=new Inscription();
		 
		
		  User usr=new User();
		  usr.setName(name);
		  usr.setLname(lname);
		  usr.setEmail(email);
		  usr.setUsername(username);
		  usr.setPassword(password);
		 
		  try {
			if (!(insc.existe(usr)))
			  {
			insc.ajoutuser(usr);
			HttpSession session = request.getSession();
			session.setAttribute( "username",username);
			request.getRequestDispatcher("TextEditor.jsp").forward(request, response);
			
			  }
			else
			{
			//System.out.println("dsl exsite deja");
				request.setAttribute("existe", "oui");
				request.getRequestDispatcher("inscription.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
