package functional_programming;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Function<InputParam, ReturnType> -> use with apply
        Function<Integer, Integer> powerOf2Func = (a) -> a * a;
        //        System.out.println(powerOf2Func.apply(7));

        //Consumer<InputParam> -> void -> use with accept
        Consumer<Integer> printNumConsumer = a -> System.out.println(a);
        //        printNumConsumer.accept(10);

        //Supplier<ReturnType> -> use with get
        Supplier<Scanner> scannerSupplier = () -> new Scanner(System.in);
        Scanner scanner = scannerSupplier.get();

        //Predicate<InputParam> -> return true / false -> use with test
        Predicate<Integer> isEvenPredicate = a -> a % 2 == 0;
        //        System.out.println(isEvenPredicate.test(9));

        //BiFunction<InputParam1, InputParam2, ReturnType> -> use with apply
        BiFunction<Integer, Integer, Integer> multiplyBiFunc = (a, b) -> a * b;
        //        System.out.println(multiplyBiFunc.apply(2, 5));




        numbers.stream()
               .map(a -> a * a)
               .map(b -> b - 2)
               .map(x -> x * x * x)
               .filter(isEvenPredicate)
               .forEach(printNumConsumer);


        int res1 = calc(5, a -> powerOf2(a));
        int res2 = calc(5, a -> a - 1);
        int res3 = calc(5, a -> a + 1);
        printNum(res1, x -> System.out.println(x));

        System.out.println(res2);
        System.out.println(res3);
    }

    private static int powerOf2(int a) {
        return a * a;
    }

    private static void printNumber(int a) {
        System.out.println(a);
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    private static int multiplyNumbers(int a, int b) {
        return a * b;
    }

    private static int calc(int num, Calculator calculator) {
        return calculator.calculate(num);
    }

    private static void printNum(int num, Printer printer) {
        printer.print(num);
    }

    @FunctionalInterface
    interface Calculator { // Function

        Integer calculate(int num);
    }

    @FunctionalInterface
    interface Printer { // Consumer

        void print(int num);
    }
}
