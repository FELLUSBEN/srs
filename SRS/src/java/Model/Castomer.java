/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author razic
 */
public class Castomer extends User {

    private String email;
    
    public Castomer(){
        
    }
    
    public void setP(String usr,String pass, String email) {
        super.setP(usr,pass);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
}
