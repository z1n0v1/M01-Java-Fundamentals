/*
    https://judge.softuni.org/Contests/Practice/Index/1327#3

    04. Articles 2.0

Change the program from the second problem, so you can store a list of articles.
You will not need the methods anymore (except the ToString method). On the first line, you will get a number n.
On the next n lines, you will get some articles in the same format as the previous task ("{title}, {content}, {author}").
Finally, you will get one of the three inputs: "title", "content", "author".
You need to order the articles alphabetically based on the command and print them sorted by the given criteria.
 */

package L07ObjectsAndClasses.Exercise.T04Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputString = scanner.nextLine().split(",");
            Article article = new Article(inputString[0],inputString[1],inputString[2]);
            articles.add(article);
        }

        switch (scanner.nextLine()) {
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
        }
        for (Article article : articles)
            System.out.println(article);


    }
}
