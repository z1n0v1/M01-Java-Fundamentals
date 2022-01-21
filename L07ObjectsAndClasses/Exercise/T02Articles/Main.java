/*
    https://judge.softuni.org/Contests/Practice/Index/1327#1

    02. Articles

Create an article class with the following properties:
•	Title – a string
•	Content – a string
•	Author – a string
The class should have a constructor and the following methods:
•	Edit (new content) – change the old content with the new one
•	ChangeAuthor (new author) – change the author
•	Rename (new title) – change the title of the article
•	override ToString – print the article in the following format:
"{title} - {content}:{author}"
Write a program that reads an article in the following format "{title}, {content}, {author}".
On the next line, you will get a number n. On the next n lines, you will get one of the following commands:
"Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the final article.

 */

package L07ObjectsAndClasses.Exercise.T02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(",");
        Article article = new Article(inputString[0], inputString[1], inputString[2]);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(":");

            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
            }
        }
        System.out.println(article);
    }
}
