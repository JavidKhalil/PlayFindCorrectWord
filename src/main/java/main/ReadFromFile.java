/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author User
 */
public class ReadFromFile {

    public static String readFromFile(String fileName) throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader is = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(is);
        String str = null;
        String result = "";
        while ((str = br.readLine()) != null) {
            if (str != null) {
                result += str + "\n" + br.readLine() + "\n";
            }
        }
        return result;
    }
}
