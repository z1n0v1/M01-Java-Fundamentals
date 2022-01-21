/*
    https://judge.softuni.org/Contests/Practice/Index/2305#1

    02. Shoot for the Win

Write a program that helps you keep track of your shot targets. You will receive a sequence with integers,
separated by single space, representing targets and their value. Afterwards, you will be receiving indices
until the "End" command is given and you need to print the targets and the count of shot targets.
Every time you receive an index, you need to shoot the target on that index, if it is possiblie.
Everytime you shoot a target, its value becomes -1 and it is considered shot. Along with that you also need to:
•	Reduce all the other targets, which have greater values than your current target, with its value.
•	All the targets, which have less than or equal value to the shot target, you need to increase with its value.
Keep in mind that you can't shoot a target, which is already shot. You also can't increase or reduce a target,
which is considered shot.
When you receive the "End" command, print the targets in their current state and the count of shot targets in the following format:
"Shot targets: {count} -> {target1} {target2}… {targetn}"
Input / Constraints
•	On the first line of input you will receive a sequence of integers, separated by a single space – the targets sequence.
•	On the next lines, until the "End" command you be receiving integers each on a single line – the index of the target to be shot.
Output
•	The format of the output is described above in the problem description.
 */

package Exam.E03Mid.T02ShootForTheWin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        int shotTargets = 0;
        while (!input.equals("End")) {
            int target = Integer.parseInt(input);

            if (target >= 0 && target < targets.length) {
                int targetSize = targets[target];
                targets[target] = -1;
                shotTargets++;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1) {
                        if (targets[i] > targetSize) targets[i] -= targetSize;
                        else   targets[i] += targetSize;
                    }
                }
            }
//            System.out.println(Arrays.toString(targets));
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        for (int i = 0; i < targets.length; i++) {
            System.out.printf("%d ", targets[i]);
        }
    }
}
