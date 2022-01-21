/*
    https://judge.softuni.org/Contests/Practice/Index/1227#11

    12. Refactor Special Numbers

You are given a working code that is a solution to Problem 9. Special Numbers.
However, the variables are improperly named, declared before they are needed and some of them are used for multiple things.
Without using your previous solution, modify the code so that it is easy to read and understand.

Scanner scanner = new Scanner(System.in);
int kolkko = Integer.parseInt(scanner.nextLine());
int obshto = 0;
int takova = 0;
boolean toe = false;
for (int ch = 1; ch <= kolkko; ch++) {
    takova = ch;
    while (ch > 0) {
        obshto += ch % 10;
        ch = ch / 10;
    }
    toe = (obshto == 5) || (obshto == 7) || (obshto == 11);
    System.out.printf("%d -> %b%n", takova, toe);
    obshto = 0;
    ch = takova;
}

Hints
•	Reduce the span of the variables by declaring them in the moment they receive a value, not before
•	Rename your variables to represent their real purpose (example: "toe" should become isSpecialNum, etc.)
•	Search for variables that have multiple purpose. If you find any, introduce a new variable

 */

package L02L08DataTypesAndVariables.Lab.T12RefactorSpecialNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int temporaryNumber = currentNumber;
            int sum = 0;
            while (temporaryNumber != 0) {
                sum += temporaryNumber % 10;
                temporaryNumber /= 10;
            }
            boolean isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);

            System.out.printf("%d -> %s%n", currentNumber, isSpecialNum ? "True" : "False");

        }
    }
}
