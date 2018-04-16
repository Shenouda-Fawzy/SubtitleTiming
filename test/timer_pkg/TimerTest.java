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
 * @author Shenouda Fawzy
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

    
    /*
                    ====================                    
                      increesSeconds    
                    ====================  
    */
    
    /**
     * Test of increesSeconds method, of class Timer.
     */
    @Test
    public void testIncreesSeconds() {
        System.out.println("testIncreesSeconds");
        int sec = 1;
        String oldTime = "00:00:00,000";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:01,000";
        String result = instance.increesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }

    /*
                    ====================                    
                      decreesSeconds    
                    ====================  
    */
    
    /**
     * Test of decreesSeconds method, of class Timer.
     */
    @Test
    public void testDecreesSeconds() {
        System.out.println("testDecreesSeconds");
        int sec = 1;
        String oldTime = "00:00:01,000";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:00,000";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testDecreesSecondsWithMinus() {
        System.out.println("testDecreesSecondsWithMinus");
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
        System.out.println("testDecreesSecondsAndMinutes");
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
        System.out.println("testDecreesSecondsAndMinutesWithMinus");
        int sec = 70;
        String oldTime = "00:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:20,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
     /**
     *
     */
    @Test
    public void testDecreesSecondsToMinus() {
        System.out.println("testDecreesSecondsToMinus");
        int sec = 91;
        String oldTime = "00:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:00,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testDecreseSecondWithHour() {
        System.out.println("testDecreseSecondWithHour");
        int sec = 90;
        String oldTime = "01:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "01:00:00,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testDecreseSecondToHour() {
        System.out.println("testDecreseSecondWithHour");
        int sec = 91;
        String oldTime = "01:01:30,789";
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:59:00,789";
        String result = instance.decreesSeconds(sec, oldTime);
        assertEquals(expResult, result);

    }
    
    /*
                    ====================                    
                      convertToSecond    
                    ====================  
    */
    
    /**
     * Test of convertToSecond method, of class Timer.
     */
    
    @Test
    public void testConvertOneHourToSeconds(){
        System.out.println("testConvertOneHourToSeconds");
        String time = "01:00:00,789";
        Timer instance = new Timer(0, 0, 0, 0);
        int expResult = 3600;
        int result = instance.convertToSeconds(time);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertOneHourWithMinToSeconds(){
        System.out.println("testConvertOneHourToSeconds");
        String time = "01:02:00,789";
        Timer instance = new Timer(0, 0, 0, 0);
        int expResult = 3720;
        int result = instance.convertToSeconds(time);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertOneHourWithMinToSeconds2(){
        System.out.println("testConvertOneHourToSeconds");
        String time = "01:22:00,789";
        Timer instance = new Timer(0, 0, 0, 0);
        int expResult = 4920;
        int result = instance.convertToSeconds(time);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertOneMinToSeconds(){
        System.out.println("testConvertOneMinToSeconds");
        String time = "00:01:00,789";
        Timer instance = new Timer(0, 0, 0, 0);
        int expResult = 60;
        int result = instance.convertToSeconds(time);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertOneMinWithSecToSeconds(){
        System.out.println("testConvertOneMinToSeconds");
        String time = "00:01:15,789";
        Timer instance = new Timer(0, 0, 0, 0);
        int expResult = 75;
        int result = instance.convertToSeconds(time);
        assertEquals(expResult, result);
    }
    
     /*
                    ====================                    
                      convertToTimeFormat    
                    ====================  
    */
    
    @Test
    public void convertToTimeFormat() {
        System.out.println("convertToTimeFormat");
        int sec = 3600;
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "01:00:00,000";
        String result = instance.convertToTimeFormat(sec);
        assertEquals(expResult, result);

    }
    
    @Test
    public void convertToTimeFormat3710Sec() {
        System.out.println("convertToTimeFormat3710Sec");
        int sec = 3710;
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "01:01:50,000";
        String result = instance.convertToTimeFormat(sec);
        assertEquals(expResult, result);

    }
    
    @Test
    public void convertToTimeFormat712Sec() {
        System.out.println("convertToTimeFormat712Sec");
        int sec = 712;
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:11:52,000";
        String result = instance.convertToTimeFormat(sec);
        assertEquals(expResult, result);

    }
    
    @Test
    public void convertToTimeFormat44Sec() {
        System.out.println("convertToTimeFormat44Sec");
        int sec = 44;
        Timer instance = new Timer(0, 0, 0, 0);
        String expResult = "00:00:44,000";
        String result = instance.convertToTimeFormat(sec);
        assertEquals(expResult, result);

    }
}
