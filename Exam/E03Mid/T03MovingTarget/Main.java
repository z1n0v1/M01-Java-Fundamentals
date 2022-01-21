/*
    https://judge.softuni.org/Contests/Practice/Index/2305#2

    03. Moving Target

You are at the shooting gallery again and you need a program that helps you keep track of moving targets.
On the first line, you will receive a sequence of targets with their integer values, split by a single space.
Then, you will start receiving commands for manipulating the targets, until the "End" command. The commands are the following:
•	Shoot {index} {power}
o	Shoot the target at the index, if it exists by reducing its value by the given power (integer value).
A target is considered shot when its value reaches 0.
o	Remove the target, if it is shot.
•	Add {index} {value}
o	Insert a target with the received value at the received index, if it exist. If not, print: "Invalid placement!"
•	Strike {index} {radius}
o	Remove the target at the given index and the ones before and after it depending on the radius, if such exist.
If any of the indices in the range is invalid print:
"Strike missed!" and skip this command.
 Example:  Strike 2 2
	{radius}	{radius}	{strikeIndex}	{radius}	{radius}

•	End
o	Print the sequence with targets in the following format:
{target1}|{target2}…|{targetn}
Input / Constraints
•	On the first line you will receive the sequence of targets – integer values [1-10000].
•	On the next lines, until the "End" will be receiving the command described above – strings.
•	There will never be a case when "Strike" command would empty the whole sequence.
Output
•	Print the appropriate message in case of "Strike" command if necessary.
•	In the end, print the sequence of targets in the format described above.

 */

package Exam.E03Mid.T03MovingTarget;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String data[] = input.split(" ");
            int index = Integer.parseInt(data[1]);
            int value = Integer.parseInt(data[2]);

            switch (data[0]) {
                case "Shoot": {
                    if (targets.size() > index && index >= 0) {
                        int target = targets.get(index);
                        target -= value;
                        if (target <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, target);
                        }
                    }
                    break;
                }
                case "Add": {
                    if (targets.size() > index && index >= 0) {
                        targets.add(index, value);
                    } else System.out.println("Invalid placement!");
                    break;
                }
                case "Strike": {
                    if ((index - value < 0) || (index + value) >= targets.size()) {
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = index + value; i >= index - value; i--) {
                            targets.remove(i);
                        }
                    }
                }
            }
//            System.out.println(targets);
            input = scanner.nextLine();
        }

        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.printf("%d|", targets.get(i));
        }
        System.out.println(targets.get(targets.size() - 1));
    }
}
