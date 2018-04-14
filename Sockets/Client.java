package sockets;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


/*
 * Classe client pour transfert de fichiers via Sockets
 */
public class Client 
{
	public final static String SERVER = "127.0.0.1";  										// Adresse du serveur (ICI LocalHost)
	public final static int PORT = 4444;      												// Port de reception
	public final static String FILE = "C:/Users/VOCAN/Desktop/TestSocket/doks_copie.txt";  	// Nom du fichier que l'on va recevoir
	public final static int FILE_SIZE = 8192; 												// Taille max du fichier que l'on peut recevoir
	
	/*
	 * Fonction Main
	 */
	public static void main (String [] args ) throws IOException 
	{
		int bytesRead;
		int current = 0;
		FileOutputStream fileOut = null;
		BufferedOutputStream bufferOut = null;
		Socket socket = null;
		
		try 
		{
			socket = new Socket(SERVER, PORT);
			byte [] fileByte  = new byte [FILE_SIZE];
			InputStream in = socket.getInputStream();
			fileOut = new FileOutputStream(FILE);
			bufferOut = new BufferedOutputStream(fileOut);
			bytesRead = in.read(fileByte,0,fileByte.length);
			current = bytesRead;
			
			// Lecture
			do 
			{
				bytesRead = in.read(fileByte, current, (fileByte.length-current));
				if(bytesRead >= 0) current += bytesRead;
			} while (bytesRead > -1);
			
			// Ecriture du fichier
			bufferOut.write(fileByte, 0 , current);
			bufferOut.flush();
		
		}finally 
		{
			if (fileOut != null) fileOut.close();
			if (bufferOut != null) bufferOut.close();
			if (socket != null) socket.close();
		}
	}
}