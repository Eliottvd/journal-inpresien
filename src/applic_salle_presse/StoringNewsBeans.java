package applic_salle_presse;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StoringNewsBeans implements StoreNewsListener{
    
    public StoringNewsBeans()
    {
        
    }
    
    @Override
    
     public void storeNewsDetected(StoreNewsEvent se)
     {
        System.out.println(se.getStoreNews().getTitre()); 
        System.out.println(se.getStoreNews().getCat().toString());
        switch(se.getStoreNews().getCat().toString())
        {
            case "Internationnales" : se.getRefWindow().getModInter().addElement(se.getStoreNews().getTitre());
                                      se.getRefWindow().jListInter.setModel(se.getRefWindow().getModInter());
                                      se.getRefWindow().getListNews().add(se.getStoreNews());
                                      se.getRefWindow().jCBnews.removeItem(se.getRefWindow().jCBnews.getSelectedItem());
                                      
                                      break;
            case "Vie politique" : se.getRefWindow().getModViePol().addElement(se.getStoreNews().getTitre());
                                   se.getRefWindow().jListViePol.setModel(se.getRefWindow().getModViePol());
                                   se.getRefWindow().getListNews().add(se.getStoreNews());
                                   se.getRefWindow().jCBnews.removeItem(se.getRefWindow().jCBnews.getSelectedItem());
                                  
                                   break;
                                   
            case "Ragots et potins" : se.getRefWindow().getModRagots().addElement(se.getStoreNews().getTitre());
                                      se.getRefWindow().jListRagots.setModel(se.getRefWindow().getModRagots());
                                      se.getRefWindow().getListNews().add(se.getStoreNews());
                                      se.getRefWindow().jCBnews.removeItem(se.getRefWindow().jCBnews.getSelectedItem());
                                      
                                      break;
            case "Sport" :  se.getRefWindow().getModInfosSports().addElement(se.getStoreNews().getTitre());
                            se.getRefWindow().jListInfosSports.setModel(se.getRefWindow().getModInfosSports());
                            se.getRefWindow().getListNews().add(se.getStoreNews());
                            se.getRefWindow().jCBnews.removeItem(se.getRefWindow().jCBnews.getSelectedItem());
                            
                            break;
                                                                                    
        }
       
        try 
        {
            FileOutputStream fos=new  FileOutputStream(System.getProperty("user.home") + System.getProperty("file.separator" )+ "News.ser");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(se.getRefWindow().getListNews());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
     }
    
}
