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
public class ExceptionLogin extends Exception {

    private String msgErr;
    public ExceptionLogin(int i) {
        switch(i)
        {
            case 0 : msgErr = "Login inconnu";
                break;
            case 1 : msgErr = "Mauvais mot de passe";
                break;
        }
    }
    
    @Override
    public String getMessage(){
        return msgErr;
    }    
    
}
