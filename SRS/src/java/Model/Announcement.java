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
    private String dest;
    private static int dayOfYear;
    
    public Announcement(String usr, String titel, String desc, long date, String dest) {
        this.usr = usr;
        this.titel = titel;
        this.desc = desc;
        this.date = new Date(date);
        this.dest=dest;
    }

    public Announcement(String usr, String titel, String desc, String dest) {
        this.usr = usr;
        this.titel = titel;
        this.desc = desc;
        this.date = new Date();
        this.dest = dest;
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

    public String getDest() {
        return dest;
    }
     
    public static int getDayOfYear(){
        return dayOfYear;
    }

    public static void setDayOfYear(int dayOfYear) {
        Announcement.dayOfYear = dayOfYear;
    }
    
}
