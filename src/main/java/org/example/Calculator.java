package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
   static char [] arrExpression = new char[10];
    static   String[] arrayNum ={"0","1","2","3","4","5","6","7","8","9","10"};
    static char  operation;
   static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
   private static String convertNumToRoman (int numArabian) throws Exception {
       if(numArabian < 0){
    throw new Exception("в римской системе нет отрицательный чисел");
    }else {
    final String s = roman[numArabian];
    return s;
}
   }
   public static boolean isRome(String[] ar, String el){
       for(int i = 0; i<ar.length;i++){
           if(ar[i].equals(el)){
               return true;
           }
        }
return false;
    }
    public static boolean isArabian(String [] ar, String el){
        for(int i = 0; i<ar.length;i++){
            if(ar[i].equals(el)){
                return true;
            }
        }
        return false;
    }
    private static int romanToNumber (String roman) {

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
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        try {
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
        }catch (InputMismatchException e){
            throw new InputMismatchException("строка не является математической операцией");
        }
        return result;
    }

        public static void main(String[] args) throws Exception {
            System.out.println("Введите выражение в строку");
            int number1 = 0;
            int number2 = 0;

            String expression = scanner.nextLine();

            for (int i = 0; i < expression.length(); i++) {
                arrExpression[i] = expression.charAt(i);
                if (arrExpression[i] == '+') {
                    operation = '+';
                }
                if (arrExpression[i] == '-') {
                    operation = '-';
                }
                if (arrExpression[i] == '*') {
                    operation = '*';
                }
                if (arrExpression[i] == '/') {
                    operation = '/';
                }

            }
                String newExpression = String.valueOf(arrExpression);
                String[] arrayWithElements = newExpression.split("[+-/*]");
                String  element01 = arrayWithElements[0];
                String element02 = arrayWithElements[1];
                String element03 = element02.trim();
                int result = 0;
                boolean b = isRome(roman, element03) == isRome(roman, element01);
                boolean a = isRome(roman, element01);

                boolean d = isArabian(arrayNum, element03) == isArabian(arrayNum, element01);
                boolean c = isArabian(arrayNum, element03);
                if (a && b) {
                    number1 = romanToNumber(element01);
                    number2 = romanToNumber(element03);
                    result = calculated(number1, number2, operation);
                    String newResult = convertNumToRoman(result);
                    System.out.println("результат = " + newResult);
                }
                if (a && c) {
                    throw new Exception("используются одновременно разные форматы счисления.");
                }
                if (c && d) {
                    number1 = Integer.parseInt(element01);
                    number2 = Integer.parseInt(element03);
                    result = calculated(number1, number2, operation);
                    System.out.println("результат = " + result);
                }
            }

        }

