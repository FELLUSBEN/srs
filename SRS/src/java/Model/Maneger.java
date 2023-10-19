/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author razic
 */
public class Maneger {
    public static User checkUsr(String usr, String pass){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM USERS WHERE USR='"+usr+"' AND PASS='"+pass+"'");
            
            if(rs.next()){
                String u = rs.getString("USR");
                String p = rs.getString("PASS");
                User user = new User(u, p);
                rs.close();
                s.close();
                c.close();
                return user;

            }
            rs.close();
            s.close();
            c.close();
            return null;
        }catch(Exception e){
            return null;
        }
    }
    
    public static void Add(Castomer x){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into USERS (USR,PASS,EMAIL) VALUES ('"+x.getUsr()+"','"+x.getPass()+"','"+x.getEmail()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public static void Add(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into RESTAURANTS (USR,PASS,NAME,ADDRESS,EMPLOYEES,SEATS,FREESEATS,PR,FREEPR,TYPE) VALUES ('"+r.getUsr()+"','"+r.getPass()+"','"+r.getName()+"','"+r.getAddress()+"',"+r.getEmployees()+","+r.getSeats()+","+r.getFreeSeats()+","+r.getPr()+","+r.getFreePR()+",'"+r.getType()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public static void Add(Announcement a){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into ANNOUNCEMENTS (USR,TITEL,DESC,DATE) VALUES ('"+a.getUsr()+"','"+a.getTitel()+"','"+a.getDesc()+"',"+a.getDate()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public static void Update(Castomer c1,Castomer c2){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("UPDATE USERS SET EMAIL='"+c2.getEmail()+"' WHERE USR='"+c1.getUsr()+"'AND PASS='"+c1.getPass()+"'");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public static void Update(Restaurant r1,Restaurant r2){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("UPDATE RESTAURANTS SET NAME='"+r2.getName()+"', ADDRESS='"+r2.getAddress()+"', EMPLOYEES="+r2.getEmployees()+", SEATS=" + r2.getSeats()+ ", FREESEATS=" + r2.getFreeSeats()+", PR=" + r2.getPr()+ ", FREEPR=" + r2.getFreePR()+ ", TYPE='" + r2.getType()+"' WHERE USR='"+r1.getUsr()+"' AND PASS='"+r1.getPass()+"'");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }

    public static boolean isExists(Castomer c){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/DB";
            Connection cn = DriverManager.getConnection(urlCn,"root", "root");
            Statement  st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from CASTOMER WHERE USR='"+c.getUsr()+"' AND PASS='"+c.getPass()+"'");
            
            boolean exists =false;
            if(rs.next())
                exists = true;
            rs.close();
            st.close();
            cn.close();
            return exists;
        }catch(Exception exception){return false;}
    }
    
    public static boolean isExists(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/DB";
            Connection cn = DriverManager.getConnection(urlCn,"root", "root");
            Statement  st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from RESTAURANTS WHERE USR='"+r.getUsr()+"' AND PASS='"+r.getPass()+"'");

            boolean exists =false;
            if(rs.next())
                exists = true;
            rs.close();
            st.close();
            cn.close();
            return exists;
        }catch(Exception exception){return false;}
    }
    
    public static ArrayList<Restaurant> Search(User u, String name, String desc){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RESTAURANTS WHERE RESTAURANT.NAME="+name+" OR RESTAURANT.DESC ="+desc);
            ArrayList<Restaurant> restaurantList = new ArrayList<>();
            while(rs.next()){
                restaurantList.add(new Restaurant("","",rs.getString("NAME"),rs.getString("ADDRESS"),"",rs.getInt("SEATS"),rs.getInt("FREESEATS"),rs.getInt("PR"),rs.getInt("FREEPR"),rs.getString("DESC")));
            }
            rs.close();
            s.close();
            c.close();
            if(restaurantList.isEmpty()){
                return null;
            }
            return restaurantList;
        }catch(Exception e){
            return null;
        }
    }
    
    public static void Delete(Castomer c){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection cn = DriverManager.getConnection(urlc, "root", "root");
            Statement s = cn.createStatement();
            s.executeUpdate("DELETE FROM USERS WHERE USR='"+c.getUsr()+"' AND PASS ='" + c.getPass()+"'");
            s.close();
            cn.close();
            return;
        }catch(Exception exception){
            return;
        }
    }
    
    public static void Delete(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/DB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM RESTAURANTS WHERE USR='"+r.getUsr()+"' AND PASS ='" + r.getPass()+"'");
            s.close();
            c.close();
            return;
        }catch(Exception exception){
            return;
        }
    }
    
    public static ArrayList<Announcement> getAnnouncements(){
        return null;
    }
    
}
