/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkBasicClient;
import network.NetworkBasicServer;

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
    
   //public NetworkBasicServer NBS;
    //public NetworkBasicClient NBC;

    private ArrayList<NotifyNewsListener> _notifNewsListener;
    
    public void setNotifNewsListener(ArrayList<NotifyNewsListener> m)
    {
       _notifNewsListener=(m);
    }
    public void addNotifNewsListener(NotifyNewsListener k)
    {
        getNotifNewsListener().add(k);
    }
    public ArrayList<NotifyNewsListener> getNotifNewsListener(){return _notifNewsListener;}
    
    public ListeNewsBean()
    {
        //NBS=new NetworkBasicServer(60002, null);
        _messageTraite=new String();
        _messageRecu=new String();
       
       _notifNewsListener=new ArrayList<NotifyNewsListener>();
        
    }
     
     
    @Override
     public void newsDecteced(NewsEvent e)
     {
        
       /* try 
        {
            Thread.sleep(1000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(NBS.getMessage());
        setMessageRecu(NBS.getMessage());
        
        try 
        {
            Thread.sleep(1000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        NBS.setEndReceiving();*/
         
        setMessageTraite(concatenation(e.getMessageTraite(), e.getLocalite()));
        
        NotifyNewsEvent notifyNewsEvent=new NotifyNewsEvent();
        notifyNewsEvent.setMessageRecu(getMessageTraite());
        addNotifNewsListener(e.getMainPrincipale());
       // NBC=new NetworkBasicClient("localhost", 60003);
        
       // NBC.sendStringWithoutWaiting(getMessageTraite());
        
        for(int i=0;i<getNotifNewsListener().size();i++)
        {
            getNotifNewsListener().get(i).notificationNewsDetected(notifyNewsEvent);
        }
        
     }
    public String concatenation(String message, String localite)
    {
        return message+"/"+localite;
    }
}

