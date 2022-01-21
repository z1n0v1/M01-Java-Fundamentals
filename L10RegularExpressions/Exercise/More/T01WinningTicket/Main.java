/*
    https://judge.softuni.org/Contests/Practice/Index/1758#0

    1. Winning Ticket

Lottery is exciting. What is not, is checking a million tickets for winnings only by hand.
So, you are given the task to create a program which automatically checks if a ticket is a winner.
You are given a collection of tickets separated by commas and spaces.
You need to check every one of them if it has a winning combination of symbols.
A valid ticket should have exactly 20 characters. The winning symbols are '@', '#', '$' and '^'.
But in order for a ticket to be a winner the symbol should uninterruptedly repeat for at least 6 times
in both the tickets left half and the tickets right half.
For example, a valid winning ticket should be something like this:
"Cash$$$$$$Ca$$$$$$sh"
The left half "Cash$$$$$$" contains "$$$$$$", which is also contained in the tickets right half "Ca$$$$$$sh".
A winning ticket should contain symbols repeating up to 10 times in both halves,
which is considered a Jackpot (for example: "$$$$$$$$$$$$$$$$$$$$").

Input
The input will be read from the console. The input consists of a single line containing all tickets
separated by commas and one or more white spaces in the format:
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

package L10RegularExpressions.Exercise.More.T01WinningTicket;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s*");
        for (String ticket : tickets) {
            if(ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            int m1 = combo(ticket, '@'), m2 = combo(ticket, '#'),
                    m3 = combo(ticket, '$'), m4 = combo(ticket, '^');
            if (m1 == 10) System.out.printf("ticket \"%s\" - %d@ Jackpot!%n", ticket,m1);
            else if (m2 == 10) System.out.printf("ticket \"%s\" - %d# Jackpot!%n", ticket,m2);
            else if (m3 == 10) System.out.printf("ticket \"%s\" - %d$ Jackpot!%n", ticket,m3);
            else if (m4 == 10) System.out.printf("ticket \"%s\" - %d^ Jackpot!%n", ticket,m4);
            else if (m1 > 5) System.out.printf("ticket \"%s\" - %d@%n", ticket,m1);
            else if (m2 > 5) System.out.printf("ticket \"%s\" - %d#%n", ticket,m2);
            else if (m3 > 5) System.out.printf("ticket \"%s\" - %d$%n", ticket,m3);
            else if (m4 > 5) System.out.printf("ticket \"%s\" - %d^%n", ticket,m4);
            else System.out.printf("ticket \"%s\" - no match%n", ticket);
        }
    }

    private static int bestCombo(String ticket) {

        int m1 = combo(ticket, '@'), m2 = combo(ticket, '#'),
                m3 = combo(ticket, '$'), m4 = combo(ticket, '^');
        return Math.max(Math.max(m1, m2), Math.max(m3, m4));
    }

    private static int combo(String ticket, char type) {
        int result = 0;
        String leftTicket = ticket.substring(0, ticket.length() / 2);
        String rightTicket = ticket.substring(ticket.length() / 2);
        Pattern pattern = Pattern.compile("(?<match>([\\" + type + "])\\2{5,9})");

        Matcher leftMatcher = pattern.matcher(leftTicket);
        Matcher rightMatcher = pattern.matcher(rightTicket);

        int left = 0, right = 0;

        while (leftMatcher.find()) left = leftMatcher.group("match").length();
        while (rightMatcher.find()) right = rightMatcher.group("match").length();

        return Math.min(left, right);
    }
}
