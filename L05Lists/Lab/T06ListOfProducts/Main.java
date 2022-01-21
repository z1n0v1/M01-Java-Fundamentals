/*
    https://judge.softuni.org/Contests/Practice/Index/1295#5

    06. List of Products

Read a number n and n lines of products. Print a numbered list of all the products ordered by name.
 */

package L05Lists.Lab.T06ListOfProducts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();

        int numProducts = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numProducts; i++) {
            products.add(scanner.nextLine());
        }

        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n",i + 1,products.get(i));
        }
    }
}
