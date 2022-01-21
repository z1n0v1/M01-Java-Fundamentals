/*
    https://judge.softuni.org/Contests/Practice/Index/1297#7

    08. Anonymous Threat

The Anonymous have created a cyber hypervirus which steals data from the CIA.
You, as the lead security developer in CIA, have been tasked to analyze the software of the virus
and observe its actions on the data. The virus is known for his innovative and unbelievably clever technique
of merging and dividing data into partitions.

You will receive a single input line containing STRINGS separated by spaces.
The strings may contain any ASCII character except whitespace.

You will then begin receiving commands in one of the following formats:
•	merge {startIndex} {endIndex}
•	divide {index} {partitions}
Every time you receive the merge command, you must merge all elements from the startIndex till the endIndex.
In other words, you should concatenate them.

Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}

If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
Every time you receive the divide command, you must DIVIDE the element at the given index into several small substrings
with equal length. The count of the substrings should be equal to the given partitions.
Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}

If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS,
and make the LAST one – the LONGEST.
Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}

The input ends when you receive the command "3:1". At that point you must print the resulting elements, joined by a space.

Input
•	The first input line will contain the array of data
•	On the next several input lines you will receive commands in the format specified above
•	The input ends when you receive the command "3:1"

Output
•	As output you must print a single line containing the elements of the array, joined by a space.

Constrains
•	The strings in the array may contain any ASCII character except whitespace
•	The startIndex and the endIndex will be in range [-1000, 1000]
•	The endIndex will ALWAYS be GREATER than the startIndex
•	The index in the divide command will ALWAYS be INSIDE the array
•	The partitions will be in range [0, 100]
•	Allowed working time/memory: 100ms / 16MB
 */

package L05Lists.Exercise.T08AnonymousThreat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<String> strings;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] command = input.split(" ");
            if (command[0].equals("merge")) {
                int fromIndex = Integer.parseInt(command[1]);
                int toIndex = Integer.parseInt(command[2]);

                merge(fromIndex, toIndex);
            } else {
                int fromIndex = Integer.parseInt(command[1]);
                int partitions = Integer.parseInt(command[2]);

                divide(fromIndex, partitions);
            }
            input = scanner.nextLine();
        }
        for (String str : strings)
            System.out.printf("%s ", str);
    }

    private static void divide(int index, int partitions) {
        if (index < 0) index = 0;

        String[] divided = new String[partitions];
        String toBeDivided = strings.get(index);
        strings.remove(index);
        int divideBy = toBeDivided.length() / partitions;
        int tempIndex = 0;
        for (int i = 0; i < partitions - 1; i++) {
            String partition = toBeDivided.substring(tempIndex, tempIndex + divideBy);
            tempIndex += divideBy;
            divided[i] = partition;
        }
        divided[partitions - 1] = toBeDivided.substring(tempIndex);
        for (int i = 0; i < divided.length; i++) {
            strings.add(index + i, divided[i]);
        }
    }

    private static void merge(int startIndex, int endIndex) {

        if (startIndex < 0) startIndex = 0;
        if (startIndex >= strings.size()) startIndex = strings.size() - 1;
        if (endIndex < 1) return;
        if (endIndex >= strings.size()) endIndex = strings.size() - 1;

        int numToMerge = endIndex - startIndex;
        String merged = "";

        for (int i = 0; i <= numToMerge; i++) {
            merged += strings.get(startIndex);
            strings.remove(startIndex);
        }
        if (merged.length() > 0)
            strings.add(startIndex, merged);
    }
}
