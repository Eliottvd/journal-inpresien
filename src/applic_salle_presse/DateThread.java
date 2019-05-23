package applic_salle_presse;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JLabel;

/**
 *
 * @author Eliott
 */
public class DateThread extends Thread{

    private final JLabel _jLabelDate;
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
    
    public int getFormatHeure(){
        return _formatHeure;
    }
    
    public int getFormatDate(){
        return _formatDate;
    }
    public Locale getFormatPays(){
        return _pays;
    }
    
    public String getFormatDateString(){ 
        return _formatHeure +"-"+ _formatDate + "-" + _pays;
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
