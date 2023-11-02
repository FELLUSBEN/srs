/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Model;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author razic
 */
public class ManegerNGTest {
    
    private Maneger instance = Maneger.getInstance();
    private User existUser = new User("Usr","Test");
    private User fakeUser = new User("stam","fantom");
    
    public ManegerNGTest() {
    }


    public static void setUpClass() throws Exception {
    }


    public static void tearDownClass() throws Exception {
    }


    public void setUpMethod() throws Exception {
    }


    public void tearDownMethod() throws Exception {
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
        String usr = "Raz";
        String pass = "123";
        User result = instance.checkUsr(usr, pass);
        assertNotNull(result,"couldn't find user");
  
        usr = "ben";
        pass = "clone";
        result = instance.checkUsr(usr, pass);
        assertNull(result,"found user");
        
    }

    /**
     * Test of find method, of class Maneger.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String name = "BurgeRaz";
        Restaurant testorant = new Restaurant("Raz","333","BurgeRaz","","",0,0,0,0,"");
        Restaurant result = instance.find(name);
        assertEquals(result,testorant,"couldn't find restaurant");
    }
    // ==== check inside the database for changes ====
    
    @Test
    public void testIsExists_Castomer() {
        System.out.println("isExists");
        
        Castomer c = new Castomer("Raz","123","razi.chai@gmail.com");
        boolean result = instance.isExists(c);
        assertTrue(result, "couldn't find Castomer");
        
        c = new Castomer("ben","clone","benTzhokim@gmail.com");
        result = instance.isExists(c);
        assertFalse(result, "found non existent castomer");
    }
    
    @Test
    public void testIsExists_Restaurant() {
        System.out.println("isExists");
        
        Restaurant testorant = new Restaurant("Raz","333","BurgeRaz","","",0,0,0,0,"");
        boolean result = instance.isExists(testorant);
        assertTrue(result, "couldn't find Castomer");
        
        testorant = new Restaurant("ben","clone","","","",0,0,0,0,"");
        result = instance.isExists(testorant);
        assertFalse(result, "found non existent castomer");
    }
    
    @Test
    public void testSearch() {
       System.out.println("Search");
       
       ArrayList<Restaurant> expected = new ArrayList<Restaurant>();
       expected.add(new Restaurant("Raz","333","BurgeRaz","","",0,0,0,0,""));
       assertEquals(expected, instance.Search("Raz", ""),"couldn't find restaurant properly");
        
       assertNull(instance.Search("ben", "clone"),"couldn't find restaurant properly");
    }
//    
//    @Test
////    public void testAdd_Castomer() {
////        System.out.println("Add");
////        Castomer x = null;
////        Maneger instance = Maneger.getInstance();
////        instance.Add(x);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
////    @Test
////    public void testAdd_Restaurant() {
////        System.out.println("Add");
////        Restaurant r = null;
////        Maneger instance = Maneger.getInstance();
////        instance.Add(r);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    @Test
////    public void testAdd_Announcement() {
////        System.out.println("Add");
////        Announcement a = null;
////        Maneger instance = Maneger.getInstance();
////        instance.Add(a);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    @Test
////    public void testUpdate_Castomer_Castomer() {
////        System.out.println("Update");
////        Castomer c1 = null;
////        Castomer c2 = null;
////        Maneger instance = Maneger.getInstance();
////        instance.Update(c1, c2);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    @Test
////    public void testUpdate_Restaurant_Restaurant() {
////        System.out.println("Update");
////        Restaurant r1 = null;
////        Restaurant r2 = null;
////        Maneger instance = Maneger.getInstance();
////        instance.Update(r1, r2);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    // ===========================================
//
//    @Test
//    public void testDelete_Castomer() {
//        System.out.println("Delete");
//        Castomer c = null;
//        Maneger instance = Maneger.getInstance();
//        instance.Delete(c);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testDelete_Restaurant() {
//        System.out.println("Delete");
//        Restaurant r = null;
//        Maneger instance = Maneger.getInstance();
//        instance.Delete(r);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    
//    @Test
//    public void testDelete_Announcement() {
//        System.out.println("Delete");
//        Restaurant r = null;
//        Maneger instance = Maneger.getInstance();
//        instance.Delete(r);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//    @Test
//    public void testGetAnnouncements() {
//        System.out.println("getAnnouncements");
//        Maneger instance = Maneger.getInstance();
//        ArrayList<Announcement> = null;
//        ArrayList<Announcement> result = instance.getAnnouncements(new User("stam","check"));
//        assertEquals( result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
