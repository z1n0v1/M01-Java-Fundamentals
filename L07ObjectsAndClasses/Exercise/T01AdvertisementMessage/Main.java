/*
    https://judge.softuni.org/Contests/Practice/Index/1327#0

    01. Advertisement Message

Write a program that generates random fake advertisement message to extol some product.
The messages must consist of 4 parts: laudatory phrase + event + author + city. Use the following predefined parts:
•	Phrases – {"Excellent product.", "Such a great product.", "I always use that product.",
    "Best product of its category.", "Exceptional product.", "I can’t live without this product."}
•	Events – {"Now I feel good.", "I have succeeded with this product.",
    "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
    "Try it yourself, I am very satisfied.", "I feel great!"}
•	Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
•	Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
The format of the output message is: {phrase} {event} {author} – {city}.
As an input, you take the number of messages to be generated. Print each random message on a separate line.

 */

package L07ObjectsAndClasses.Exercise.T01AdvertisementMessage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberMessages = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberMessages; i++) {
            System.out.println(generateRandomMessage());
        }
    }

    private static String generateRandomMessage() {
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        return phrases[rnd.nextInt(phrases.length)] + " " + events[rnd.nextInt(events.length)]
                + " " + authors[rnd.nextInt(authors.length)] + " – " + cities[rnd.nextInt(cities.length)];
    }
}
