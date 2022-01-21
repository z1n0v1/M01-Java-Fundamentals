/*
    https://judge.softuni.org/Contests/Practice/Index/1295#4

    05. List Manipulation Advanced

Now we will implement more complicated list commands. Again, read a list, and until you receive "end" read commands:
Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"

Print even – print all the numbers that are even separated by a space
Print odd – print all the numbers that are odd separated by a space
Get sum – print the sum of all the numbers

Filter ({condition} {number}) – print all the numbers that fulfill that condition.
The condition will be either '<', '>', ">=", "<="

 */

package L05Lists.Lab.T05ListManipulationAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandString = scanner.nextLine();

        while (!commandString.equals("end")) {
            String[] command = commandString.split(" ");

            switch (command[0]) {

                case "Contains":
                    if(list.contains(Integer.parseInt(command[1])))
                        System.out.println("Yes");
                    else System.out.println("No such number");
                    break;
                case "Print":
                    if(command[1].equals("even"))
                        printEven();
                    else printOdd();
                    break;
                case "Get":
                    System.out.println(getSum());
                    break;
                case "Filter":
                    if (command[1].equals(">="))
                        printBiggerOrEqual(Integer.parseInt(command[2]));
                    else if (command[1].equals(">"))
                        printBigger(Integer.parseInt(command[2]));
                    else if (command[1].equals("<"))
                        printSmaller(Integer.parseInt(command[2]));
                    else if (command[1].equals("<="))
                        printSmallerOrEqual(Integer.parseInt(command[2]));
                    break;
            }

            commandString = scanner.nextLine();
        }
    }

    private static void printSmaller(int num) {
        for (Integer e : list)
            if (e < num)
                System.out.printf("%d ", e);
        System.out.println();
    }

    private static void printBigger(int num) {
        for (Integer e : list)
            if (e > num)
                System.out.printf("%d ", e);
        System.out.println();
    }

    private static void printBiggerOrEqual(int num) {
        for (Integer e : list)
            if (e >= num)
                System.out.printf("%d ", e);
        System.out.println();
    }

    private static void printSmallerOrEqual(int num) {
        for (Integer e : list)
            if (e <= num)
                System.out.printf("%d ", e);
        System.out.println();
    }

    private static int getSum() {
        int sum = 0;
        for (int e : list)
            sum+=e;
        return sum;
    }

    private static void printEven() {
        for (Integer e : list)
            if (e % 2 == 0)
                System.out.printf("%d ", e);
        System.out.println();
    }

    private static void printOdd() {
        for (Integer e : list)
            if (e % 2 == 1)
                System.out.printf("%d ", e);
        System.out.println();
    }
}
