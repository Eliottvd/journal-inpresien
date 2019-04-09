/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

/**
 *
 * @author Eliott
 */
public class Categorie {
    String nomCategorie;
    
    Categorie(String nc)
    {
        nomCategorie = nc;
    }
    
    static Categorie POLITIQUE = new Categorie("politique");
    static Categorie SPORT = new Categorie("sport");
    static Categorie INTERNATIONNAL = new Categorie("internationnal");
    static Categorie RAGOT = new Categorie("ragot");
}
