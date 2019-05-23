package applic_salle_presse;

/**
 *
 * @author Admin
 */
public class Event1News {
    
    public Event1News()
    {
        _messageNews=new String();
    }
    private String _messageNews;
    public void setMessageTraite(String m){_messageNews=m;}
    public String getMessageTraite(){return _messageNews;}
    
    private String _localite;
    public void setLocalite(String loc){_localite=new String();_localite=loc;}
    public String getLocalite(){return _localite;}
    
    private NotifyNewsListener _mainPrincipale;
    public void setMainPrincipale(NotifyNewsListener nnl){ _mainPrincipale=nnl;}
    public NotifyNewsListener getMainPrincipale(){ return _mainPrincipale;}    
}
