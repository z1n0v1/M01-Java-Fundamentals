/*
    https://judge.softuni.org/Contests/Practice/Index/1228#5

    06. Triples of Latin Letters

Write a program to read an integer n and print all triples of the first n small Latin letters, ordered alphabetically
 */

package L02L08DataTypesAndVariables.Exercise.T06TriplesOfLatinLetters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char firstLetter = 'a'; firstLetter < 'a' + n; firstLetter++) {
            for (char secondLetter = 'a'; secondLetter < 'a' + n; secondLetter++) {
                for (char thirdLetter = 'a'; thirdLetter < 'a' + n; thirdLetter++) {

                    System.out.printf("%c%c%c%n", firstLetter, secondLetter, thirdLetter);
                }

            }

        }

    }
}
