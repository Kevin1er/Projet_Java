/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_clientlourd;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Classe Controller
 * @author Kévin
 */
public class ChatController implements Runnable
{
    private final ChatModel model;
    private final ChatView view;
    private BufferedReader in;
    private PrintWriter out;
    
    public ChatController(ChatModel _model, ChatView _view)
    {
        model = _model;
        view = _view;
        initController();
    }
    
    private void initController()
    {
        view.getBtnSend().addActionListener((ActionEvent e) -> {
            sendMessage(view.getMessageField().getText());
        });
        
        view.getMessageField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

             public void changed() {
                if (view.getMessageField().getText().equals("")){
                    view.getBtnSend().setEnabled(false);
                }
                else {
                    view.getBtnSend().setEnabled(true);
                }
            }
        });
    }
    
    public void sendMessage(String _message)
    {
        out.println(_message);
    }
    
    private String getName() {
        return JOptionPane.showInputDialog(
            view,
            "Choose a screen name:",
            "Screen name selection",
            JOptionPane.PLAIN_MESSAGE);
    }

    public void run()
    {
        try {
            String serverAdress = "127.0.0.1";
            Socket socket = new Socket(serverAdress, 4444);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("test");
            int i = 0;
            
            while(i < 10) 
            {
                System.out.println("test");
                String line = in.readLine();
                System.out.println(line.length());
                if(line.startsWith("GIVENAME")) out.println(getName());
                else if(line.startsWith("CONNECTIONOK")) view.getMessageField().setEditable(true);
                else if(line.startsWith("MESSAGE"))
                {
                    model.addMessage(line.substring(8));
                    view.update();
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}