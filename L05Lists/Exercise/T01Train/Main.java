/*
    https://judge.softuni.org/Contests/Practice/Index/1297#0

    01. Train

On the first line you will be given a list of wagons (integers).
Each integer represents the number of passengers that are currently in each wagon.
On the next line you will get the max capacity of each wagon (single integer).
Until you receive "end" you will be given two types of input:
•	Add {passengers} - add a wagon to the end with the given number of passengers
•	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
At the end print the final state of the train (all the wagons separated by a space)
 */

package L05Lists.Exercise.T01Train;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> wagons;
    static int maxPassengers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        maxPassengers = Integer.parseInt(scanner.nextLine());

        String cmdString = scanner.nextLine();

        while (!cmdString.equals("end")) {
            String[] cmd = cmdString.split(" ");

            if (cmd[0].equals("Add"))
                addWagon(Integer.parseInt(cmd[1]));
            else addPassengers(Integer.parseInt(cmd[0]));

            cmdString = scanner.nextLine();
        }

        for (Integer wagon : wagons)
            System.out.printf("%d ", wagon);
    }

    private static void addPassengers(int numPassengers) {
        for (int i = 0; i < wagons.size(); i++) {
            Integer passengers = wagons.get(i);
            if ( maxPassengers >= (passengers + numPassengers)) {
                wagons.set(i, passengers + numPassengers);
                break;
            }
        }

    }

    private static void addWagon(int numPassengers) {
        wagons.add(Integer.valueOf(numPassengers));
    }
}
