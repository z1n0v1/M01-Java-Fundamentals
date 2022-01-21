/*
        https://judge.softuni.org/Contests/Practice/Index/2525#2

        03. The Pianist

You are a pianist and you like to keep a list of your favorite piano pieces.
Create a program, to help you organize it and add, change, remove pieces from it!
On the first line of the standard input you will receive an integer n – the number of pieces that you will initially have.
On the next n lines the pieces themselves will follow with their composer and key, separated by "|" in the following format:
{piece}|{composer}|{key}
Then, you will be receiving different commands, each on a new line, separated by "|", until the "Stop" command is given:
•	Add|{piece}|{composer}|{key}
o	You need to add the given piece with the information about it to the other pieces
o	If the piece is already in the collection, print:
"{piece} is already in the collection!"
o	If the piece is not in the collection, print:
"{piece} by {composer} in {key} added to the collection!"
•	Remove|{piece}
o	If the piece is in the collection, remove it and print:
"Successfully removed {piece}!"
o	If the piece is not in the collection, print:
"Invalid operation! {piece} does not exist in the collection."
•	ChangeKey|{piece}|{new key}
o	If the piece is in the collection, change its key with the given one and print:
"Changed the key of {piece} to {new key}!"
o	If the piece is not in the collection, print:
"Invalid operation! {piece} does not exist in the collection."
Upon receiving the "Stop" command you need to print all pieces in your collection,
sorted by their name and by the name of their composer in alphabetical order, in the following format:
"{Piece} -> Composer: {composer}, Key: {key}"
Input/Constraints
•	You will receive a single integer at first – the initial number of pieces in the collection
•	For each piece you will receive a single line of text with information about it.
•	Then you will receive multiple commands in the way described above, until the command "Stop".
Output
•	All the output messages with the appropriate formats are described in the problem description.

 */

package Exam.E01Final.T03ThePianist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    static class Piece {
        String name, composer, key;

        public Piece(String name, String compositor, String key) {
            this.name = name;
            this.composer = compositor;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String toString() {
            return String.format("%s -> Composer: %s, Key: %s", name, composer, key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Piece> pieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            if (!pieces.containsKey(data[0]))
                pieces.put(data[0], new Piece(data[0], data[1], data[2]));
            else System.out.printf("%s is already in the collection!%n", data[0]);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {

            String[] data = input.split("\\|");

            switch (data[0]) {
                case "Add": {
                    if (pieces.containsKey(data[1])) {
                        System.out.printf("%s is already in the collection!%n", data[1]);
                    } else {
                        pieces.put(data[1], new Piece(data[1], data[2], data[3]));
                        System.out.printf("%s by %s in %s added to the collection!%n", data[1], data[2], data[3]);
                    }
                    break;
                }
                case "Remove": {
                    if (!pieces.containsKey(data[1])) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", data[1]);
                    } else {
                        pieces.remove(data[1]);
                        System.out.printf("Successfully removed %s!%n", data[1]);
                    }
                    break;
                }
                case "ChangeKey": {
                    if(!pieces.containsKey(data[1])) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", data[1]);
                    } else {
                        pieces.get(data[1]).setKey(data[2]);
                        System.out.printf("Changed the key of %s to %s!%n", data[1], data[2]);
                    }
                    break;
                }
            }

            input = scanner.nextLine();
        }

        pieces.values().stream().sorted((a, b) -> {
            if(a.getName().equals(b.getName())) {
                return a.getComposer().compareTo(b.getComposer());
            }
            return a.getName().compareTo(b.getName());
        }).forEach(System.out::println);


    }
}
