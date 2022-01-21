/*
    https://judge.softuni.org/Contests/Practice/Index/1674#4

    05. HTML

You will receive 3 lines of input. On the first line you will receive a title of an article.
On the next line you will receive the content of that article.
On the next n lines until you receive "end of comments" you will get the comments about the article.
Print the whole information in html format.
The title should be in "h1" tag (<h1></h1>); the content in article tag (<article></article>);
each comment should be in div tag (<div></div>). For more clarification see the example below

Input:
SoftUni Article
Some content of the SoftUni article
some comment
more comment
last comment
end of comments

Output :
<h1>
    SoftUni Article
</h1>
<article>
    Some content of the SoftUni article
</article>
<div>
    some comment
</div>
<div>
    more comment
</div>
<div>
    last comment
</div>


 */

package L09TextProcessing.Exercise.More.T05HTML;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle(scanner.nextLine());
        printArticle(scanner.nextLine());

        String comment = scanner.nextLine();

        while (!comment.equals("end of comments")) {
            printComment(comment);
            comment = scanner.nextLine();
        }


    }

    private static void printComment(String comment) {
        System.out.println("<div>");
        System.out.println("    " + comment);
        System.out.println("</div>");
    }

    private static void printArticle(String article) {
        System.out.println("<article>");
        System.out.println("    " + article);
        System.out.println("</article>");
    }

    private static void printTitle(String title) {
        System.out.println("<h1>");
        System.out.println("    " + title);
        System.out.println("</h1>");
    }
}
