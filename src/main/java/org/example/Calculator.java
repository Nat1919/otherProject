package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.ArabianNumber.isArabian;
import static org.example.RomeNumber.*;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static char[] arrExpression = new char[10];
    static final String[] arrayNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static char operation;
    static final String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        try {
            switch (op) {
                case '+' -> {
                    result = num1 + num2;
                    break;
                }
                case '-' -> {
                    result = num1 - num2;
                    break;
                }
                case '*' -> {
                    result = num1 * num2;
                    break;
                }
                case '/' -> {
                    result = num1 / num2;
                    break;
                }

            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("строка не является математической операцией");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение в строку");

        String expression = scanner.nextLine();
        operation = expression.charAt(1);
        String[] arrayWithElements = expression.split("[+-/*]");
        String element01 = arrayWithElements[0].trim();
        String element02 = arrayWithElements[1].trim();
        int result = 0;

        if (isRome(roman, element01) && isRome(roman, element02) == isRome(roman, element01) ) {
            result = calculated(romanToNumber(element01),romanToNumber(element02), operation);
            String newResult = convertNumToRoman(result);
            System.out.println("результат = " + newResult);
        }
        else if (isRome(roman,element01) && isArabian(arrayNum,element02) || isArabian(arrayNum,element01) && isRome(roman,element02)) {
            throw new Exception("используются одновременно разные форматы счисления.");
        }
        else if (isArabian(arrayNum,element01 ) && isArabian(arrayNum,element01) == isArabian(arrayNum,element02)) {
            result = calculated( Integer.parseInt(element01), Integer.parseInt(element02), operation);
            System.out.println("результат = " + result);
        }else{
            throw new Exception("данная операция не является математической");
        }

    }

}

