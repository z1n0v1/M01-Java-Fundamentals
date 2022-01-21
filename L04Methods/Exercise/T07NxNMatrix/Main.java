/*
    https://judge.softuni.org/Contests/Practice/Index/1286#6

    07. NxN Matrix

Write a method that receives a single integer n and prints nxn matrix with that number.
 */

package L04Methods.Exercise.T07NxNMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printNxNMatrix(Integer.parseInt(scanner.nextLine()));
    }

    private static void printNxNMatrix(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }
}
