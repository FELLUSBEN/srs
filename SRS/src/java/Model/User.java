/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author razic
 */
public class User {
    private String usr;
    private String pass;
    
    public User(String usr,String pass){
        this.usr = usr;
        this.pass = pass;
    }
    
    public User(String id){ //creats a guest user with session id
        this.usr = "guest " + id;
        this.pass = "";
    }
    
    public String getUsr(){
        return usr;
    }

    public String getPass() {
        return pass;
    }

}
