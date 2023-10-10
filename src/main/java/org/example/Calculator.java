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
        int number1 = 0;
        int number2 = 0;
        String expression = scanner.nextLine();
        operation = expression.charAt(1);
        String[] arrayWithElements = expression.split("[+-/*]");
        String element01 = arrayWithElements[0].trim();
        String element02 = arrayWithElements[1].trim();
        int result = 0;
        boolean b = isRome(roman, element02) == isRome(roman, element01);
        boolean a = isRome(roman, element01);

        boolean d = isArabian(arrayNum, element02) == isArabian(arrayNum, element01);
        boolean c = isArabian(arrayNum, element02);
        if (a && b) {
            number1 = romanToNumber(element01);
            number2 = romanToNumber(element02);
            result = calculated(number1, number2, operation);
            String newResult = convertNumToRoman(result);
            System.out.println("результат = " + newResult);
        }
        if (a && c) {
            throw new Exception("используются одновременно разные форматы счисления.");
        }
        if (c && d) {
            number1 = Integer.parseInt(element01);
            number2 = Integer.parseInt(element02);
            result = calculated(number1, number2, operation);
            System.out.println("результат = " + result);
        }

    }

}

