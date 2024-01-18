package sets_and_maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Sets keep unique elements
        HashSet<E> -> Does not guarantee the constant order of elements over time
        TreeSet<E> -> The elements are ordered incrementally
        LinkedHashSet<E> -> The order of appearance is preserved

        Maps hold a set of <key, value> pairs,
        Keys are unique
        HashMap<K, V> -> Does not guarantee the constant order of elements over time
        TreeMap<K, V> -> The elements are ordered incrementally by the key
        LinkedHashMap<K, V> -> The order of appearance is preserved

        Collisions in HashMap and HashSet
        Equals and HashCode contract
        */

        //        String a = "Siblings";
        //        String b = "Teheran";
        //        System.out.println(a.hashCode());
        //        System.out.println(b.hashCode());
        //
        //
        //        System.out.println();

        //        Set<Integer> set = new TreeSet<>();
        //        Arrays.stream(scanner.nextLine().split("\\s+"))
        //              .map(Integer::parseInt)
        //              .forEach(set::add);

        //        Set<Integer> set = Arrays.stream(scanner.nextLine().split("\\s+"))
        //                                     .map(Integer::parseInt)
        //                                     .collect(Collectors.toSet());
        //
        //        set.forEach(System.out::println);
        //        map.entrySet()
        //           .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        //        map.forEach((k, v) -> System.out.println(k + " " + v));

        //Map<Student, Double grade>
        Map<Student, Double> map = new HashMap<>();

        Student peter = new Student(1, "Peter");
        Student anna = new Student(1, "Anna");
        Student maria = new Student(3, "Maria");

        map.put(peter, 6.0);
        map.put(anna, 5.0);
        map.put(maria, 4.0);

//        System.out.println(peter.hashCode());
//        System.out.println(anna.hashCode());
//        System.out.println(maria.hashCode());

        System.out.println(map.get(anna));
    }
}



















