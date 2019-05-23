/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.++


 */
package applic_salle_presse;

/**
 *
 * @author Eliott van der Straten-Waillet 
 * @authorSup Ibrahim Tahiri-Alaoui
 */

public class Applic_Salle_Presse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("applic_salle_presse.Applic_Salle_Presse.main()");
        new FichierLog().addLog("--Nouvelle Session--");

        loginWindow lw = new loginWindow();
        lw.setVisible(true);
    }
    
}
