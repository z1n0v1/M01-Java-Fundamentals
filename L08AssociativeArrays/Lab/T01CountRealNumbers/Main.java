/*
    https://judge.softuni.org/Contests/Practice/Index/1311#0

    01. Count Real Numbers

Read a list of real numbers and print them in ascending order along with their number of occurrences.
 */

package L08AssociativeArrays.Lab.T01CountRealNumbers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (double number : numbers) {
            if (!counts.containsKey(number)) {
                counts.put(number, 1);
            } else {
                counts.put(number, counts.get(number) + 1);
            }
        }

        DecimalFormat df = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : counts.entrySet())
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
    }
}
