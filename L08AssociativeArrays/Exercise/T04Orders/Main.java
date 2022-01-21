/*
    https://judge.softuni.org/Contests/Practice/Index/1312#3

    04. Orders

Write a program, which keeps information about products and their prices. Each product has a name, a price and its quantity.
If the product doesn't exist yet, add it with its starting quantity.
If you receive a product, which already exists, increase its quantity by the input quantity and if its price is different,
replace the price as well.
You will receive products' names, prices and quantities on new lines.
Until you receive the command "buy", keep adding items. When you do receive the command "buy",
print the items with their names and total price of all the products with that name.

Input
•	Until you receive "buy", the products come in the format: "{name} {price} {quantity}"
•	The product data is always delimited by a single space

Output
•	Print information about each product, following the format:
"{productName} -> {totalPrice}"
•	Format the average grade to the 2nd decimal place

 */

package L08AssociativeArrays.Exercise.T04Orders;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class Product {
        private double price;
        private int quantity;

        public Product(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getTotalPrice() {
            return price*quantity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] data = input.split("\\s+");
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if(products.containsKey(data[0])) {
                Product product = products.get(data[0]);

                if(product.getPrice() != price)
                    product.setPrice(price);
                product.setQuantity(product.getQuantity() + quantity);
            } else {
                products.put(data[0], new Product(price, quantity));
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue().getTotalPrice());
        }

    }
}
