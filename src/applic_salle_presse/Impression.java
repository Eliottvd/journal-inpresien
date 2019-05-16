/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Eliott
 */
public class Impression extends Thread{
    int _nbNews;
    ArrayList<News> _listNews;
    public Impression(int n)
    {
        _nbNews = n;
    }
    
    public Impression(mainWindow mw)
    {
        _listNews = mw.listeNews;
        _nbNews = _listNews.size();
    }
    
    public void run()
    {
        try
        {
            ImpressionDialog test = new ImpressionDialog(null, false);
            test.setVisible(true);
            String newsFinies = "";
            test.jTextAreaNewsFinies.setText(newsFinies);
            for(int i = 0; i<_nbNews;i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    test.jLabelInf1.setText("Il me reste " + (_nbNews-i) + " news à imprimer");
                    test.jLabelInfo2.setText("Temps restant : " + ((_nbNews*5)-j-(i*5)) + " secondes");
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
