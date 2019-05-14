/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StoreNewsEvent {
    private News _storeNews;
    public void setStoreNews(News n){_storeNews=n;}
    public News getStoreNews(){return _storeNews;}
    
    private mainWindow _refWindow;
    public void setRefWindow(mainWindow m){_refWindow=m;}
    public mainWindow getRefWindow(){return _refWindow;}
   
     
    public StoreNewsEvent()
    {
        _storeNews=new News();
     
    }
    
    
}
