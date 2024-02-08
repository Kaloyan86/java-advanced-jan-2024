package iterators_and_comparators.stack_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StackIterator stackIterator = new StackIterator();

        while (!"END".equals(line)) {

            String[] tokens = line.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Push":
                    Arrays.stream(line.split("[\\s,]+"))
                          .skip(1)
                          .map(Integer::parseInt)
                          .forEach(stackIterator::push);
                    break;
                case "Pop":
                    try {
                        stackIterator.pop();
                    } catch (IllegalStateException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

            }

            line = scanner.nextLine();
        }

        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);

    }
}
