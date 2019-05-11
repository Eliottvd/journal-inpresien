/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

/**
 *
 * @author Eliott
 * 
 * 
 * C'est une classe qui existe principalement pour avoir les variables membres statiques
 * On n'a pas besoin de l'instancier 
 * -> Abstract ? 
 * NON, constructeur privé 
 * J'ai fait ca car si abstract, on peut la dériver et instancier la sousclasse.
 * De plus, ca porte à confusion : on peut croire que la à été désignée pour être dérivée
 * 
 * Donc j'ai mis le constructeur en privé ce qui empêche d'instancier la classe de manière propre
 */


//Noninstanciable Categorie class
public class Categorie { 
    private final String nomCategorie; //Car jamais instaciable
    
    private Categorie(String nc)       //Empêche l'utilisation autre que par les variables static
    {
        nomCategorie = nc;
    }
    
    public static Categorie POLITIQUE = new Categorie("politique");
    public static Categorie SPORT = new Categorie("sport");
    public static Categorie INTERNATIONNAL = new Categorie("internationnal");
    public static Categorie RAGOT = new Categorie("ragot");
}
