package L05Lists.Exercise.T06CardsGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstDeck.size()>0 && secondDeck.size() > 0) {
            Integer card1 = firstDeck.get(0);
            Integer card2 = secondDeck.get(0);

            if(card1 > card2) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                firstDeck.add(firstDeck.size(), card1);
                firstDeck.add(firstDeck.size(), card2);
            } else if (card1 < card2) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                secondDeck.add(secondDeck.size(), card2);
                secondDeck.add(secondDeck.size(), card1);
            } else {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }
        if(firstDeck.size() > 0) {
            int sum = 0;
            for (Integer card : firstDeck) sum+= card;
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (Integer card : secondDeck) sum+= card;
            System.out.printf("Second player wins! Sum: %d", sum);

        }
    }
}
