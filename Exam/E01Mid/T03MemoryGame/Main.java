/*
    https://judge.softuni.org/Contests/Practice/Index/2517#2

    03. Memory Game

Write a program, which receives a sequence of elements. Each element in the sequence will have a twin.
Until the player receives "end" from the console, he will receive strings with two integers separated by space,
which represent the indexes of elements in the sequence.

If the player tries to cheat and enters two equal indexes or indexes which are out of bounds of the sequence
you should add two matching elements in the following format "-{number of moves until now}a" at the middle of the sequence
and print this message on the console:
"Invalid input! Adding additional elements to the board"

Input
•	On the first line you will receive sequence of elements.

Output
•	Every time the player hit two matching elements you should remove them from the sequence and print on the console
the following message:
"Congrats! You have found matching elements - ${element}!"
•	If the player hit two different elements, you should print on the console the following message:
"Try again!"
•	If the player hit all matching elements before he receives "end" from the console,
you should print on the console the following message:
"You have won in {number of moves until now} turns!"
•	If the player receives "end" before he hits all matching elements, you should print on the console the following message:
"Sorry you lose :(
              {the current sequence's state}"
Constraints
•	All elements in the sequence will always have a matching element.
 */

package Exam.E01Mid.T03MemoryGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<String> sequence;
    static int numMoves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        sequence = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (sequence.size() == 0)
                break;
            numMoves++;
            String[] data = input.split("\\s+");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            if (a > b) {
                int c = a;
                a = b;
                b = c;
            }

            if (a >= sequence.size() || a < 0 || b >= sequence.size() || b < 0 || a == b) {
                penalize();
            } else {
                String toRemove = sequence.get(a);
                if (removeElements(a, b))
                    System.out.printf("Congrats! You have found matching elements - %s!%n", toRemove);
                else System.out.println("Try again!");
            }
            input = scanner.nextLine();
        }
        if (sequence.size() == 0) {
            System.out.printf("You have won in %d turns!%n", numMoves);
        } else {
            System.out.println("Sorry you lose :(");
            for (String element : sequence)
                System.out.printf("%s ", element);
        }
    }

    static void penalize() {
        System.out.println("Invalid input! Adding additional elements to the board");
        int center = sequence.size() / 2;
        sequence.add(center, "-" + numMoves + "a");
        sequence.add(center + 1, "-" + numMoves + "a");
    }

    static boolean removeElements(int a, int b) {

        if (sequence.get(a).equals(sequence.get(b))) {
            sequence.remove(b);
            sequence.remove(a);
            return true;
        }
        return false;
    }
}
