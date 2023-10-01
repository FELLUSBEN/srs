/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
/**
 *
 * @author razic
 */
public class Announcement {
    private String usr;
    private String titel;
    private String desc;
    private Date date;
    
    public Announcement(String usr, String titel, String desc, int date) {
        this.usr = usr;
        this.titel = titel;
        this.desc = desc;
        this.date = new Date(date);
    }

    public Announcement(String usr, String titel, String desc) {
        this.usr = usr;
        this.titel = titel;
        this.desc = desc;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitel() {
        return titel;
    }

    public String getUsr() {
        return usr;
    }
     
    
    
}
