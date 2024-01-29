package functional_programming;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class P7FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallestNumber = Collections::min;

    }
}
