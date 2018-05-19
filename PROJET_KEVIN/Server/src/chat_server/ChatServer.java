/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Kévin
 */
public class ChatServer 
{
    private static final int PORT = 4444;
    private static ArrayList<String> users;
    private static ArrayList<Message> messages;
    private static ArrayList<PrintWriter> writers;
    
    public static void main(String[] args) throws Exception
    {
        users = new ArrayList<>();
        messages = new ArrayList<>();
        writers = new ArrayList<>();
        
        System.out.println("Serveur Lancé\n");
        
        ServerSocket listener = new ServerSocket(PORT);
        try
        {
            while(true)
            {
                new Handler(listener.accept()).start();
            }
        }finally
        {
            listener.close();
        }
    }
    
    private static class Handler extends Thread
    {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        
        public Handler(Socket _socket)
        {
            socket = _socket;
        }
        
        public void run()
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                while(true)
                {
                    out.println("GIVENAME");
                    name = in.readLine();
                    if(name == null) return;
                    synchronized(users)
                    {
                        if(!users.contains(name))
                        {
                            users.add(name);
                            break;
                        }
                    }
                }
                    
                out.println("CONNECTIONOK");
                writers.add(out);
                    
                while(true)
                {
                    String input = in.readLine();
                    if(input == null) return;
                    for(PrintWriter writer : writers) 
                    {
                        System.out.println("Test");
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            }catch(IOException e)
            {
                System.out.println(e);
            }finally
            {
                if(name != null) users.remove(name);
                if(out != null) writers.remove(out);
                try
                {
                    socket.close();
                }catch(IOException e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}