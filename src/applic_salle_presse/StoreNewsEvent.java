package applic_salle_presse;

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
