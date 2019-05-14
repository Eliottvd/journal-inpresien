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
public class NewsCounterBean implements NewsCounterListener{
    
    private javax.swing.JLabel _affcompteur;
    public javax.swing.JLabel getAffCompteur(){return _affcompteur;}
    public void setAffCompteur (javax.swing.JLabel aff){_affcompteur=aff;}
    
    public NewsCounterBean(javax.swing.JLabel affcompteur)
    {
        setAffCompteur(affcompteur);
    }
    
    @Override
    
    public void ajoutCompteur(NewsCounterEvent newscompteur)
    {
        newscompteur.setCompteur(newscompteur.getRefWindowCounter().listeNews.size());
       
        getAffCompteur().setText(Integer.toString(newscompteur.getCompteur()));
    }
}
