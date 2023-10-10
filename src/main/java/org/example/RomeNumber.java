package org.example;

import static org.example.Calculator.roman;

public class RomeNumber {
    public static int romanToNumber (String roman) {

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -9;
    }
    public static boolean isRome(String[] ar, String el){
        for(int i = 0; i<ar.length;i++){
            if(ar[i].equals(el)){
                return true;
            }
        }
        return false;
    }

    public static String convertNumToRoman (int numArabian) throws Exception {
        if (numArabian < 0) {
            throw new Exception("в римской системе нет отрицательный чисел");
        } else {
            final String s = roman[numArabian];
            return s;
        }
    }
}
