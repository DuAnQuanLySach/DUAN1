/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class JThread {
    public static void runText(JLabel lbl){
        Thread t = new Thread(){
            @Override
            public void run() {
                int i = 0;
                String text = lbl.getText();
                while (true) {                    
                    String c1 = text.substring(i, i + 1);
                    String c2 = text.substring(i, text.length());
                    text += c1;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbl.setText(c2);
                    i++;
                }
            }
        };
        t.start();
    }
    
    public static void dateTime(JLabel lbl){
        Thread t = new Thread(){
            @Override
            public void run() {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
                while (true) {                    
                    Date d = new Date();
                    lbl.setText(dateFormat.format(d));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        };
        t.start();
    }
}
