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
public class NewsCounterEvent {
    
    private int compteur;
    public void setCompteur(int x){compteur=x;}
    public int getCompteur(){return compteur;}
    
    private mainWindow _refWindowCounter;
    public void setRefWindowCounter(mainWindow m){_refWindowCounter=m;}
    public mainWindow getRefWindowCounter(){return _refWindowCounter;}
    public NewsCounterEvent()
    {
         compteur=0;
    }

    
}
