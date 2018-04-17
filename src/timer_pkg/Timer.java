/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timer_pkg;

import java.time.LocalTime;
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
    
    // 00:25:30 - 125s
    
    public String decreesSeconds(int sec, String oldTime){
        extractTimeDetails(oldTime);
        /*
        - Convert to Second
        - Subtract seconds
        - Convert to time format hh:mm:ss,mil
        */
        int seconds = convertToSeconds(oldTime);
        seconds -= sec;
        
        String nTime = "" ; 
        if(seconds >= 0)
            nTime = convertToTimeFormat(seconds);
        else 
            nTime = convertToTimeFormat(0);
        return nTime;
    }
    
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
    
    protected int convertToSeconds(String time){
        extractTimeDetails(time);
        int totalSec = (hr * 60 * 60) + (min * 60) + sec;
        return totalSec;
    }
    
    protected String convertToTimeFormat(int sec){
        int h = sec / 3600;
        int remSec = sec % 3600;
        int minut = remSec / 60;
        int s = remSec % 60;
        
        String convertedTime = putTimeInFormat(h, minut, s, milSec);
        
        return convertedTime;
    }
    
    protected static String [] getTokens(String subTitle){
        String [] lines = subTitle.trim().split("\n");
        String [] tokens = lines[1].trim().split(" --> ");
        
        return tokens;
    }
}
