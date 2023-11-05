/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Date;

/**
 *
 * @author razic
 */
public class ManegerNGTest {
    
    private Maneger instance = Maneger.getInstance();
    
    private Castomer testomer = (Castomer)UserFactory.getUser("customer");
    private Restaurant testorant = (Restaurant)UserFactory.getUser("restaurant");
    private Announcement announcetest;
    private Announcement rannouncetest;
    
    private Castomer ftestomer = (Castomer)UserFactory.getUser("customer");
    private Restaurant ftestorant = (Restaurant)UserFactory.getUser("restaurant");
    private Announcement fannouncetest;
    
    private String time;
    private String user;
    private String fuser;
    
    public ManegerNGTest() {
    }


    public static void setUpClass() throws Exception {
    }


    public static void tearDownClass() throws Exception {
    }


    public void setUpMethod() throws Exception {
        time = String.valueOf(new Date().getTime());
        user = "Test-"+time;
        fuser = "fake";
        testomer.setP(user,time,user+"@gmail.com");
        testorant.setP(user, time, user, "", "", 20, 20, 2, 2, user);
        announcetest = new Announcement(user,"test","stam test","x");
        rannouncetest = new Announcement(user,"test","stam test",user);
        
        ftestomer.setP(fuser,fuser,user+"@gmail.com");
        ftestorant.setP(fuser,fuser, fuser, "", "", 10, 10, 1, 1, fuser);
        fannouncetest = new Announcement(fuser,"test","stam test","x");
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String urlc = "jdbc:derby://localhost:1527/SRSDB";
        Connection c = DriverManager.getConnection(urlc, "root", "root");
        Statement s = c.createStatement();
        s.executeUpdate("insert into USERS (USR,PASS,EMAIL) VALUES ('"+testomer.getUsr()+"','"+testomer.getPass()+"','"+testomer.getEmail()+"')");
        s.executeUpdate("insert into RESTAURANT (USR,PASS,NAME,ADDRESS,EMPLOYEES,SEATS,FREESEATS,PR,FREEPR,TYPE) VALUES ('"+testorant.getUsr()+"','"+testorant.getPass()+"','"+testorant.getName()+"','"+testorant.getAddress()+"','"+testorant.getEmployees()+"',"+testorant.getSeats()+","+testorant.getFreeSeats()+","+testorant.getPr()+","+testorant.getFreePR()+",'"+testorant.getType()+"')");
        s.executeUpdate("insert into ANNOUNCEMENTS (USR,TITLE,DESCRIPTION,DATE,DEST) VALUES ('"+announcetest.getUsr()+"','"+announcetest.getTitel()+"','"+announcetest.getDesc()+"',"+announcetest.getDate()+",'"+announcetest.getDest()+"')");

        s.close();
        c.close();
    }


    public void tearDownMethod() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String urlc = "jdbc:derby://localhost:1527/SRSDB";
        Connection c = DriverManager.getConnection(urlc, "root", "root");
        Statement s = c.createStatement();
        s.executeUpdate("DELETE FROM USERS WHERE USR='"+testomer.getUsr()+"' AND PASS ='" + testomer.getPass()+"'");
        s.executeUpdate("DELETE FROM RESTAURANT WHERE USR='"+testorant.getUsr()+"' AND PASS ='" + testorant.getPass()+"'");
        s.executeUpdate("DELETE FROM ANNOUNCEMENTS WHERE USR='"+announcetest.getUsr()+"' AND DATE =" + announcetest.getDate()+" AND DEST = '" + announcetest.getDest() + "'");
        
        s.close();
        c.close();
    }

    /**
     * Test of getInstance method, of class Maneger.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Maneger result = Maneger.getInstance();
        assertNotNull(result,"couldn't creat an instace");
    }

    @Test
    public void testCheckUsr() {
        System.out.println("checkUsr");
        User result = instance.checkUsr(user, time);
        assertNotNull(result,"couldn't find user");
  
        result = instance.checkUsr(fuser, fuser);
        assertNull(result,"found user");
    }

    @Test
    public void testFind() {
        System.out.println("find");
        Restaurant result = instance.find(testorant.getName());
        assertEquals(result,testorant,"couldn't find restaurant");
        
        result = instance.find(ftestorant.getName());
        assertNull(result,"couldn't find restaurant");
    }

    
    @Test
    public void testIsExists_Castomer() {
        System.out.println("isExists");
        
        boolean result = instance.isExists(testomer);
        assertTrue(result, "couldn't find castomer");
        
        result = instance.isExists(ftestomer);
        assertFalse(result, "found non existent castomer");
    }
    
    @Test
    public void testIsExists_Restaurant() {
        System.out.println("isExists");
        
        boolean result = instance.isExists(testorant);
        assertTrue(result, "couldn't find restaurant");
        
        result = instance.isExists(ftestorant);
        assertFalse(result, "found non existent restaurant");
    }
    
    @Test
    public void testIsExists_Announcement() {
        System.out.println("isExists");
        
        boolean result = instance.isExists(announcetest);
        assertTrue(result, "couldn't find announcement");
        
        result = instance.isExists(fannouncetest);
        assertFalse(result, "found non existent announcement");
    }
    
    @Test
    public void testSearch() {
       System.out.println("Search");
       
       ArrayList<Restaurant> expected = new ArrayList<Restaurant>();
       expected.add(testorant);
       assertEquals(expected, instance.Search(testorant.getName(), ""),"couldn't find restaurant by name");
       assertEquals(expected, instance.Search("", testorant.getType()),"couldn't find restaurant by food type");
       assertEquals(expected, instance.Search(testorant.getName(), testorant.getType()),"couldn't find restaurant by name and food type");
       
       assertNull(instance.Search(ftestorant.getName(),ftestorant.getType()),"fond a non existent restaurant");
    }
    
        @Test
    public void testDelete_Castomer() {
        System.out.println("Delete");
        
        boolean check = instance.isExists(testomer);
        assertTrue(check,"couldn't preform the test because isExists don't work or the test customer dosn't exists");
        if(check){
            instance.Delete(testomer);
            assertFalse(instance.isExists(testomer),"couldn't delete customer");
        }
    }

    @Test
    public void testDelete_Restaurant() {
        System.out.println("Delete");
        
        boolean check = instance.isExists(testorant);
        assertTrue(check,"couldn't preform the test because isExists don't work or the test restaurant dosn't exists");
        if(check){
            instance.Delete(testorant);
            assertFalse(instance.isExists(testorant),"couldn't delete restaurant");
        }
    }

    
    @Test
    public void testDelete_Announcement() {
        System.out.println("Delete");
        
        boolean check = instance.isExists(announcetest);
        assertTrue(check,"couldn't preform the test because isExists don't work or the test restaurant dosn't exists");
        if(check){
            instance.Delete(announcetest);
            assertFalse(instance.isExists(announcetest),"couldn't delete announcement");
        }
    }
    
    public void testDeleteDate() {
        System.out.println("DeleteDate");
        
        boolean check = instance.isExists(rannouncetest);
        assertTrue(check,"couldn't preform the test because isExists don't work or the test restaurant dosn't exists");
        if(check){
            instance.DeleteDate(rannouncetest.getDate());
            assertFalse(instance.isExists(rannouncetest),"couldn't delete announcement");
        }
    }

    
    @Test
    public void testAdd_Castomer() {
        System.out.println("Add");
        
        boolean check = instance.isExists(testomer);
        assertFalse(check,"couldn't preform the test because isExists don't work or the test customer exists");
        if(!check){
            instance.Add(testomer);
            assertTrue(instance.isExists(testomer),"couldn't add customer");
        }
    }
    
    @Test
    public void testAdd_Restaurant() {
       System.out.println("Add");
        
        boolean check = instance.isExists(testorant);
        assertFalse(check,"couldn't preform the test because isExists don't work or the test restaurant exists");
        if(!check){
            instance.Add(testorant);
            assertTrue(instance.isExists(testorant),"couldn't add restaurant");
        }
    }

    @Test
    public void testAdd_Announcement() {
        System.out.println("Add");
        
        boolean check = instance.isExists(announcetest);
        assertFalse(check,"couldn't preform the test because isExists don't work or the test announcement exists");
        if(!check){
            instance.Add(announcetest);
            assertTrue(instance.isExists(announcetest),"couldn't add announcement");
        }
    }
    
    @Test
    public void testUpdate_Restaurant_Restaurant() {
        System.out.println("Update");
        
        boolean check = instance.find(testorant.getName()).equals(testorant);
        assertTrue(check,"couldn't preform the test because find funqtion don't work or the test restaurant dosn't exists");
        if(check){
            instance.Update(testorant,ftestorant);
            testorant.setP(user, time, fuser, "", "", 10, 10, 1,1, fuser);
            assertEquals(testorant,instance.find(testorant.getName()).equals(testorant),"couldn't find restaurant");
        }
    }
    
    public void testGetAnnouncements(){
       System.out.println("DeleteDate");
        
       ArrayList<Announcement> expected = new ArrayList<Announcement>();
       expected.add(announcetest);
       
       boolean check = instance.isExists(announcetest);
       assertTrue(check,"couldn't preform the test because isExists don't work or the test restaurant dosn't exists");
       if(check){
            assertEquals(instance.getAnnouncements(testomer),expected,"couldn't get castomer announcements");
       } 
    }
}
