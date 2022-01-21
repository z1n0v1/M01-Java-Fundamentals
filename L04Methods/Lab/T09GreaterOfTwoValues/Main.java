/*
    https://judge.softuni.org/Contests/Practice/Index/1260#8

    09. Greater of Two Values

You are given two values of the same type as input.
The values can be of type int, char of String. Create a method getMax() that returns the greater of the two values.
 */

package L04Methods.Lab.T09GreaterOfTwoValues;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String valueType = scanner.nextLine();
        String firstValue = scanner.nextLine();
        String secondValue = scanner.nextLine();

        switch (valueType) {
            case "string":
                System.out.println(getMax(firstValue, secondValue));
                break;
            case "char":
                System.out.println(getMax(firstValue.charAt(0), secondValue.charAt(0)));
                break;
            case "int":
                System.out.println(getMax(Integer.parseInt(firstValue), Integer.parseInt(secondValue)));
        }

    }

    private static String getMax(String firstValue, String secondValue) {
        if (firstValue.compareTo(secondValue) > 0)
            return firstValue;
        return secondValue;
    }

    private static char getMax(char firstValue, char secondValue) {
        if (firstValue > secondValue)
            return firstValue;
        return secondValue;
    }

    private static int getMax(int firstValue, int secondValue) {
        if (firstValue > secondValue)
            return firstValue;
        return secondValue;
    }
}
