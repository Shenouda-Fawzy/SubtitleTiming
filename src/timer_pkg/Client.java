/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer_pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Shenouda Fawzy
 */
public class Client {

    public static void main(String[] str) throws FileNotFoundException {
        
        String srcFileName = "Love in the Time of Cholera[2007]DvDrip[Eng]-FXG.ARB.srt";
        String distFialName = "Love In time of cholera.srt";
        File srcFile = new File(srcFileName);
        PrintWriter writer = new PrintWriter(distFialName);
        modifySubtitiles(srcFile, writer, 11, true);
    }
    
    /**
     * Combine all work together to modify the source subtitle file.
     *      @param srcFile
     *              The source subtitle file path(name)
     *      @param writer 
     *              The destination file path(name).
     *      @param second
     *              The amount of second you want to move the subtitle befor or after the speaking.
     *      @param  isForword 
     *              Specify if the subtitles move After(true) the speaking, or before(false) the speaking.
     */
    
    public static void modifySubtitiles(File srcFile, PrintWriter writer, int Second,boolean isForword) throws FileNotFoundException{
        Timer timer = new Timer(0, 0, 0, 0);
        final String DIGIT_REGEX = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9] --> [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]";
        Pattern pattern = Pattern.compile(DIGIT_REGEX);
        Matcher m;
        final String ARABIC_CHAR_SET = "Cp1256";
        Scanner sc = new Scanner(srcFile,ARABIC_CHAR_SET);
        //writer = new PrintWriter(distFialName);

        if (srcFile.exists() && srcFile.canRead()) {
// Read From src file
// Do process (increas, decrease)
// Write to distination file
            while (sc.hasNextLine() || sc.hasNext()) {
                String line = sc.nextLine(); // Read from src file
                m = pattern.matcher(line);
                if(m.matches() == true && isForword == true){ 
                // Do process    
                    String [] tokens = line.trim().split(" --> ");
                    String start = timer.decreesSeconds(Second, tokens[0]);
                    String end = timer.decreesSeconds(Second, tokens[1]);
                    
                // Write to distination file    
                    writer.println(start + " --> " + end);
                    continue;
                }else if(m.matches() == true && isForword == false){
                    // Do process    
                    String [] tokens = line.trim().split(" --> ");
                    String start = timer.increesSeconds(Second, tokens[0]);
                    String end = timer.increesSeconds(Second, tokens[1]);
                    
                // Write to distination file    
                    writer.println(start + " --> " + end);
                    continue;
                }
                writer.println(line);
            }
            sc.close();
            writer.close();
        }
    }
}
