/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

/**
 *
 * @author Admin
 */
public class NotifyNewsEvent {
    
    private String _messageRecu;
    public void setMessageRecu(String m){ _messageRecu=m;}
    public String getMessageRecu(){return _messageRecu;}
    
    public NotifyNewsEvent()
    {
        _messageRecu=new String();
    }
    
}
