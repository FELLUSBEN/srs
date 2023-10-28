/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;



/**
 *
 * @author Ben
 */
public class ManegerTest {
    
    public ManegerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Maneger expResult = null;
        Maneger result = Maneger.getInstance();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testCheckUsr() {
        System.out.println("checkUsr");
        String usr = "";
        String pass = "";
        Maneger instance = Maneger.getInstance();
        User expResult = null;
        User result = instance.checkUsr(usr, pass);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testFind() {
        System.out.println("find");
        String name = "";
        //String type = "";//find signecher has bean changed
        Maneger instance = Maneger.getInstance();
        Restaurant expResult = null;
        Restaurant result = instance.find(name);
        assertNotEquals(expResult, result);
    }
    // ==== check inside the database for changes ====
    @Test
    public void testAdd_Castomer() {
        System.out.println("Add");
        Castomer x = null;
        Maneger instance = Maneger.getInstance();
        instance.Add(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testAdd_Restaurant() {
        System.out.println("Add");
        Restaurant r = null;
        Maneger instance = Maneger.getInstance();
        instance.Add(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAdd_Announcement() {
        System.out.println("Add");
        Announcement a = null;
        Maneger instance = Maneger.getInstance();
        instance.Add(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate_Castomer_Castomer() {
        System.out.println("Update");
        Castomer c1 = null;
        Castomer c2 = null;
        Maneger instance = Maneger.getInstance();
        instance.Update(c1, c2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate_Restaurant_Restaurant() {
        System.out.println("Update");
        Restaurant r1 = null;
        Restaurant r2 = null;
        Maneger instance = Maneger.getInstance();
        instance.Update(r1, r2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    // ===========================================
    
    
    @Test
    public void testIsExists_Castomer() {
        System.out.println("isExists");
        Castomer c = null;
        Maneger instance = Maneger.getInstance();
        boolean expResult = false;
        boolean result = instance.isExists(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsExists_Restaurant() {
        System.out.println("isExists");
        Restaurant r = null;
        Maneger instance = Maneger.getInstance();
        boolean expResult = false;
        boolean result = instance.isExists(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearch() {
        System.out.println("Search");
        String name = "";
        String type = "";
        Maneger instance = Maneger.getInstance();
        ArrayList<Restaurant> expResult = null;
        ArrayList<Restaurant> result = instance.Search(name, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete_Castomer() {
        System.out.println("Delete");
        Castomer c = null;
        Maneger instance = Maneger.getInstance();
        instance.Delete(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete_Restaurant() {
        System.out.println("Delete");
        Restaurant r = null;
        Maneger instance = Maneger.getInstance();
        instance.Delete(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testDelete_Announcement() {
        System.out.println("Delete");
        Restaurant r = null;
        Maneger instance = Maneger.getInstance();
        instance.Delete(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetAnnouncements() {
        System.out.println("getAnnouncements");
        Maneger instance = Maneger.getInstance();
        ArrayList<Announcement> expResult = null;
        ArrayList<Announcement> result = instance.getAnnouncements(new User("stam","check"));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
