package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integersList = new ArrayList<>();
        List<Double> doublesList = new ArrayList<>();
        List<MyIntegerClass> myIntegerClassList = new ArrayList<>();

        integersList.add(100);
        integersList.add(100);
        integersList.add(100);

        doublesList.add(10.5);
        doublesList.add(45.5);
        doublesList.add(12.5);

        print(integersList);
        print(doublesList);
        print(myIntegerClassList);
        List<Number> numbersList = new ArrayList<>();
        Integer integer = 10;
        Double aDouble = 10.5;
        numbersList.add(integer);
        numbersList.add(aDouble);

        print2(numbersList);
        List<Object> objectsList = new ArrayList<>();

        print2(objectsList);


        MyList<Integer> integerMyList = new MyList<>();
        MyList<MyIntegerClass> stringMyList1 = new MyList<>();
        MyIntegerClass myIntegerClass = new MyIntegerClass();

    }

    // Print only List with numeric values
    // Всички деца на Number
    static void print(List<? extends Number> list) {
        list.forEach(System.out::println);
    }

    // Всички родители на Number
    static void print2(List<? super Number> list) {
        list.forEach(System.out::println);
    }
}
