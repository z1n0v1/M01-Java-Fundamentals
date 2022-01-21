/*
    https://judge.softuni.org/Contests/Practice/Index/1311#1

    02. Word Synonyms

Write a program which keeps a map with synonyms. The key of the map will be the word.
The value will be a list of all the synonyms of that word. You will be given a number n.
On the next 2 * n lines you will be given a word and a synonym each on a separate line like this:
•	{word}
•	{synonym}
If you get the same word for second time, just add the new synonym to the list.
Print the words in the following format:
{word} - {synonym1, synonym2… synonymN}

Hints
•	Use LinkedHashMap (String -> ArrayList<String>) to keep track of all words
•	Read 2 * n lines
•	Add the word in the Map if it is not present
•	Add the synonym as value to the given word
•	Print each word with the synonyms in the required format specified above

 */

package L08AssociativeArrays.Lab.T02WordSynonyms;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> synonyms = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonyms.containsKey(word)) {
                List<String> synonymList = new ArrayList<>();
                synonymList.add(synonym);
                synonyms.put(word,synonymList);
            } else {
                synonyms.get(word).add(synonym);
            }
        }

        for (Map.Entry<String,List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            List<String> synonymList = entry.getValue();
            for (int i = 0; i < synonymList.size(); i++) {
                System.out.printf("%s",synonymList.get(i));
                if(i == synonymList.size() - 1) {
                    System.out.println();
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
}
