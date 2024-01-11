package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        // Add elements to the stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .forEach(stack::push);

//        Integer[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
//                                .map(Integer::parseInt)
//                                .toArray(Integer[]::new);
//        for (Integer el : input) {
//            stack.push(el);
//        }

        // Remove elements from the stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
