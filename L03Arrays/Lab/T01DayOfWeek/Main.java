/*
    https://judge.softuni.org/Contests/Practice/Index/1248#0

    01. Day of Week

Enter a day number [1…7] and print the day name (in English) or "Invalid day!". Use an array of strings.

Hints
•	Use an array of strings holding the day names: {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}.
•	Print the element at index (day-1) when it is in the range [1…7] or "Invalid Day!" otherwise.
 */

package L03Arrays.Lab.T01DayOfWeek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] week = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int day = Integer.parseInt(scanner.nextLine());

        if ( day >= 1 && day <= 7)
            System.out.println(week[day-1]);
        else System.out.println("Invalid day!");
    }
}
