package applic_salle_presse;
import java.util.*;
import java.io.*;

/**
 *
 * @author Eliott
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
    public void setTitre(String ttr){_titre = ttr;}
    public String getTitre(){return _titre;}
    public void setTexte(String txt){_texte = txt;}
    public String getTexte(){return _texte;}
    public void setCat(Categorie cat){_cat = cat;}
    public Categorie getCat(){return _cat;}
    public void setSource(String src){_source = src;}
    public String getSource(){return _source;}
    public void setRefj(int ref){_refJournaliste = ref;}
    public int getRefj(){return _refJournaliste;}
    public void setImportance(boolean imp){_important = imp;}
    public boolean getImportance(){return _important;}
    public void addMotcle(String mot){_motcles.add(mot);}
    public void removeMotcle(String mot){_motcles.remove(mot);}
    public ArrayList<String> getMotcles(){return _motcles;}
    public String getMotCles1String(){
        String s = "";              // String s = new String(""); MAUVAISE FORMULATION 
        for(String mot : _motcles)
        {
            s = s.concat(mot+"-");
        }
        s = s.substring(0, s.length()-1);
        return s;
    }
    
    @Override public String toString(){
        return "\nId = " + _idNews + "\nTitre = " + _titre + "\nCat = " + _cat;
    }   
}
