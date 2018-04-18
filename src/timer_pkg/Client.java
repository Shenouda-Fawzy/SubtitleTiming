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
        TimerFrame timeFrame = new TimerFrame();
        timeFrame.setVisible(true);
    }
}
