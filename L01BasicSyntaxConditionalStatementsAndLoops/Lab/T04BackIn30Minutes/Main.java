/*
    https://judge.softuni.org/Contests/Practice/Index/1190#3

    04. Back In 30 Minutes

Every time Stamat tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes".
One day Stamat was sick of waiting and decided he needs a program, which prints the time after 30 minutes.
That way he won’t have to wait on the desk and come at the appropriate time.
He gave the assignment to you, so you have to do it.

Input
The input will be on two lines. On the first line, you will receive the hours and on the second you will receive the minutes.

Output
Print on the console the time after 30 minutes.
The result should be in format "hh:mm".
The hours have one or two numbers and the minutes have always two numbers (with leading zero).

Constraints
•	The hours will be between 0 and 23.
•	The minutes will be between 0 and 59.

 */
package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T04BackIn30Minutes;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int inMinutes = 60 * hours + minutes;
        inMinutes += 30;

        if (inMinutes > 24 * 60) inMinutes-= 24 * 60;

        System.out.printf("%d:%02d", inMinutes / 60, inMinutes % 60);
    }
}
