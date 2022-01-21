/*
    https://judge.softuni.org/Contests/Practice/Index/1227#7

    08. Lower or Upper

Write a program that prints whether a given character is upper-case or lower-case.
 */

package L02L08DataTypesAndVariables.Lab.T08LowerOrUpper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(letter))
            System.out.println("upper-case");
        else System.out.println("lower-case");
    }
}
