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

    String email;
    
    public Castomer(String usr,String pass, String email) {
        super(usr,pass);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
}
