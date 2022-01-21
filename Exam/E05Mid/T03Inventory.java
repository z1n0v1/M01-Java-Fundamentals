package Exam.E05Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] data = input.split(" - ");

            switch (data[0]) {
                case "Collect": {
                    if(!items.contains(data[1]))
                        items.add(data[1]);
                    break;
                }
                case "Drop": {
                    if(items.contains(data[1]))
                        items.remove(data[1]);
                    break;
                }
                case "Combine Items": {
                    String[] item = data[1].split(":");
                    if(items.contains(item[0])) {
                        items.add(items.indexOf(item[0]) + 1, item[1]);
                    }
                    break;
                }
                case "Renew": {
                    if(items.contains(data[1])) {
                        items.remove(data[1]);
                        items.add(data[1]);
                    }
                    break;
                }
            }
            input = scanner.nextLine();
        }
        for (int index = 0; index < items.size() - 1; index++) {
            System.out.printf("%s, ",items.get(index));
        }
        System.out.println(items.get(items.size() - 1));
    }
}
