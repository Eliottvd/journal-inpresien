/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import java.io.Serializable;

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
public class Categorie implements Serializable { 
    private final String _nomCategorie; //Car jamais instaciable
    public static Categorie POLITIQUE = new Categorie("Vie politique");
    public static Categorie SPORT = new Categorie("Sport");
    public static Categorie INTERNATIONNAL = new Categorie("Internationnales");
    public static Categorie RAGOT = new Categorie("Ragots et potins");
    
    private Categorie(String nc)       //Empêche l'utilisation autre que par les variables static
    {
        _nomCategorie = nc;
    }
    
    @Override public String toString(){
        return _nomCategorie;
    }
    
    
}
