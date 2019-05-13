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

    private String _msgErr;
    static public enum erreur{
        ERRLOGIN,
        ERRPASS;
    };
    
    public ExceptionLogin(erreur e) {
        switch(e)
        {
            case ERRLOGIN : _msgErr = "Login inconnu";
                break;
            case ERRPASS : _msgErr = "Mauvais mot de passe";
                break;
        }
    }
    
    @Override
    public String getMessage(){
        return _msgErr;
    }
    @Override public String toString(){
        return _msgErr;
    }
    
}
