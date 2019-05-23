package applic_salle_presse;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ListeNewsBean implements NewsListener{
    
    private String _messageTraite;
    public void setMessageTraite(String m){ _messageTraite=m;}
    public String getMessageTraite(){return _messageTraite;}
    
    private String _messageRecu;
    public void setMessageRecu(String m){ _messageRecu=m;}
    public String getMessageRecu(){return _messageRecu;}

    private ArrayList<NotifyNewsListener> _notifNewsListener;
    public void setNotifNewsListener(ArrayList<NotifyNewsListener> m){ _notifNewsListener=(m);}
    public ArrayList<NotifyNewsListener> getNotifNewsListener(){return _notifNewsListener;}
    public void addNotifNewsListener(NotifyNewsListener k){ getNotifNewsListener().add(k); }
    
    public ListeNewsBean()
    {
        _messageTraite=new String();
        _messageRecu=new String();
       
       _notifNewsListener=new ArrayList<NotifyNewsListener>(); 
    }
     
     
    @Override
     public void newsDecteced(NewsEvent e)
     {         
        setMessageTraite(e.getMessageTraite() +"/" + e.getLocalite());
        NotifyNewsEvent notifyNewsEvent=new NotifyNewsEvent();
        notifyNewsEvent.setMessageRecu(getMessageTraite());
        addNotifNewsListener(e.getMainPrincipale());

        for(int i=0;i<getNotifNewsListener().size();i++)
        {
            getNotifNewsListener().get(i).notificationNewsDetected(notifyNewsEvent);
        }
     }
}

