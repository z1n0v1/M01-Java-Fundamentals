/*
    https://judge.softuni.org/Contests/Practice/Index/1228#4

    05. Print Part Of ASCII Table

Find online more information about ASCII (American Standard Code for Information Interchange)
and write a program that prints part of the ASCII table of characters at the console.
On the first line of input you will receive the char index you should start with and on the
second line - the index of the last character you should print.

 */

package L02L08DataTypesAndVariables.Exercise.T05PrintPartOfASCIITable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstIndex = (char) Integer.parseInt(scanner.nextLine());
        char lastIndex = (char) Integer.parseInt(scanner.nextLine());

        for (char index = firstIndex; index <= lastIndex; index++) {
            System.out.printf("%c ", index);

        }
    }
}
