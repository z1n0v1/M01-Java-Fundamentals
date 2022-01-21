/*
    https://judge.softuni.org/Contests/Practice/Index/1247#9

    10. LadyBugs

You are given a field size and the indexes of ladybugs inside the field.
After that on every new line until the "end" command is given, a ladybug changes its position
either to its left or to its right by a given fly length.

A command to a ladybug looks like this: "0 right 1".
This means that the little insect placed on index 0 should fly one index to its right.
If the ladybug lands on a fellow ladybug, it continues to fly in the same direction by the same fly length.
If the ladybug flies out of the field, it is gone.

For example, imagine you are given a field with size 3 and ladybugs on indexes 0 and 1.
If the ladybug on index 0 needs to fly to its right by the length of 1 (0 right 1)
it will attempt to land on index 1 but as there is another ladybug there it will continue further to the right by additional
length of 1, landing on index 2. After that, if the same ladybug needs to fly to its right by the length of 1 (2 right 1),
it will land somewhere outside of the field, so it flies away:

0 1 2  =>  0 1 2  => 0 1 2
* *          * *       *

If you are given ladybug index that does not have ladybug there, nothing happens.
If you are given ladybug index that is outside the field, nothing happens.

Your job is to create the program, simulating the ladybugs flying around doing nothing.
At the end, print all cells in the field separated by blank spaces.
For each cell that has a ladybug on it print '1' and for each empty cells print '0'.
For the example above, the output should be '0 1 0'.

Input
•	On the first line you will receive an integer - the size of the field
•	On the second line you will receive the initial indexes of all ladybugs separated by a blank space.
    The given indexes may or may not be inside the field range
•	On the next lines, until you get the "end" command you will receive commands
    in the format: "{ladybug index} {direction} {fly length}"

Output
•	Print the all cells within the field in format: "{cell} {cell} … {cell}"
o	If a cell has ladybug in it, print '1'
o	If a cell is empty, print '0'

Constrains
•	The size of the field will be in the range [0 … 1000]
•	The ladybug indexes will be in the range [-2,147,483,647 … 2,147,483,647]
•	The number of commands will be in the range [0 … 100]
•	The fly length will be in the range [-2,147,483,647 … 2,147,483,647]

 */

package L03Arrays.Exercise.T10LadyBugs;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        int[] ladybugsStartingIndexes = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < ladybugsStartingIndexes.length; i++) {
            if (ladybugsStartingIndexes[i] < 0
                    || ladybugsStartingIndexes[i] >= fieldSize) continue;
            field[ladybugsStartingIndexes[i]] = 1;
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int bugIndex = Integer.parseInt(command[0]);
            boolean toRight = false, toLeft = false;
            if (command[1].equals("right"))
                toRight = true;
            else toLeft = true;
            int moveLength = Integer.parseInt(command[2]);

            if (bugIndex < 0 || bugIndex >= fieldSize || field[bugIndex] == 0) {
                input = scanner.nextLine();
                continue;
            }

            field[bugIndex] = 0; // takeoff
            int newIndex = bugIndex;
            while (newIndex >= 0 && newIndex < fieldSize) {
                if (toRight) newIndex += moveLength;
                else if (toLeft) newIndex -= moveLength;
                if (newIndex >= 0 && newIndex < fieldSize && field[newIndex] == 1) continue;
                break;
            }
            if (newIndex >= 0 && newIndex < fieldSize)
                field[newIndex] = 1; // the Ladybug is lending
            input = scanner.nextLine();
        }
        for (int j : field)
            System.out.print(j + " ");

    }
}
