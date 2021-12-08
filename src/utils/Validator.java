/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Validator {
       
    public static boolean isNull(JTextField txt, String mes, StringBuilder sb) {
        if (txt.getText().isEmpty()) {
            sb.append(mes).append("\n");
            txt.setBackground(Color.RED);
            return true;
        } else {
            txt.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean checkId(JTextField txt, String str, StringBuilder sb, String mes) {
        if (txt.getText().equalsIgnoreCase(str)) {
            sb.append(mes).append("\n");
            txt.setBackground(Color.red);
            return false;
        } else {
            txt.setBackground(Color.white);
            return true;
        }
    }
}
