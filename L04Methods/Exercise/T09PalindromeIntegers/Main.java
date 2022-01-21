/*
    https://judge.softuni.org/Contests/Practice/Index/1286#8

    09. Palindrome Integers

A palindrome is a number which reads the same backward as forward, such as 323 or 1001.
Write a program which reads a positive integer numbers until you receive "END".
For each number print whether the number is palindrome or not.
 */

package L04Methods.Exercise.T09PalindromeIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        while (!str.equals("END")) {
            System.out.println(isPalindrome(str));
            str = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1- i))
                return false;
        }
        return true;
    }
}
