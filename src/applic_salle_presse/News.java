/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;
import java.util.*;
import java.io.*;

/**
 *
 * @author Eliott
 * la classe News représente une information (son titre, son texte, sa catégorie, son
identifiant, sa source, la référence du journaliste qui l'a produite, sa date, le fait d'être
important ou pas, un container (Vector, ArrayList, etc) de ses mots-clé, …) 

 */
public class News implements Identifiable,Serializable{
    private int _idNews;
    private String _titre;
    private String _texte;
    private Categorie _cat;
    private String _source;
    private int _refJournaliste;
    private boolean _important;
    private final ArrayList<String> _motcles;

    public News() {
        _motcles = new ArrayList<String>();
    }
    
    
    public void setId(int i){_idNews = i;}
    public int getId(){ return _idNews;}
    public void setTitre(String s){_titre = s;}
    public String getTitre(){return _titre;}
    public void setTexte(String s){_texte = s;}
    public String getTexte(){return _texte;}
    public void setCat(Categorie c){_cat = c;}
    public Categorie getCat(){return _cat;}
    public void setSource(String s){_source = s;}
    public String getSource(){return _source;}
    public void setRefj(int r){_refJournaliste = r;}
    public int getRefj(){return _refJournaliste;}
    public void setImportance(boolean i){_important = i;}
    public boolean getImportance(){return _important;}
    public void addMotcle(String m){_motcles.add(m);}
    public void removeMotcle(String m){_motcles.remove(m);}
    public ArrayList<String> getMotcles(){return _motcles;}
    public String getMotCles1String(){
        String s = new String("");
        for(String mot : _motcles)
        {
            s = s.concat(mot+"-");
        }
        s = s.substring(0, s.length()-1);
        return s;
    }
    
    
    
    
}
