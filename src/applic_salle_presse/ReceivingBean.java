/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import network.NetworkBasicClient;
import network.NetworkBasicServer;

/**
 *
 * @author Admin
 */
public class ReceivingBean implements Notifmessage{
    
    private String _messageTraite;
    //public NetworkBasicClient NBC;


    public void setMessageTraite(String m){_messageTraite=new String(); _messageTraite=m;}
    public String getMessageTraite(){return _messageTraite;}
    
    
    public NetworkBasicServer NBS;
    private ArrayList<NewsListener> _listenewlistener;
    
    public void setNewsListener(ArrayList<NewsListener> m)
    {
       _listenewlistener=(m);
    }
    public void addNewsListener(NewsListener k)
    {
        getNewsListener().add(k);
    }
    public ArrayList<NewsListener> getNewsListener(){return _listenewlistener;}
    
    public ReceivingBean(javax.swing.JCheckBox jCheckBox1)//le parametre c'est ajoute pq ??
    {
        
        NBS=new NetworkBasicServer(60001, jCheckBox1); 
        _listenewlistener=new  ArrayList<NewsListener>();
         
    }
    
    @Override
    public void ActionReceive(Event1News EvNews)
    {
      /* try 
        {
            Thread.sleep(1000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //System.out.println(NBS.getMessage());
        setMessageTraite(NBS.getMessage());
        try 
        {
            Thread.sleep(1000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //NBS.setEndReceiving();
        
        NewsEvent newEvent1=new NewsEvent();
        newEvent1.setMessageTraite(getMessageTraite());
        newEvent1.setLocalite(EvNews.getLocalite());
        newEvent1.setMainPrincipale(EvNews.getMainPrincipale());
        
        ListeNewsBean listeNewsBean=new ListeNewsBean();
        
       // NBC=new NetworkBasicClient("localhost", 60002);
        addNewsListener(listeNewsBean);
        
        //NBC.sendStringWithoutWaiting(getMessageTraite());
        
        for(int i=0;i<getNewsListener().size();i++)
               getNewsListener().get(i).newsDecteced(newEvent1);
        
       /* try 
        {
            Thread.sleep(2000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //NBC.setEndSending();*/
        
        
        
    }
    
}

    