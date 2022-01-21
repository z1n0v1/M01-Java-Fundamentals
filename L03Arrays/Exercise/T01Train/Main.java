/*
    https://judge.softuni.org/Contests/Practice/Index/1247#0

    01. Train

You will be given a count of wagons in a train n. On the next n lines,
you will receive how many people are going to get on that wagon.
At the end print the whole train and after that the sum of the people in the train.
 */

package L03Arrays.Exercise.T01Train;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numWagons = Integer.parseInt(scanner.nextLine());
        int[] wagons = new int[numWagons];

        int people = 0;
        for (int i = 0; i < wagons.length; i++) {
            wagons[i] = Integer.parseInt(scanner.nextLine());
            people += wagons[i];
            System.out.printf("%d ", wagons[i]);
        }
        System.out.println();
        System.out.println(people);
    }
}
