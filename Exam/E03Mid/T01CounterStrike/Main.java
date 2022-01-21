/*
    https://judge.softuni.org/Contests/Practice/Index/2305#0

    01. Counter Strike

Write a program that keeps track of every won battle against an enemy.
You will receive initial energy. Afterwards you will start receiving the distance you need
to go to reach an enemy until the "End of battle" command is given, or until you run out of energy.
The energy you need for reaching an enemy is equal to the distance you receive.
Each time you reach an enemy, your energy is reduced. This is considered a successful battle (win).
If you don't have enough energy to reach an the enemy, print:
"Not enough energy! Game ends with {count} won battles and {energy} energy"
and end the program.
Every third won battle increases your energy with the value of your current count of won battles.
Upon receiving the "End of battle" command, print the count of won battles in the following format:
"Won battles: {count}. Energy left: {energy}"

Input / Constraints
•	On the first line you will receive initial energy – an integer [1-10000].
•	On the next lines, you will be receiving distance of the enemy – an integer [1-10000]

Output
•	The description contains the proper output messages for each case and the format in which they
should be print.

 */

package Exam.E03Mid.T01CounterStrike;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int numBattles = 0;
        boolean noEnergy = false;

        String input = scanner.nextLine();

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (energy < distance) {
                noEnergy = true;
                break;
            }
            numBattles++;
            energy-=distance;
            if(numBattles % 3 == 0) {
                energy += numBattles;
            }
            input = scanner.nextLine();
        }

        if(noEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", numBattles, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", numBattles, energy);
        }
    }
}
