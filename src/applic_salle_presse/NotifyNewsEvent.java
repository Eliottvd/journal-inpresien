package applic_salle_presse;

/**
 *
 * @author Admin
 */
public class NotifyNewsEvent {
    
    private String _messageRecu;
    public void setMessageRecu(String msg){ _messageRecu=msg;}
    public String getMessageRecu(){return _messageRecu;}
    
    public NotifyNewsEvent()
    {
        _messageRecu=new String();
    }
    
}
