/*
    https://judge.softuni.org/Contests/Practice/Index/1227#6

    07. Reversed Chars

Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.
 */

package L02L08DataTypesAndVariables.Lab.T07ReversedChars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstCharacter = scanner.nextLine().charAt(0);
        char secondCharacter = scanner.nextLine().charAt(0);
        char thirdCharacter = scanner.nextLine().charAt(0);
        System.out.printf("%c %c %c", thirdCharacter, secondCharacter, firstCharacter);
    }
}
