/*
    https://judge.softuni.org/Contests/Practice/Index/1286#2

    03. Characters in Range

Write a method that receives two characters
and prints on a single line all the characters in between them according to ASCII.
 */

package L04Methods.Exercise.T03CharactersInRange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);

        printBetweenCharacters(a, b);
    }

    private static void printBetweenCharacters(char a, char b) {
        char c;
        if ( a > b) {
            c = a; a = b; b = c;
        }
        a++;
        for (int i = a; i < b; i++) {
            System.out.printf("%c ", (char) i);

        }
    }
}
