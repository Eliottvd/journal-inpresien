/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_points_presse;

/**
 *
 * @author Admin
 */
public class RecuMessageEvent {
    
    private String _msg;
    public void setMsg(String m){_msg=m;}
    public String getMsg(){return _msg;}
    
    public RecuMessageEvent()
    {
        _msg=new String();
        
    }
}
