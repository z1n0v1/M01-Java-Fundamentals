/*
    https://judge.softuni.org/Contests/Practice/Index/1260#6

    07. Repeat String

Write a method that receives a string and a repeat count n (integer).
The method should return a new string (the old one repeated n times).
 */

package L04Methods.Lab.T07RepeatString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(string, count));

    }

    private static String repeatString(String string, int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += string;
        }
        return str;
    }
}
