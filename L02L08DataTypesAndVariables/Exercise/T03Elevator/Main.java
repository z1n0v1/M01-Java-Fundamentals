/*
    https://judge.softuni.org/Contests/Practice/Index/1228#2

    03. Elevator

Calculate how many courses will be needed to elevate n persons by using an elevator with capacity of p persons.
The input holds two lines: the number of people n and the capacity p of the elevator.

In  Out
17  6
3

•	You should divide n by p. This gives you the number of full courses (e.g. 17 / 3 = 5).
•	If n does not divide p without a remainder, you will need one additional partially full course (e.g. 17 % 3 = 2).
•	Another approach is to round up n / p to the nearest integer (ceiling), e.g. 17/3 = 5.67  rounds up to 6.
•	Sample code for the round-up calculation:

int courses = (int) Math.ceil((double) n / p);
 */

package L02L08DataTypesAndVariables.Exercise.T03Elevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        if (capacity >= people) System.out.println(1);
        else if (people % capacity == 0)
            System.out.println(people/capacity);
        else System.out.println(people/capacity +1);

    }
}
