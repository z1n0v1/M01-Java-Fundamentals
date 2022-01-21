/*
    https://judge.softuni.org/Contests/Practice/Index/1260#3

    04. Calculations

Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide")
and on the next two lines receives two numbers. Create four methods (for each calculation)
and invoke the right one depending on the command. The method should also print the result (needs to be void).
 */

package L04Methods.Lab.T04Calculations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "add":
                add(a, b);
                break;
            case "subtract":
                subtract(a, b);
                break;
            case "multiply":
                multiply(a, b);
                break;
            case "divide":
                divide(a, b);
                break;
        }


    }

    private static void add(int a, int b) {
        System.out.println(a + b);
    }

    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }

    private static void divide(int a, int b) {
        System.out.println(a / b);
    }

    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }
}
