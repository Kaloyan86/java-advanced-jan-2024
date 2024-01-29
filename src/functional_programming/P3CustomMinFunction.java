package functional_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P3CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNumber =
        arr -> Arrays.stream(arr).min(Integer::compareTo).get();


        Function<Integer[], Integer> findSmallestNumber2 =
        arr -> {
            int minNumber = Integer.MAX_VALUE;

            for (int number : arr) {
                if (minNumber > number) {
                    minNumber = number;
                }
            }
            return minNumber;
        };

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                  .map(Integer::parseInt)
                                  .toArray(Integer[]::new);

        System.out.println(findSmallestNumber.apply(numbers));
    }
}
