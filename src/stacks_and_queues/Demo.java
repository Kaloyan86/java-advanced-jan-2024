package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class Demo {

    public static void main(String[] args) {

        // Stack - LIFO - Last in First out
        // push(element) - insert element on the top of the stack
        // pop() - remove topmost element
        // peek() - get topmost element

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(36);
        stack.push(25);
        stack.push(12);
        stack.push(10);
        stack.push(40);

        //        System.out.println(stack.peek());
        //        // 40, 10, 12, 25, 36
        //        while (!stack.isEmpty()){
        //            System.out.println(stack.pop());
        //        }


        // Queue - FIFO - First in First out
        // offer(element) - add element at the start of the Queue
        // poll() - remove first element of the Queue
        // peek() - get first element of the Queue

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> newStack = new ArrayDeque<>();

        queue.offer(45);
        queue.offer(32);
        queue.offer(12);
        queue.offer(4);
        queue.offer(5);

        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            System.out.println(element);
            newStack.push(element);
        }

        System.out.println();

        // PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.offer(45);
        priorityQueue.offer(32);
        priorityQueue.offer(12);
        priorityQueue.offer(4);
        priorityQueue.offer(5);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue2.offer("Z");
        priorityQueue2.offer("A");
        priorityQueue2.offer("D");
        priorityQueue2.offer("C");
        priorityQueue2.offer("B");

        while (!priorityQueue2.isEmpty()) {
            System.out.println(priorityQueue2.poll());
        }
        int x = 4;
        int y = 5;
        int res;
        res = (x < y) ? -1 : ((x == y) ? 0 : 1);

//        if (x < y) {
//            res = -1;
//        } else if (x == y) {
//            res = 0;
//        } else {
//            res = -1;
//        }
        System.out.println(res);

    }
}
