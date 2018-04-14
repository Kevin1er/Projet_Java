package chat;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class message_serv
 */
@WebServlet("/message_serv")
public class message_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public message_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	String idproject="AA1";
	String username="Oussema";
	String msgc=request.getParameter("message");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
//	INSERT INTO `messages` (`idproject`, `username`, `msg`, `date`) VALUES ('AA1', 'solofo', 'Bonsoir, les gars', '2018-04-20 03:09:08');
	
	System.out.print("ICIIIIIIIIIIIIIIIIIIIIIIIIIII:");
	System.out.println(msgc);
	String date1=dateFormat.format(date);
	//Date date1 = formatter.parse(date);
	
	Connexion cnx=new Connexion();
	Message msg=new Message();
	msg.setIdproject(idproject);
	msg.setUsername(username);
	msg.setDate(date1);
	msg.setMsg(msgc);
	
	//Ajout message
	try {
		
		cnx.ajoutmessage(msg);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		cnx.closeall();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

}
