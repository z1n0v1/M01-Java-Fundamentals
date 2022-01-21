/*
    https://judge.softuni.org/Contests/Practice/Index/1461#2

    03. Gaming Store

Write a program, which helps you buy the games. The valid games are the following games in this table:

Name        	Price
OutFall 4	                    $39.99
CS: OG	                        $15.99
Zplinter Zell	                $19.99
Honored 2	                    $59.99
RoverWatch	                    $29.99
RoverWatch Origins Edition	    $39.99

On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].
Until you receive the command “Game Time”, you have to keep buying games. When a game is bought,
the user’s balance decreases by the price of the game.

Additionally, the program should obey the following conditions:
•	If a game the user is trying to buy is not present in the table above, print “Not Found” and read the next line.
•	If at any point, the user has $0 left, print “Out of money!” and end the program.
•	Alternatively, if the user is trying to buy a game which they can’t afford, print “Too Expensive” and read the next line.

When you receive “Game Time”, print the user’s remaining money and total spent on games, rounded to the 2nd decimal place.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.More.T03GamingStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double money = currentBalance;


        while (true) {
            if (currentBalance == 0) {
                System.out.println("Out of money!");
            }
            String game = scanner.nextLine();

            if ( game.equals("Game Time")) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n", money-currentBalance, currentBalance);
                break;
            }

            switch (game) {
                case "RoverWatch Origins Edition":
                case "OutFall 4": {
                    if (currentBalance >= 39.99) {
                        System.out.printf("Bought %s%n",game);
                        currentBalance-=39.99;
                    } else System.out.println("Too Expensive");
                    break;
                }
                case "CS: OG": {
                    if (currentBalance >= 15.99) {
                        System.out.printf("Bought %s%n",game);
                        currentBalance-=15.99;
                    } else System.out.println("Too Expensive");
                    break;
                }
                case "Zplinter Zell": {
                    if (currentBalance >= 19.99) {
                        System.out.printf("Bought %s%n",game);
                        currentBalance-=19.99;
                    } else System.out.println("Too Expensive");
                    break;
                }
                case "Honored 2": {
                    if (currentBalance >= 59.99) {
                        System.out.printf("Bought %s%n",game);
                        currentBalance-=59.99;
                    } else System.out.println("Too Expensive");
                    break;
                }
                case "RoverWatch": {
                    if (currentBalance >= 29.99) {
                        System.out.printf("Bought %s%n",game);
                        currentBalance-=29.99;
                    } else System.out.println("Too Expensive");
                    break;
                }
//                case "RoverWatch Origins Edition": {
//                    if (currentBalance >= 39.99) {
//                        System.out.printf("Bought %s%n",game);
//                        currentBalance-=39.99;
//                    } else System.out.println("Too Expensive");
//                    break;
//                }

            }

        }

        //if (currentBalance == 0)
    }
}
