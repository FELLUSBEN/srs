/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author razic
 */
public class Restaurant extends User{
    private String name;
    private String address;
    private String employees;
    private int seats;
    private int freeSeats;
    private int pr;
    private int freePR;
    private String type;
    private static int dayOfYear;

    public Restaurant(){
        
    }
    
    public Restaurant(String usr, String pass, String name, String address, String employees, int seats, int freeSeats, int pr, int freePR, String type) {
        super(usr, pass);
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.seats = seats;
        this.freeSeats = freeSeats;
        this.pr = pr;
        this.freePR = freePR;
        this.type = type;
    }
    
    public void setP(String usr, String pass, String name, String address, String employees, int seats, int freeSeats, int pr, int freePR, String type) {
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.seats = seats;
        this.freeSeats = freeSeats;
        this.pr = pr;
        this.freePR = freePR;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployees() {
        return employees;
    }

    public int getFreePR() {
        return freePR;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public String getName() {
        return name;
    }

    public int getPr() {
        return pr;
    }

    public int getSeats() {
        return seats;
    }

    public String getType() {
        return type;
    }

    public void setFreePR(int freePR) {
        this.freePR = freePR;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public static int getDayOfYear(){
        return dayOfYear;
    }

    public static void setDayOfYear(int day) {
        dayOfYear = day;
    }

}
