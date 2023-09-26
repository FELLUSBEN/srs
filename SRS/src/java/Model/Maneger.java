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
            String urlc = "jdbc:derby://localhost:1527/my_db";
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
    
    /*public static void AddEvent(Event e){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/my_db";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into EVENTS (DAY,TIME,DESCRIPTION,PUB,USR) VALUES ("+e.getDay()+","+e.getTime()+",'"+e.getDesc()+"',"+e.isPub()+",'"+e.getUsr()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }*/
    
    /*public static void Update(Event e1,Event e2){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/my_db";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("UPDATE EVENTS SET DESCRIPTION='"+e2.getDesc()+"', DAY="+e2.getDay()+", TIME="+e2.getTime()+"WHERE USR='"+e1.getUsr()+"'AND DAY="+e1.getDay()+"AND TIME="+e1.getTime()+"AND PUB="+e1.isPub());
            s.close();
            c.close();
        }catch(Exception exeption){}
    }*/

    /*public static boolean isExists(Event e){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/my_db";
            Connection cn = DriverManager.getConnection(urlCn,"root", "root");
            Statement  st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from EVENTS WHERE USR='"+e.getUsr()+"' AND DAY="+e.getDay()+" AND TIME="+ e.getTime()+" AND PUB ="+e.isPub());
            boolean exists =false;
            if(rs.next())
                exists = true;
            rs.close();
            st.close();
            cn.close();
            return exists;
        }catch(Exception exception){return false;}
    }*/
    
    /*public static ArrayList<Event> Serch(String usr,int day,int hour){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/my_db";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM EVENTS WHERE EVENTS.DAY="+day+" AND EVENTS.TIME ="+hour);
            ArrayList<Event> eventList = new ArrayList<Event>();
            while(rs.next()){
                if(rs.getBoolean("PUB") || rs.getString("USR").equals(usr))
                    eventList.add(new Event(rs.getString("USR"), rs.getString("DESCRIPTION"), rs.getInt("DAY"), rs.getInt("TIME"), rs.getBoolean("PUB")));
            }
            rs.close();
            s.close();
            c.close();
            if(eventList.size()==0){
                return null;
            }
            return eventList;
        }catch(Exception e){
            return null;
        }
    }*/
    
    /*public static void Delete(Event e){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/my_db";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM EVENTS WHERE USR='"+e.getUsr()+"' AND DAY ="+e.getDay()+" AND TIME ="+e.getTime()+" AND PUB ="+e.isPub());
            s.close();
            c.close();
            return;
        }catch(Exception exception){
            return;
        }
    }*/
}
