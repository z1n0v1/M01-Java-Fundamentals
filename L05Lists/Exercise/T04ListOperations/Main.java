/*
    https://judge.softuni.org/Contests/Practice/Index/1297#3

    04. List Operations

You will be given numbers (list of integers) on the first input line.
Until you receive "End" you will be given operations you have to apply on the list. The possible commands are:
•	Add {number} - add number at the end
•	Insert {number} {index} - insert number at given index
•	Remove {index} - remove that index
•	Shift left {count} - first number becomes last 'count' times
•	Shift right {count} - last number becomes first 'count' times

Note: It is possible that the index given is outside of the bounds of the array. In that case print "Invalid index".
 */

package L05Lists.Exercise.T04ListOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] command = input.split(" +");

            int index = 0;
            switch (command[0]) {
                case "Add":
                    list.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    index = Integer.parseInt(command[2]);
                    if(index > list.size() || index <0)
                        System.out.println("Invalid index");
                    else list.add(index, Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    if(index > list.size() || index < 0)
                        System.out.println("Invalid index");
                    else list.remove(index);
                    break;
                case "Shift": {
                    if (command[1].equals("left")) {
                        for (int i = 0; i < Integer.parseInt(command[2]); i++) {
                            list.add(list.get(0));
                            list.remove(0);
                        }
                    } else {
                        for (int i = 0; i < Integer.parseInt(command[2]); i++) {
                            list.add(0, list.get(list.size() - 1));
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Integer i : list)
            System.out.printf("%d ", i);

    }
}
