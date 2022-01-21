/*
    https://judge.softuni.org/Contests/Practice/Index/1297#1

    02. Change List

Write a program, which reads a list of integers from the console and receives commands, which manipulate the list.
Your program may receive the following commands:
•	Delete {element} - delete all elements in the array, which are equal to the given element
•	Insert {element} {position} - insert element at the given position

You should stop the program when you receive the command "end".
Print all numbers in the array separated with a single whitespace.
 */

package L05Lists.Exercise.T02ChangeList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

            String[] cmd = commandString.split(" ");

            if (cmd[0].equals("Delete"))
                list.removeIf(e -> Objects.equals(Integer.parseInt(cmd[1]), e));
            else list.add(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[1]));

            commandString = scanner.nextLine();
        }
        for (Integer e : list)
            System.out.printf("%d ", e);
    }
}
