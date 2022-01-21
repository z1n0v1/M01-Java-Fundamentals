/*
    https://judge.softuni.org/Contests/Practice/Index/1674#5

    06. Winning Ticket

Lottery is exciting. What is not, is checking a million tickets for winnings only by hand.
So, you are given the task to create a program which automatically checks if a ticket is a winner.
You are given a collection of tickets separated by commas and spaces.
You need to check every one of them if it has a winning combination of symbols.
A valid ticket should have exactly 20 characters.
The winning symbols are '@', '#', '$' and '^'. But in order for a ticket to be a winner the symbol
should uninterruptedly repeat for at least 6 times in both the tickets left half and the tickets right half.
For example, a valid winning ticket should be something like this:
"Cash$$$$$$Ca$$$$$$sh"
The left half "Cash$$$$$$" contains "$$$$$$", which is also contained in the tickets right half "Ca$$$$$$sh".
A winning ticket should contain symbols repeating up to 10 times in both halves,
which is considered a Jackpot (for example: "$$$$$$$$$$$$$$$$$$$$").

Input
The input will be read from the console.
The input consists of a single line containing all tickets separated by commas and one or more white spaces in the format:
•	"{ticket}, {ticket}, … {ticket}"

Output
Print the result for every ticket in the order of their appearance, each on a separate line in the format:
•	Invalid ticket - "invalid ticket"
•	No match - "ticket "{ticket}" - no match"
•	Match with length 6 to 9 - "ticket "{ticket}" - {match length}{match symbol}"
•	Match with length 10 - "ticket "{ticket}" - {match length}{match symbol} Jackpot!"

Constrains
•	Number of tickets will be in range [0 … 100]
 */

package L09TextProcessing.Exercise.More.T06WinningTicket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s+");

        for (String ticket : tickets) {
            checkPrintTicket(ticket);
        }
    }

    private static void checkPrintTicket(String ticket) {
        if (ticket.length() != 20) {
            System.out.println("invalid ticket");
            return;
        } else {
            int repeatLength1 = getWin(ticket, '@'),
                    repeatLength2 = getWin(ticket, '#'),
                    repeatLength3 = getWin(ticket, '$'),
                    repeatLength4 = getWin(ticket, '^');
            if (repeatLength1 < 6 && repeatLength2 < 6 && repeatLength3 < 6 && repeatLength4 < 6) {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            } else if(repeatLength1 == 10) {
                System.out.printf("ticket \"%s\" - 10@ Jackpot!%n", ticket);
            } else if(repeatLength2 == 10) {
                System.out.printf("ticket \"%s\" - 10# Jackpot!%n", ticket);
            } else if (repeatLength3 == 10) {
                System.out.printf("ticket \"%s\" - 10$ Jackpot!%n", ticket);
            } else if (repeatLength4 == 10) {
                System.out.printf("ticket \"%s\" - 10^ Jackpot!%n", ticket);
            } else if (repeatLength1 > 5) {
                System.out.printf("ticket \"%s\" - %d@%n", ticket, repeatLength1);
            } else if (repeatLength2 > 5) {
                System.out.printf("ticket \"%s\" - %d#%n", ticket, repeatLength2);
            } else if (repeatLength3 > 5) {
                System.out.printf("ticket \"%s\" - %d$%n", ticket, repeatLength3);
            } else if (repeatLength4 > 5) {
                System.out.printf("ticket \"%s\" - %d^%n", ticket, repeatLength4);
            }
        }
    }

    private static int getWin(String ticket, char character) {
        String leftTicket = ticket.substring(0, ticket.length() / 2);
        String rightTicket = ticket.substring(ticket.length() / 2);

        int sumLeft = countRepeatCharacter(leftTicket, character);
        int sumRight = countRepeatCharacter(rightTicket, character);

        return Math.min(sumLeft, sumRight);
    }

    private static int countRepeatCharacter(String string, char character) {
        int repeat = 0;

        if (string.charAt(0) == character) repeat++;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                if (string.charAt(i - 1) == character) repeat++;
                else repeat = 1;
            }
        }
        return repeat;
    }
}
