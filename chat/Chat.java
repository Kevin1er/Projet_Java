/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;

/**
 *
 * @author Kévin
 */
public class Chat 
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        ChatModel m = new ChatModel();
        ChatView v = new ChatView(m);
        ChatController c = new ChatController(m, v);
        v.show();
        c.run();
    }
    
}
