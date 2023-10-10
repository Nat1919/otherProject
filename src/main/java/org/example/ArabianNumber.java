package org.example;

public class ArabianNumber {
    public static boolean isArabian(String [] ar, String el){
        for(int i = 0; i<ar.length;i++){
            if(ar[i].equals(el)){
                return true;
            }
        }
        return false;
    }

}
