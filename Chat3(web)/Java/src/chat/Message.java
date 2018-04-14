package chat;

import java.util.Date;

public class Message {

	String idproject;
	String username;
	String msg;
	String date;
	
	public Message()
	{
		
	}

	public String getIdproject() {
		return idproject;
	}

	public void setIdproject(String idproject) {
		this.idproject = idproject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
