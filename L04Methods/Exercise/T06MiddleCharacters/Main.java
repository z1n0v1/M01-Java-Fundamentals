/*
    https://judge.softuni.org/Contests/Practice/Index/1286#5

    06. Middle Characters

You will receive a single string. Write a method that prints the middle character.
If the length of the string is even, there are two middle characters.
 */

package L04Methods.Exercise.T06MiddleCharacters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMiddleCharacter(scanner.nextLine());
    }

    private static void printMiddleCharacter(String str) {
        if(str.length() % 2 == 1)
            System.out.println(str.charAt(str.length()/2));
        else System.out.println(str.substring(str.length()/2 -1,str.length()/2 + 1));
    }
}
