/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author razic
 */
public class Maneger {
    
    private static Maneger single_instance = null;
    
    private Maneger(){}
    
    public static synchronized Maneger getInstance(){
        if (single_instance == null)
            single_instance = new Maneger();
        
        return single_instance;
    }
    
    public User checkUsr(String usr, String pass){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM USERS WHERE USR='"+usr+"' AND PASS='"+pass+"'");
            User user = null;
            if(rs.next()){
                String u = rs.getString("USR");
                String p = rs.getString("PASS");
                user = new User(u, p);
            }else{
                rs = s.executeQuery("SELECT * FROM RESTAURANT WHERE USR='"+usr+"' AND PASS='"+pass+"'");
                if(rs.next()){
                    String u = rs.getString("USR");
                    String p = rs.getString("PASS");
                    String n = rs.getString("NAME");
                    String a = rs.getString("ADDRESS");
                    String e = rs.getString("EMPLOYEES");
                    int seats = rs.getInt("SEATS");
                    int fseats = rs.getInt("FREESEATS");
                    int pr = rs.getInt("PR");
                    int fpr = rs.getInt("FREEPR");
                    String t = rs.getString("TYPE");
                    user = new Restaurant(u,p,n,a,e,seats,fseats,pr,fpr,t);
                }
            }
            rs.close();
            s.close();
            c.close();
            return user;
        }catch(Exception e){
            return null;
        }
    }
    
    public Restaurant find(String name){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RESTAURANT WHERE NAME='"+name+"'");
            
            Restaurant r = null;
            if(rs.next()){
                String u = rs.getString("USR");
                String p = rs.getString("PASS");
                String n = rs.getString("NAME");
                String a = rs.getString("ADDRESS");
                String e = rs.getString("EMPLOYEES");
                int seats = rs.getInt("SEATS");
                int fseats = rs.getInt("FREESEATS");
                int pr = rs.getInt("PR");
                int fpr = rs.getInt("FREEPR");
                String t = rs.getString("TYPE");
                r = new Restaurant(u,p,n,a,e,seats,fseats,pr,fpr,t);
            }
            rs.close();
            s.close();
            c.close();
            return r;
        }catch(Exception e){
            return null;
        }
    }
    
    public void Add(Castomer x){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into USERS (USR,PASS,EMAIL) VALUES ('"+x.getUsr()+"','"+x.getPass()+"','"+x.getEmail()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public void Add(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into RESTAURANT (USR,PASS,NAME,ADDRESS,EMPLOYEES,SEATS,FREESEATS,PR,FREEPR,TYPE) VALUES ('"+r.getUsr()+"','"+r.getPass()+"','"+r.getName()+"','"+r.getAddress()+"','"+r.getEmployees()+"',"+r.getSeats()+","+r.getFreeSeats()+","+r.getPr()+","+r.getFreePR()+",'"+r.getType()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public void Add(Announcement a){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("insert into ANNOUNCEMENTS (USR,TITLE,DESCRIPTION,DATE,DEST) VALUES ('"+a.getUsr()+"','"+a.getTitel()+"','"+a.getDesc()+"',"+a.getDate().getTime()+",'"+a.getDest()+"')");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public void Update(Castomer c1,Castomer c2){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("UPDATE USERS SET EMAIL='"+c2.getEmail()+"' WHERE USR='"+c1.getUsr()+"'AND PASS='"+c1.getPass()+"'");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }
    
    public void Update(Restaurant r1,Restaurant r2){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("UPDATE RESTAURANT SET NAME='"+r2.getName()+"', ADDRESS='"+r2.getAddress()+"', EMPLOYEES='"+r2.getEmployees()+"', SEATS=" + r2.getSeats()+ ", FREESEATS=" + r2.getFreeSeats()+", PR=" + r2.getPr()+ ", FREEPR=" + r2.getFreePR()+ ", TYPE='" + r2.getType()+"' WHERE USR='"+r1.getUsr()+"' AND PASS='"+r1.getPass()+"'");
            s.close();
            c.close();
        }catch(Exception exeption){}
    }

    public boolean isExists(Castomer c){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/SRSDB";
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
    
    public boolean isExists(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/SRSDB";
            Connection cn = DriverManager.getConnection(urlCn,"root", "root");
            Statement  st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from RESTAURANT WHERE USR='"+r.getUsr()+"' AND PASS='"+r.getPass()+"'");

            boolean exists =false;
            if(rs.next())
                exists = true;
            rs.close();
            st.close();
            cn.close();
            return exists;
        }catch(Exception exception){return false;}
    }
    
    public ArrayList<Restaurant> Search(String name, String type){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RESTAURANT WHERE RESTAURANT.NAME='"+name+"' OR RESTAURANT.TYPE ='"+type+"'");
            ArrayList<Restaurant> restaurantList = new ArrayList<>();
            while(rs.next()){
                restaurantList.add(new Restaurant("","",rs.getString("NAME"),rs.getString("ADDRESS"),"",rs.getInt("SEATS"),rs.getInt("FREESEATS"),rs.getInt("PR"),rs.getInt("FREEPR"),rs.getString("TYPE")));
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
    
    public void Delete(Castomer c){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
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
    
    public void Delete(Restaurant r){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM RESTAURANT WHERE USR='"+r.getUsr()+"' AND PASS ='" + r.getPass()+"'");
            s.close();
            c.close();
            return;
        }catch(Exception exception){
            return;
        }
    }
    
    public void Delete(Announcement a){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM ANNOUNCEMENTS WHERE USR='"+a.getUsr()+"' AND DATE =" + a.getDate()+" AND DEST = '" + a.getDest() + "'");
            s.close();
            c.close();
            return;
        }catch(Exception exception){
            return;
        }
    }
    
    public void DeleteDate(long time){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM ANNOUNCEMENTS WHERE DATE < "+time);
            s.close();
            c.close();
            return;
        }catch(Exception exception){
            return;
        }
    }
    
    public ArrayList<Announcement> getAnnouncements(User u){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlc = "jdbc:derby://localhost:1527/SRSDB";
            Connection c = DriverManager.getConnection(urlc, "root", "root");
            Statement s = c.createStatement();
            ResultSet rs;
            
            if(u instanceof Restaurant){
                rs = s.executeQuery("SELECT * FROM ANNOUNCEMENTS WHERE DEST='"+u.getUsr()+"'");
            }else{
                rs = s.executeQuery("SELECT * FROM ANNOUNCEMENTS WHERE DEST='x'");
            }
            
            ArrayList<Announcement> Announcements = new ArrayList<>();
            while(rs.next()){
                Announcements.add(new Announcement(rs.getString("USR"),rs.getString("TITLE"),rs.getString("DESCRIPTION"),rs.getLong("DATE"),rs.getString("DEST")));
            }
            rs.close();
            s.close();
            c.close();
            if(Announcements.isEmpty()){
                return null;
            }
            return Announcements;
        }catch(Exception e){
            return null;
        }
    }
    
}
