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
public class Event1News {
    
    private String _messageNews;
    public void setMessageTraite(String m){_messageNews=m;}
    public String getMessageTraite(){return _messageNews;}
    
    private String _localite;
    public void setLocalite(String m){_localite=new String();_localite=m;}
    public String getLocalite(){return _localite;}
    
    private NotifyNewsListener _mainPrincipale;
    public void setMainPrincipale(NotifyNewsListener n){ _mainPrincipale=n;}
    public NotifyNewsListener getMainPrincipale(){ return _mainPrincipale;}
    
    public Event1News()
    {
        _messageNews=new String();
    }
    
    
    
}
