package stacks_and_queues;

import java.util.Scanner;

public class P6RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        long result = fib(n);

        System.out.println(result);
    }

    private static long fib(int n) {
      long[] memory2 =  new long[n + 1];
        // 0 1  2  3   4   5   6   7   8     9     10
        // 1, 1, 2, 3, 5, 8, 13,  21,  34,   55,   89
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] = fib(n - 1) + fib(n - 2);
        return memory[n];
    }
}
