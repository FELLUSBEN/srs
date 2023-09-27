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
    private String name;
    private String pass;
    
    public User(String name,String pass){
        this.name = name;
        this.pass = pass;
    }
    
    public User(String id){ //creats a guest user with session id
        this.name = "guest " + id;
        this.pass = "";
    }
    
    public String getName(){
        return name;
    }

}
