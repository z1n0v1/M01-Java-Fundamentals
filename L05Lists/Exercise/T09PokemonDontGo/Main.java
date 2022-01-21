/*
    https://judge.softuni.org/Contests/Practice/Index/1297#8

    09. Pokemon Don't Go

Ely likes to play Pokemon Go a lot. But Pokemon Go bankrupted… So, the developers made Pokemon Don't Go out of depression.
And so, Ely now plays Pokemon Don't Go. In Pokemon Don't Go, when you walk to a certain pokemon, those closer to you,
naturally get further, and those further from you, get closer.

You will receive a sequence of integers, separated by spaces - the distances to the pokemons.
Then you will begin receiving integers, which will correspond to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence (as if you've captured the pokemon).
•	You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed element,
    with the value of the removed element.
•	You must DECREASE the value of all elements in the sequence which are GREATER than the removed element,
    with the value of the removed element.

If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence,
and COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element, whose value you should use,
is the REMOVED element.

The program ends when the sequence has no elements (there are no pokemons left for Ely to catch).

Input
•	On the first line of input you will receive a sequence of integers, separated by spaces
•	On the next several lines you will receive integers – the indexes

Output
•	When the program ends, you must print on the console, the summed up value of all REMOVED elements

Constrains
•	The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647]
 */

package L05Lists.Exercise.T09PokemonDontGo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> pokemonDistances;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        pokemonDistances = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        while (pokemonDistances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0) {
                if (pokemonDistances.size() > 1) {
                    Integer secondPokemon = pokemonDistances.get(pokemonDistances.size() -1);
                    Integer miaPokemon = pokemonDistances.get(0);
                    sum += miaPokemon;
                    pokemonDistances.remove(0);
                    pokemonDistances.add(0, secondPokemon);
                    increaseDecrease(miaPokemon);
                } else sum+= pokemonDistances.get(0);
            } else if (index >= pokemonDistances.size()) {
                if (pokemonDistances.size() > 1) {
                    Integer miaPokemon = pokemonDistances.get(pokemonDistances.size() - 1);
                    sum += miaPokemon;
                    pokemonDistances.remove(pokemonDistances.size() - 1);
                    pokemonDistances.add(pokemonDistances.get(0));
                    increaseDecrease(miaPokemon);
                } else sum+= pokemonDistances.get(0);
            } else {
                int pokemonDistance = pokemonDistances.get(index);
                sum += pokemonDistance;
                pokemonDistances.remove(index);
                increaseDecrease(pokemonDistance);

            }
        }
        System.out.println(sum);
    }
    private static void increaseDecrease (int pokemonDistance) {
        for (int i = 0; i < pokemonDistances.size(); i++) {
            Integer pokemon = pokemonDistances.get(i);
            if (pokemon <= pokemonDistance) {
                pokemonDistances.set(i, pokemon + pokemonDistance);
            } else {
                pokemonDistances.set(i, pokemon - pokemonDistance);
            }
        }
    }
}
