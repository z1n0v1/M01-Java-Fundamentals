/*
    https://judge.softuni.org/Contests/Practice/Index/2474#1

    02. Array Modifier

You are given an array with integers. Write a program to modify the elements after receive the commands
“swap”, “multiply” or “decrease”.
•	“swap {index1} {index2}” take two elements and swap their places.
•	“multiply {index1} {index2}” take element at the 1st index and multiply it with element at 2nd index.
Save the product at the 1st index.
•	“decrease” decreases all elements in the array with 1.
Input
On the first input line you will be given the initial array values separated by a single space.
On the next lines you will receive commands until you receive the command “end”. The commands are as follow:
•	“swap {index1} {index2}”
•	“multiply {index1} {index2}”
•	“decrease”
Output
The output should be printed on the console and consist element of the modified array – separated by “, “(comma and single space).
Constraints
•	Commands will be: “swap”, “multiply”, “decrease” and “end”
•	Elements of the array will be integer numbers in the range [-231...231]
•	Count of the array elements will be in the range [2...100]
•	Indexes will be always in the range of the array
 */

package Exam.E02MidExam.T02ArrayModifier;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            switch (data[0]) {
                case "swap": {
                    int i1 = Integer.parseInt(data[1]);
                    int i2 = Integer.parseInt(data[2]);
                    int temp = array[i1];
                    array[i1] = array[i2];
                    array[i2] = temp;
                    break;
                }
                case "multiply": {
                    int i1 = Integer.parseInt(data[1]);
                    int i2 = Integer.parseInt(data[2]);
                    array[i1] *= array[i2];
                    break;
                }
                case "decrease": {
                    for (int i = 0; i < array.length; i++) {
                        array[i] -= 1;
                    }
                    break;
                }
            }
//            System.out.println(Arrays.toString(array) + input);
            input = scanner.nextLine();
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d%n", array[array.length - 1]);
    }
}
