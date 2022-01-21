/*
    https://judge.softuni.org/Contests/Practice/Index/1190#7

    08. Divisible by 3

Write a program, which prints all the numbers from 1 to 100, which are divisible by 3.
You have to use a single for loop. The program should not receive input.

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T08DivisibleBy3;

public class Main {
    public static void main(String[] args) {
        for (int i = 3; i <= 100 ; i+=3) {
            System.out.println(i);
        }
    }
}
