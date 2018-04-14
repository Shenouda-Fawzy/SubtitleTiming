/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer_pkg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shero
 */
public class TimerTest {
    
    public TimerTest() {
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
     * Test of increesSeconds method, of class Timer.
     */
    @Test
    public void testIncreesSeconds() {
        System.out.println("increesSeconds");
        int sec = 1;
        String oldTime = "00:00:00,000";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:01,000";
        String result = instance.increesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }

    /**
     * Test of decreesSeconds method, of class Timer.
     */
    @Test
    public void testDecreesSeconds() {
        System.out.println("decreesSeconds");
        int sec = 1;
        String oldTime = "00:00:01,000";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:00,000";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testDecreesSecondsWithMinus() {
        System.out.println("decreesSeconds");
        int sec = 20;
        String oldTime = "00:00:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:10,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    /**
     *
     */
    @Test
    public void testDecreesSecondsAndMinutes() {
        System.out.println("decreesSeconds");
        int sec = 20;
        String oldTime = "00:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:01:10,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
     /**
     *
     */
    @Test
    public void testDecreesSecondsAndMinutesWithMinus() {
        System.out.println("decreesSeconds");
        int sec = 70;
        String oldTime = "00:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:20,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
}
