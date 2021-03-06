/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timer_pkg;

import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.converter.LocalTimeStringConverter;

/**
 *
 * @author Shenouda Fawzy
 */
public class Timer {
    
    int hr;
    int min;
    int sec;
    int milSec;
    
    String sHr;
    String sMin;
    String sSec;
    String sMilSec;
    
    String oldTime;
    String newTime;
    String timeFormatResult;
    
    public Timer(int hr, int min, int sec, int milSec){
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.milSec = milSec;
        
        sHr = "00";
        sMin = "00";
        sSec = "00";
        sMilSec = "000";
        
        oldTime = "00:00:00,000";
        newTime = "00:00:00,000";
    }
    
    /**
     * Take time in numerical value and parse in time format (hh:mm:ss), for future processing.
     */
    private String putTimeInFormat(int hr, int min, int sec, int milSec){
        // hr: 00 to 24, min: 00 to 59, sec: 00 to 59, milSec: 000 to 999
        
        if(hr > 9)
            sHr = hr + "";
        else
            sHr = "0" + hr;
        
        if(min > 9)
            sMin = min + "";
        else
            sMin = "0" + min;
        
        if(sec > 9)
            sSec = sec + "";
        else
            sSec = "0" + sec;
        
        if(milSec < 9)
            sMilSec = "00" + milSec;
        else if(milSec > 9 && milSec < 100)
            sMilSec = "0" + milSec;
        else
            sMilSec = milSec + "";
        
        this.timeFormatResult = sHr + ":" + sMin + ":" + sSec + "," + sMilSec;
        
        return timeFormatResult;
    }
    
    /**
     *  @param sec
     *          Specific how much seconds you want to increase.
     *  @param oldTime
     *          The time you want to increase.
     *  @return 
     *          Return new increased time with format hh:mm:ss
     */
    
    public String increesSeconds(int sec, String oldTime){
        extractTimeDetails(oldTime);
        this.sec += sec;
        while(this.sec > 59){
            this.sec -= 60;
            min++;
        }
        
        while(this.min > 59){
            this.min -= 60;
            hr++;
        }
        
        this.newTime = putTimeInFormat(this.hr, this.min, this.sec, this.milSec);
        
        return newTime;
    }
    

    /**
     *  @param sec
     *          Specific how much seconds you want to decrees.
     *  @param oldTime
     *          The time you want to decrease.
     *  @return 
     *          Return new decreased time with format hh:mm:ss
     */
    public String decreesSeconds(int sec, String oldTime){
        extractTimeDetails(oldTime);
        int seconds = convertToSeconds(oldTime);
        seconds -= sec;
        
        String nTime = "" ; 
        if(seconds >= 0)
            nTime = convertToTimeFormat(seconds);
        else 
            nTime = convertToTimeFormat(0);
        return nTime;
    }
    
    /**
     *  This metho to extract the numerical information from String format(hh:mm:ss).
     *  @param oldTime 
     *      The time you want to extract numrecal information Hour, Minutes, Seconds
     *       
     */
    
    private void extractTimeDetails(String oldTime){
        this.oldTime = oldTime;
        String [] tims = oldTime.split(":");
        sHr = tims[0];
        sMin = tims[1];
        sSec = tims[2].split(",")[0];
        sMilSec = tims[2].split(",")[1];
        
        hr = Integer.parseInt(sHr);
        min = Integer.parseInt(sMin);
        sec = Integer.parseInt(sSec);
        milSec = Integer.parseInt(sMilSec);
    }
    
    /**
     * Convert the time format (hh:mm:ss) to seconds.
     */
    protected int convertToSeconds(String time){
        extractTimeDetails(time);
        int totalSec = (hr * 60 * 60) + (min * 60) + sec;
        return totalSec;
    }
    
    /**
     * Convert the seconds to time format (hh:mm:ss).
     */
    protected String convertToTimeFormat(int sec){
        int h = sec / 3600;
        int remSec = sec % 3600;
        int minut = remSec / 60;
        int s = remSec % 60;
        
        String convertedTime = putTimeInFormat(h, minut, s, milSec);
        
        return convertedTime;
    }
    

}
