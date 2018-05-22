/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_clientlourd;

/**
 * Classe Message
 * @author Kévin
 */
class Message 
{
    private final String TEXTE;
    private final String AUTEUR;
    
    
    /*
    * Constructeur
    */
    public Message(String _texte, String _auteur)
    {
        TEXTE = _texte;
        AUTEUR = _auteur;
    }
    
    /*
    * toString
    */
    @Override
    public String toString()
    {
        return AUTEUR + " : " + TEXTE + "\n";
    }
}
