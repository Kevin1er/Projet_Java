package sockets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * Classe serveur pour transfert de fichiers via Sockets
 */
public class Serveur 
{
	public final static int PORT = 4444;  												// Port de reception
	public final static String FILE = "C:/Users/VOCAN/Desktop/TestSocket/doks.txt";  	// Fichier que l'on va envoyer
	
	public static void main (String [] args ) throws IOException 
	{
		FileInputStream fileIn = null;
		BufferedInputStream bufferIn = null;
		OutputStream out = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try 
		{
			serverSocket = new ServerSocket(PORT);
			
			while (true) 
			{
				try 
				{
					socket = serverSocket.accept();
					
					// Envoie du fichier
					File file = new File (FILE);
					byte [] fileByte  = new byte [(int)file.length()];
					fileIn = new FileInputStream(file);
					bufferIn = new BufferedInputStream(fileIn);
					bufferIn.read(fileByte,0,fileByte.length);
					out = socket.getOutputStream();
					out.write(fileByte,0,fileByte.length);
					out.flush();
				}finally 
				{
					if (bufferIn != null) bufferIn.close();
					if (out != null) out.close();
					if (socket!=null) socket.close();
				}
			}
		}finally 
		{
			if (serverSocket != null) serverSocket.close();
		}
	}
}