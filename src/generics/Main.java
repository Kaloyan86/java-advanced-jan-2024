package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        int n = Integer.parseInt(scanner.nextLine());
        //        List<Box<String>> boxList = new ArrayList<>();
        //
        //        for (int i = 0; i < n; i++) {
        //            String line = scanner.nextLine();
        //            Box<String> box = new Box<>(line);
        //            boxList.add(box);
        //        }
        //
        //        Box<String> stringBox = new Box<>(scanner.nextLine());
        //        int count = count(boxList, stringBox);
        //        System.out.println(count);

        //        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
        //                              .mapToInt(Integer::parseInt)
        //                              .toArray();
        //
        //        swap(boxList, indexes[0], indexes[1]);

        //        boxList.forEach(System.out::println);

        String line = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!"END".equals(line)) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.forEach(System.out::println);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }


            line = scanner.nextLine();
        }

    }

    static <T extends Comparable<T>> int count(List<T> list, T element) {
        int count = 0;

        for (T el : list) {

            int res = el.compareTo(element);

            if (res > 0) {
                count++;
            }
        }
        return count;
    }


    static <T> void swap(List<T> list, int firstIndex, int secondIndex) {

        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
    }
}
