/*
    https://judge.softuni.org/Contests/Practice/Index/1286#10

    11. Array Manipulator

Trifon has finally become a junior developer and has received his first task.
It's about manipulating an array of integers. He is not quite happy about it, since he hates manipulating arrays.
They are going to pay him a lot of money, though, and he is willing to give somebody half of it if to help him do his job.
You, on the other hand, love arrays (and money) so you decide to try your luck.

The array may be manipulated by one of the following commands:
•	exchange {index} – splits the array after the given index and exchanges the places of the two resulting subarrays.
E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]

o	If the index is outside the boundaries of the array, print "Invalid index".
•	max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
•	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
o	If there are two or more equal min/max elements, return the index of the rightmost one.
o	If a min/max even/odd element cannot be found, print "No matches".
•	first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
•	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
o	If the count is greater than the array length, print "Invalid count".
o	If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements,
print an empty array "[]".
•	end – stop taking input and print the final state of the array.

Input
•	The input data should be read from the console.
•	On the first line, the initial array is received as a line of integers, separated by a single space.
•	On the next lines, until the command "end" is received, you will receive the array manipulation commands.
•	The input data will always be valid and in the format described. There is no need to check it explicitly.

Output
•	The output should be printed on the console.
•	On a separate line, print the output of the corresponding command
•	On the last line, print the final array in square brackets with its elements separated by a comma and a space
•	See the examples below to get a better understanding of your task

Constraints
•	The number of input lines will be in the range [2 … 50].
•	The array elements will be integers in the range [0 … 1000].
•	The number of elements will be in the range [1 ... 50]
•	The split index will be an integer in the range [-231 … 231 – 1]
•	first/last count will be an integer in the range [1 … 231 – 1]
•	There will not be redundant whitespace anywhere in the input
•	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.

 */

package L04Methods.Exercise.T11ArrayManipulator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] array;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String [] task = command.split(" ");

            switch (task[0]) {
                case "exchange" : {
                    int index = Integer.parseInt(task[1]);
                    if (index < 0 || index > (array.length - 1))
                        System.out.println("Invalid index");
                    else exchange(index);
                    break;
                }
                case "max" : {
                    int extremeIndex = -1;
                    if (task[1].equals("odd")) {
                        extremeIndex = maxOdd();
                    } else { // even
                        extremeIndex = maxEven();
                    }
                    if(extremeIndex == -1)
                        System.out.println("No matches");
                    else System.out.println(extremeIndex);
                    break;
                }
                case "min" : {
                    int extremeIndex = -1;
                    if (task[1].equals("odd")) {
                        extremeIndex = minOdd();
                    } else { // even
                        extremeIndex = minEven();
                    }
                    if(extremeIndex == -1)
                        System.out.println("No matches");
                    else System.out.println(extremeIndex);
                    break;
                }
                case "first" : {
                    int count = Integer.parseInt(task[1]);
                    if (count > array.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (task[2].equals("even"))
                        System.out.println(Arrays.toString(firstEven(count)));
                    else  System.out.println(Arrays.toString(firstOdd(count)));
                    break;
                }
                case "last" : {
                    int count = Integer.parseInt(task[1]);
                    if (count > array.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (task[2].equals("even"))
                        System.out.println(Arrays.toString(lastEven(count)));
                    else  System.out.println(Arrays.toString(lastOdd(count)));
                    break;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] lastOdd(int count) {
        int [] tempArray = new int[array.length];
        int numElements = 0;
        for (int i = array.length -1; i >= 0; i--) {
            if(array[i] % 2 == 1) {
                tempArray[numElements] = array[i];
                numElements++;
                if(numElements >= count) break;
            }
        }
        int [] firstEvenArray = new int[numElements];
        for (int i = numElements-1; i >= 0; i--) {
            firstEvenArray[numElements-i-1] = tempArray[i];
        }
        return firstEvenArray;

    }

    private static int[] lastEven(int count) {
        int [] tempArray = new int[array.length];
        int numElements = 0;
        for (int i = array.length -1; i >= 0; i--) {
            if(array[i] % 2 == 0) {
                tempArray[numElements] = array[i];
                numElements++;
                if(numElements >= count) break;
            }
        }
        int [] firstEvenArray = new int[numElements];
        for (int i = numElements-1; i >= 0; i--) {
            firstEvenArray[numElements-i-1] = tempArray[i];
        }
        return firstEvenArray;
    }

    private static int[] firstOdd(int count) {
        int [] tempArray = new int[array.length];
        int numElements = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
                tempArray[numElements] = array[i];
                numElements++;
                if(numElements >= count) break;
            }
        }
        int [] firstEvenArray = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            firstEvenArray[i] = tempArray[i];
        }
        return firstEvenArray;
    }

    private static int[] firstEven(int count) {
        int [] tempArray = new int[array.length];
        int numElements = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                tempArray[numElements] = array[i];
                numElements++;
                if(numElements >= count) break;
            }
        }
        int [] firstEvenArray = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            firstEvenArray[i] = tempArray[i];
        }
        return firstEvenArray;
    }

    private static int maxEven() {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= maxEven && (array[i] % 2 == 0)) {
                maxEven = array[i];
                maxEvenIndex = i;
            }
        }
        return maxEvenIndex;
    }

    private static int minEven() {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= minEven  && (array[i] % 2 == 0)) {
                minEven = array[i];
                minEvenIndex = i;
            }
        }
        return minEvenIndex;
    }

    private static int maxOdd() {
        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= maxOdd  && (array[i] % 2 == 1)) {
                maxOdd = array[i];
                maxOddIndex = i;
            }
        }
        return maxOddIndex;
    }

    private static int minOdd() {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= minOdd  && (array[i] % 2 == 1)) {
                minOdd = array[i];
                minOddIndex = i;
            }
        }
        return minOddIndex;
    }

    private static void exchange(int index) {
        int [] newArray = new int[array.length];
        int newPlace = 0;
        for (int i = index + 1; i < array.length; i++) {
            newArray[newPlace] = array[i];
            newPlace++;
        }
        for (int i = 0; i <= index; i++) {
            newArray[newPlace] = array[i];
            newPlace++;
        }
        array = newArray;
    }
}
