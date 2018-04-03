/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_berhow;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class MediaItemTest {
    
    public MediaItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMediaName method, of class MediaItem.
     */
    @Test
    public void testGetMediaName() {
        System.out.println("getMediaNametest");
        MediaItem instance = new MediaItem("Thing");
        String expResult = "Thing";
        String result = instance.getMediaName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDate method, of class MediaItem.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        MediaItem instance = new MediaItem("Thing");
        Date expResult = instance.getDate();
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getloan method, of class MediaItem.
     */
    @Test
    public void testGetloan() {
        System.out.println("getloan");
        MediaItem instance = new MediaItem("Thing");
        boolean expResult = false;
        boolean result = instance.getloan();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRentersName method, of class MediaItem.
     */
    @Test
    public void testGetRentersName() {//renter set to null
        System.out.println("getRentersName");
        MediaItem instance =  new MediaItem("Thing");
        String expResult = null;
        String result = instance.getRentersName();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testGetRentersName2() {
        System.out.println("getRentersName");
        MediaItem instance =  new MediaItem("Thing");
        instance.setRentersName("Bob");
        String expResult = "Bob";
        String result = instance.getRentersName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDate method, of class MediaItem.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        MediaItem instance = new MediaItem("Thing");
        instance.setDate();
    }

    /**
     * Test of setLoan method, of class MediaItem.
     */
    @Test
    public void testSetLoan() {
        System.out.println("setLoan");
        boolean value = false;
        MediaItem instance = new MediaItem("Thing");
        instance.setLoan(value);
        
    }

    /**
     * Test of setRentersName method, of class MediaItem.
     */
    @Test
    public void testSetRentersName() {
        System.out.println("setRentersName");
        String rentersName = "Bob";
        MediaItem instance = new MediaItem("Thing");
        instance.setRentersName(rentersName);
        
    }

    /**
     * Test of setMediaType method, of class MediaItem.
     */
    @Test
    public void testSetMediaType() {
        System.out.println("setMediaType");
        String mediaType = "DVD";
        MediaItem instance = new MediaItem("Thing");
        instance.setMediaType(mediaType);
        
    }

    
}
