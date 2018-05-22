/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_server;

/**
 *
 * @author VOCAN
 */
class Message 
{
    private String texte, auteur;
    
    public Message(String _texte, String _auteur)
    {
        texte = _texte;
        auteur = _auteur;
    }
}
