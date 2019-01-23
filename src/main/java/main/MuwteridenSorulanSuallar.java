/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MuwteridenSorulanSuallar {

    public static HashMap<String, String> map = new HashMap<>();
    public static int count = 0;

    static {
        try {
            map = HashMepeSozYazan.sozleriQebulEibHashMepDuzelden();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static int giveRandom() {
        int i = map.size();
        return ((int) (Math.random() * (i - 1)) + 1);
    }

    public static void birinciSual() {
        System.out.println("Do you prefer english or Azerbaijani?");
        System.out.println("Please select 1 for english and 2 for Azerbaijani");
        Scanner sc = new Scanner(System.in);
        int selected = sc.nextInt();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MuwteridenSorulanSuallar.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (selected == 1) {
            System.out.println("Selected english");
            ikinciSualEng();
        } else {
            System.out.println("Azerbaijan dili secilib");
            ikinciSualAze();
        }
    }

    public static void ikinciSualAze() {
        System.out.println("Oyuna bawlayiriq");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MuwteridenSorulanSuallar.class.getName()).log(Level.SEVERE, null, ex);
        }
        continuePlayAz();
    }

    public static void ikinciSualEng() {
        System.out.println("We begin to play...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MuwteridenSorulanSuallar.class.getName()).log(Level.SEVERE, null, ex);
        }
        continuePlayEn();
    }

    public static void playInEng() {
        System.out.println("Would you like to continue? Select 1 for cotinue, 2 for end");
        Scanner res = new Scanner(System.in);
        int en = res.nextInt();
        if (en == 1) {
            continuePlayEn();
        } else {
            System.exit(0);
        }
    }

    public static void playInAz() {
        System.out.println("Davam etmek isteyirsiniz? Davam ucun 1, bitirmek ucun 2 secin");
        Scanner res = new Scanner(System.in);
        int en = res.nextInt();
        if (en == 1) {
            continuePlayAz();
        } else {
            System.exit(0);
        }
    }

    public static void continuePlayEn() {
        Object[] keysOfMap = map.keySet().toArray();
        Object[] valuesOfMap = map.values().toArray();
        int i = giveRandom();
        String randomKey = (String) keysOfMap[i];
        String randomValue = (String) valuesOfMap[i];
        System.out.println("How you say in Azerbaijani... " + randomKey);
        Scanner sss = new Scanner(System.in);
        String cavab = sss.next();
        if (randomValue==cavab) {
            System.out.println("Your answer is correct))..");
            map.remove(randomKey);
        } else {
            System.out.println("Your answer is wrong((...");
            System.out.println("Correct answer is   " + randomValue);
            count++;
            if (count == 3) {
                System.out.println("Sorry you lost(((...");
                System.out.println("We end play...");
                System.exit(0);
            }
            playInEng();
        }
    }

    public static void continuePlayAz() {
        List<String> valuesOfMap = (List) map.values();
        List<String> keysOfMap = (List) map.keySet();
        int i = giveRandom();
        String randomKey = keysOfMap.get(i);
        String randomValue = valuesOfMap.get(i);
        System.out.println("Azerbaycanca ... " + randomValue + "..nedir");
        Scanner sss = new Scanner(System.in);
        String cavab = sss.next();
        if (randomKey.equalsIgnoreCase(cavab)) {
            System.out.println("Cavabiniz dogrudur ))) ..");
            map.remove(randomKey);
        } else {
            System.out.println("Cavabiniz yanliwdir((...");
            System.out.println("Duzgun cavab   " + randomKey);
            count++;
            if (count == 3) {
                System.out.println("Uzr isteyirik, siz uduzdunuz(((...");
                System.out.println("Oyun sona catir...");
                System.exit(0);
            }
            playInAz();
        }

    }

}
