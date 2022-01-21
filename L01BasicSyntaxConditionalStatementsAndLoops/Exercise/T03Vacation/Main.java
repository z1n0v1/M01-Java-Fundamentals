/*
    https://judge.softuni.org/Contests/Practice/Index/1226#2

    03. Vacation

You are given a group of people, type of the group, on which day of the week they are going to stay.
Based on that information calculate how much they have to pay and print that price on the console. Use the table below.
In each cell is the price for a single person. The output should look like that: "Total price: {price}".
The price should be formatted to the second decimal point.

	        Friday	    Saturday	    Sunday
Students	8.45	    9.80	        10.46
Business	10.90	    15.60	        16
Regular	    15	        20	            22.50

There are also discounts based on some conditions:
•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
•	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
•	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%

You should reduce the prices in that EXACT order

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T03Vacation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double pricePerPerson = 0;

        switch (day) {
            case "Friday": {
                switch (groupType) {
                    case "Students": {
                        pricePerPerson = 8.45;
                        break;
                    }

                    case "Business": {
                        pricePerPerson = 10.9;
                        break;
                    }
                    case "Regular": {
                        pricePerPerson = 15;
                        break;
                    }
                }
                break;
            }
            case "Saturday": {
                switch (groupType) {
                    case "Students": {
                        pricePerPerson = 9.8;
                        break;
                    }

                    case "Business": {
                        pricePerPerson = 15.6;
                        break;
                    }
                    case "Regular": {
                        pricePerPerson = 20;
                        break;
                    }

                }
                break;
            }
            case "Sunday": {
                switch (groupType) {
                    case "Students": {
                        pricePerPerson = 10.46;
                        break;
                    }

                    case "Business": {
                        pricePerPerson = 16;
                        break;
                    }
                    case "Regular": {
                        pricePerPerson = 22.5;
                        break;
                    }

                }
                break;
            }
        }

        if (groupType.equals("Students") && numPeople >= 30)
            pricePerPerson *= 0.85;
        else if (groupType.equals("Business") && numPeople >= 100)
            numPeople -= 10;
        else if (groupType.equals("Regular") && numPeople >= 10 && numPeople <= 20)
            pricePerPerson *= 0.95;

        System.out.printf("Total price: %.2f", pricePerPerson * numPeople);

    }
}
