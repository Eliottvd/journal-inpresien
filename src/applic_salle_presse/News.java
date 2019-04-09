/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

/**
 *
 * @author Eliott
 * la classe News représente une information (son titre, son texte, sa catégorie, son
identifiant, sa source, la référence du journaliste qui l'a produite, sa date, le fait d'être
important ou pas, un container (Vector, ArrayList, etc) de ses mots-clé, …) 

 */
public class News {
    int idNews;
    StringBuffer titre;
    StringBuffer texte;
    StringBuffer cat;
    StringBuffer source;
    int refJournaliste;
    //Calendar c = Calendar.getInstance();
    boolean important;
    //Vector motClés;
    
    
}
