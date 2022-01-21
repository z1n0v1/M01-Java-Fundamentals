/*
    https://judge.softuni.org/Contests/Practice/Index/1247#8

    09. Kamino Factory

The clone factory in Kamino got another order to clone troops.
But this time you are tasked to find the best DNA sequence to use in the production.

You will receive the DNA length and until you receive the command "Clone them!" you will be receiving a DNA sequences
of ones and zeroes, split by "!" (one or several).

You should select the sequence with the longest subsequence of ones. If there are several sequences
with same length of subsequence of ones, print the one with the leftmost starting index,
if there are several sequences with same length and starting index, select the sequence with the greater sum of its elements.

After you receive the last command "Clone them!" you should print the collected information in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"

Input / Constraints
•	The first line holds the length of the sequences – integer in range [1…100];
•	On the next lines until you receive "Clone them!" you will be receiving sequences (at least one) of ones and zeroes,
split by "!" (one or several).

 Output
The output should be printed on the console and consists of two lines in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"

 */

package L03Arrays.Exercise.T09KaminoFactory;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());

        int[] bestSequence = new int[sequenceLength];
        int bestSequenceIndex = 1, bestSequenceLength = 0,
                leftmostIndex = Integer.MAX_VALUE, sequenceIndex = 0,
                bestSequenceSum = 0;
        String sequence = scanner.nextLine();

        while (!sequence.equals("Clone them!")) {

            int[] currentSequence = Arrays.stream(sequence.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            sequenceIndex++;
            int currentSequenceLength = 0, currentSequenceSum = 0;
            int currentLeftmostIndex = Integer.MAX_VALUE;
            int tempLength = 0, tempIndexStart = Integer.MAX_VALUE;

            for (int index = 0; index < sequenceLength; index++) {
                if (currentSequence[index] == 1) {
                    if (tempLength == 0)
                        tempIndexStart = index;
                    tempLength++;
                    currentSequenceSum++;
                    if (tempLength > currentSequenceLength) {
                        currentLeftmostIndex = tempIndexStart;
                        currentSequenceLength = tempLength;
                    }

                } else {
                    tempLength = 0;
                }

            }

            if ((bestSequenceLength < currentSequenceLength)
                    || (bestSequenceLength == currentSequenceLength
                    && leftmostIndex > currentLeftmostIndex)
                    || (bestSequenceLength == currentSequenceLength
                    && leftmostIndex == currentLeftmostIndex
                    && currentSequenceSum > bestSequenceSum)
            ) {

                bestSequenceLength = currentSequenceLength;
                leftmostIndex = currentLeftmostIndex;
                bestSequence = currentSequence;
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = currentSequenceSum;
            }
            sequence = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int seq : bestSequence) {
            System.out.printf("%d ", seq);
        }

    }
}
