/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliott
 */
public class DateThread extends Thread{

    private JLabel _jLabelDate;
    private int _formatHeure;
    private int _formatDate;
    private Locale _pays;
    
    public DateThread(mainWindow mw) {
        _jLabelDate = mw.jlblDate2;
        _formatDate = DateFormat.SHORT;
        _formatHeure = DateFormat.MEDIUM;
        _pays = Locale.FRANCE;
    }
    
    public DateThread(ImpressionDialog id) {
        _jLabelDate = id.jLabelDate;
        _formatDate = DateFormat.SHORT;
        _formatHeure = DateFormat.MEDIUM;
        _pays = Locale.FRANCE;
    }
    
    public void setFormatHeure(int format)
    {
        _formatHeure = format;
    }
    
    public void setFormatDate(int format)
    {
        _formatDate = format;
    }
    
    public void setPays(Locale p)
    {
        _pays = p;
    }
    
    public void run()
    {
        boolean test = true;
        while(test == true)
        {
            try{
                Date maintenant = new Date();
                String maDate = DateFormat.getDateTimeInstance(_formatDate, _formatHeure, _pays).format(maintenant);
                _jLabelDate.setText(maDate);
                sleep(1000);
            }
            catch(InterruptedException e)
            {
                return;
            }
                
        }
    }
    
}
