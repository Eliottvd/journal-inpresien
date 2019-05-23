package applic_salle_presse;

import java.util.ArrayList;

/**
 *
 * @author Eliott
 */
public class Impression extends Thread{
    private final ArrayList<News> _listNews;
    
    public Impression(mainWindow mw)
    {
        _listNews = mw.getListNews();
    }
    
    public void run()
    {
        try
        {
            ImpressionDialog test = new ImpressionDialog(null, false);
            test.setVisible(true);
            String newsFinies = "";
            test.jTextAreaNewsFinies.setText(newsFinies);
            for(int i = 0; i<_listNews.size();i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    test.jLabelInfo1.setText("Il me reste " + (_listNews.size()-i) + " news à imprimer");
                    test.jLabelInfo2.setText("Temps restant : " + ((_listNews.size()*5)-j-(i*5)) + " secondes");
                    sleep(1000);
                }
                newsFinies = newsFinies.concat(_listNews.get(i).getTitre() + "\n");
                test.jTextAreaNewsFinies.setText(newsFinies);
            }
            
            test.dispose();
        }
        catch(InterruptedException e)
        {
            return;
        }
    }
    
}
