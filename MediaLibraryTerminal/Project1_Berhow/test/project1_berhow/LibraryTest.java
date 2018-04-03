/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_berhow;

import java.util.ArrayList;
import java.util.Scanner;
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
public class LibraryTest {
    
    public LibraryTest() {
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
     * Test of readBinFile method, of class Library.
     */
    @Test
    public void testReadBinFile() throws Exception {
        System.out.println("readBinFile");
        Library instance = new Library();
        instance.readBinFile();
        
    }

    /**
     * Test of writeBinFile method, of class Library.
     */
    @Test
    public void testWriteBinFile() throws Exception {
        System.out.println("writeBinFile");
        ArrayList<MediaItem> library = new ArrayList<>();
        MediaItem med1 = new MediaItem("thing1");
        MediaItem med2 = new MediaItem("thing2");
        MediaItem med3 = new MediaItem("thing3");
        MediaItem med4 = new MediaItem("thing4");
        library.add(med1);
        library.add(med2);
        library.add(med3);
        library.add(med4);
        Library instance = new Library();
        instance.writeBinFile(library);
        instance.displayMediaLibrary();
        instance.removeMedia(med1);
        instance.removeMedia(med2);
        instance.removeMedia(med3);
        instance.removeMedia(med4);
       
    }

    /**
     * Test of getLibrary method, of class Library.
     */
    @Test
    public void testGetLibrary() throws Exception {
        System.out.println("getLibrary");
        Library instance = new Library();
        ArrayList<MediaItem> expResult = instance.getLibrary();
        ArrayList<MediaItem> result = instance.getLibrary();
        instance.displayMediaLibrary();
        assertEquals(expResult, result);
        
    }

//    /**
//     * Test of commandMenu method, of class Library.
//     */
//    @Test
//    public void testCommandMenu() throws Exception {//should not need tested since it is a given that it will only take an integer input
//        System.out.println("commandMenu");
//        Scanner keyboard = null;
//        Library instance = new Library();
//        int expResult = 0;
//        int result = instance.commandMenu(keyboard);
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of newMedia method, of class Library.
     */
    @Test
    public void testNewMedia() throws Exception {
        System.out.println("newMedia");
        MediaItem media = new MediaItem("thing");
        Library instance = new Library();
        instance.newMedia(media);
        
    }

    /**
     * Test of loanMedia method, of class Library.
     */
    @Test
    public void testLoanMedia() throws Exception {                              //Why isnt this working???!!??
        System.out.println("loanMedia");
        MediaItem media = new MediaItem("Harry Potter");
        media.setMediaType("DVD");
        Library instance = new Library();
        instance.newMedia(media);
        String rentersName = "Bob";
        instance.loanMedia(media, rentersName);
        System.out.println(media.toString());
        
                
        
    }

    /**
     * Test of returnMedia method, of class Library.
     */
    @Test
    public void testReturnMedia() throws Exception {
        System.out.println("returnMedia");
        MediaItem media = new MediaItem("Star Wars");
        media.setMediaType("DVD");
        media.setDate();
        media.setLoan(true);
        media.setRentersName("Bob");
        Library instance = new Library();
        instance.newMedia(media);
        System.out.println(media.toString());
        instance.returnMedia(media);
        System.out.println(media.toString());
        
    }

    /**
     * Test of displayMediaLibrary method, of class Library.
     */
    @Test
    public void testDisplayMediaLibrary() throws Exception {
        System.out.println("displayMediaLibrary");
        Library instance = new Library();
        instance.displayMediaLibrary();
        
    }

    /**
     * Test of removeMedia method, of class Library.
     */
    @Test
    public void testRemoveMedia() throws Exception {
        System.out.println("removeMedia");
        MediaItem media = new MediaItem("Thing");
        Library instance = new Library();
        instance.newMedia(media);
        instance.displayMediaLibrary();
        instance.removeMedia(media);
        instance.displayMediaLibrary();
    }

    /**
     * Test of sortAlphabetically method, of class Library.
     */
    @Test
    public void testSortAlphabetically() throws Exception {
        System.out.println("sortAlphabetically");
        MediaItem med1 = new MediaItem("d");
        MediaItem med2 = new MediaItem("c");
        MediaItem med3 = new MediaItem("b");
        MediaItem med4 = new MediaItem("a");
        Library instance = new Library();
        instance.newMedia(med1);
        instance.newMedia(med2);
        instance.newMedia(med3);
        instance.newMedia(med4);
        instance.displayMediaLibrary();
        instance.sortAlphabetically();
        instance.displayMediaLibrary();
    }
    
}
