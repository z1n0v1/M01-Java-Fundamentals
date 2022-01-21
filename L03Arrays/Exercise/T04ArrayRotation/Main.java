/*
    https://judge.softuni.org/Contests/Practice/Index/1247#3

    04. Array Rotation

Write a program that receives an array and number of rotations you have to perform (first element goes at the end)
Print the resulting array.
 */

package L03Arrays.Exercise.T04ArrayRotation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] array = scanner.nextLine().split(" ");
        int numRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numRotations; i++) {
            String rotate = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j+1];
            }
            array[array.length-1] = rotate;
        }
        System.out.println(String.join(" ", array));
    }
}
