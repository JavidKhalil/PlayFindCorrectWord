/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class HashMepeSozYazan {

    public static HashMap<String, String> sozleriQebulEibHashMepDuzelden() throws IOException {
        HashMap<String, String> bizimHesh = new HashMap<>();
        String[] splitedStr = ReadFromFile.readFromFile("words.txt").split(",");
        String key = "";
        String value = "";
        for (int k = 0; k < splitedStr.length - 1; k++) {
            key = splitedStr[k];
            value = splitedStr[++k];
            bizimHesh.put(key, value);
        }
        return bizimHesh;
    }
}
