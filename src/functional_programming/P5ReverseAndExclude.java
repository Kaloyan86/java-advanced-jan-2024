package functional_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> notDivisibleByN = number -> number % n != 0;

        Collections.reverse(numbers);

        // 1 2 3 4 5 6
        numbers.stream()
               .filter(notDivisibleByN)
               .forEach(num -> System.out.print(num + " "));
    }
}
