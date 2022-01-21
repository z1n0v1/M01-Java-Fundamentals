/*
    https://judge.softuni.org/Contests/Practice/Index/1260#10

    11. Math operations

Write a method that receives two numbers and an operator, calculates the result and returns it.
You will be given three lines of input. The first will be the first number,
the second one will be the operator and the last one will be the second number. The possible operators are: / * + -

Print the result rounded up to the second decimal point.
 */

package L04Methods.Lab.T11MathOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(calculate(firstNumber,operator,secondNumber));
    }

    private static int calculate (int firstNumber, String operator, int secondNumber) {
        int result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = (firstNumber)/secondNumber;

        }

        return result;
    }
}
