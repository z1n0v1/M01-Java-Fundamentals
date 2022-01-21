/*
    https://judge.softuni.org/Contests/Practice/Index/1308#0

    01. Messaging

You will be given some list of numbers and a string.
For each element of the list you have to take the sum of its digits and take the element corresponding to that index from the text.
If the index is greater than the length of the text, start counting from the beginning (so that you always have a valid index).
After getting the element from the text, you have to remove the character you have taken from it (so for the next index,
the text will be with one character less).
 */

package L05Lists.Exercise.More.T01Messaging;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        StringBuilder string = new StringBuilder(scanner.nextLine()),
                message = new StringBuilder();

        for (Integer number : numbers) {
            int index = getDigitsSum(number) % string.length();
            message.append(string.charAt(index));
            string.deleteCharAt(index);
        }
        System.out.println(message);
    }
    private static int getDigitsSum(int element) {
        int sum = 0;
        while (element > 0) {
            sum+= element % 10;
            element/=10;
        }
        return sum;
    }
}
