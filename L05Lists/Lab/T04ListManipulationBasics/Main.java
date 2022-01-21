/*
    https://judge.softuni.org/Contests/Practice/Index/1295#3

    04. List Manipulation Basics

Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:

Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!

When you receive the "end" command print the final state of the list (separated by spaces)
 */

package L05Lists.Lab.T04ListManipulationBasics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandString = scanner.nextLine();

        while (!commandString.equals("end")) {

            String[] command = commandString.split(" ");

            switch (command[0]) {

                case "Add" :
                    list.add(Integer.parseInt(command[1]));
                    break;

                case "Remove":
                    list.remove(Integer.valueOf(Integer.parseInt(command[1])));
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(command[2]),Integer.parseInt(command[1]));
                    break;
            }

            commandString = scanner.nextLine();
        }
        for (Integer e : list)
            System.out.printf("%d ", e);
    }
}
