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
    private int employees;
    private int seats;
    private int freeSeats;
    private int pr;
    private int freePR;

    public Restaurant(String usr, String pass, String name, String address, int employees, int seats, int freeSeats, int pr, int freePR) {
        super(usr, pass);
        this.name = name;
        this.address = address;
        this.employees = employees;
        this.seats = seats;
        this.freeSeats = freeSeats;
        this.pr = pr;
        this.freePR = freePR;
    }

    public String getAddress() {
        return address;
    }

    public int getEmployees() {
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
    
}
