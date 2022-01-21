
/*
    https://judge.softuni.org/Contests/Practice/Index/1227#9

    10. Special Numbers

A number is special when its sum of digits is 5, 7 or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number
and if it is special or not (True / False).

 */
package L02L08DataTypesAndVariables.Lab.T10V1SpecialNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            String numberString = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < numberString.length(); j++) {
                int digit = Integer.parseInt(numberString.substring(j,j+1));
                sum+= digit;
            }
            if ( sum == 5 || sum == 7 || sum == 11)
                System.out.printf("%d -> True%n", i);
            else System.out.printf("%d -> False%n",i);
        }
    }
}
