package projet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class connexion_serv
 */
@WebServlet("/connexion_serv")
public class connexion_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexion_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   
		    String username = request.getParameter("form-username");
		   String password = request.getParameter("form-password");
		   
		  // System.out.println("email"+email);
		 //  System.out.println("usr"+username);
		   
		    
		  Inscription insc=new Inscription();
		 
		
		  User usr=new User();

		  usr.setUsername(username);
		  usr.setUsername(password);
		 
		  try {
			if ((insc.existe(usr)))
			  {
		
				if (insc.passvalid(usr))
				{
					
				
				
			HttpSession session = request.getSession();
			session.setAttribute( "username",username);
			request.getRequestDispatcher("TextEditor.jsp").forward(request, response);
			
				}
			  }
		
			else
			{
				request.setAttribute("existe", "non");
			
				request.getRequestDispatcher("inscription.jsp").forward(request, response);
				
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
