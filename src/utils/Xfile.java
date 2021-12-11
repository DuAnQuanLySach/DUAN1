/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Xfile implements Serializable{
    public static void WriteFile(String NameFile,Object obj){
        
        try {
            //Má»Ÿ luá»“n táº¡o Ä‘á»‘i tÆ°á»£ng ghi file
            FileOutputStream FOPS = new FileOutputStream(NameFile);
            
            ObjectOutputStream OOPS = new ObjectOutputStream(FOPS);
            //Thá»±c hiá»‡n ghi file
            OOPS.writeObject(obj);
            //Xáº£ bá»™ nhá»› Ä‘á»‡m
//            OOPS.flush();
            //Ä�Ã³ng luá»“ng
            OOPS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
