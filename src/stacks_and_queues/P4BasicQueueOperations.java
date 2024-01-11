package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P4BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        int n = tokens[0];
        int s = tokens[1];
        int x = tokens[2];

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .mapToInt(Integer::parseInt)
              .forEach(queue::offer);

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
