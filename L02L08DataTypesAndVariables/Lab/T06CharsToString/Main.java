/*
    https://judge.softuni.org/Contests/Practice/Index/1227#5

    06. Chars to String

Write a program that reads 3 lines of input. On each line you get a single character.
Combine all the characters into one string and print it on the console.
 */

package L02L08DataTypesAndVariables.Lab.T06CharsToString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstCharacter = scanner.nextLine().charAt(0);
        char secondCharacter = scanner.nextLine().charAt(0);
        char thirdCharacter = scanner.nextLine().charAt(0);
        System.out.println("" + firstCharacter + secondCharacter + thirdCharacter);
    }
}
