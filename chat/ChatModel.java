/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.ArrayList;

/**
 * Classe Model
 * @author Kévin
 */
public class ChatModel
{
    private ArrayList<Message> messages;
    
    /**
     * Constructeur
     */
    public ChatModel()
    {
        messages = new ArrayList<>();
    }
    
    /**
     * Getter d'un message
     * @param _index
     * @return Message
     */
    public Message getMessage(int _index)
    {
        return messages.get(_index);
    }
    
    /**
     * Return message array size
     * @return int
     */
    public int sizeMessage()
    {
        return messages.size()-1;
    }
    
    /**
     * Add Message
     * @param _message
     */
    public void addMessage(String _message)
    {
        Message result;
        String parts[] = _message.split(":");
        result = new Message(parts[1],parts[0]);
        
        messages.add(result);
    }
}
