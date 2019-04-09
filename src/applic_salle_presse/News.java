/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;
import java.util.*;

/**
 *
 * @author Eliott
 * la classe News représente une information (son titre, son texte, sa catégorie, son
identifiant, sa source, la référence du journaliste qui l'a produite, sa date, le fait d'être
important ou pas, un container (Vector, ArrayList, etc) de ses mots-clé, …) 

 */
public class News {
    int idNews;
    String titre;
    String texte;
    String cat;
    String source;
    int refJournaliste;
    //Calendar c = Calendar.getInstance();
    boolean important;
    ArrayList<String> motcles;
    
    public void setId(int i){idNews = i;}
    public int getId(){ return idNews;}
    public void setTitre(String s){titre = s;}
    public String getTitre(){return titre;}
    public void setTexte(String s){texte = s;}
    public String getTexte(){return texte;}
    public void setCat(String s){cat = s;}
    public String getCat(){return cat;}
    public void setSource(String s){source = s;}
    public String getSource(){return source;}
    public void setRefj(int r){refJournaliste = r;}
    public int getRefj(){return refJournaliste;}
    public void setImportance(boolean i){important = i;}
    public boolean getImportance(){return important;}
    public void addMotcle(String m){motcles.add(m);}
    public void removeMotcle(String m){motcles.remove(m);}
    public ArrayList<String> getMotcles(){return motcles;}
    
    
    
    
}
