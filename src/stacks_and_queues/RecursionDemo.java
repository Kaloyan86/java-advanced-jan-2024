package stacks_and_queues;

public class RecursionDemo {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        A(0);
    }

    private static void A (int count){
        if (count == 10){
            return;
        }
        System.out.println(count++);
        A(count);
    }
}
