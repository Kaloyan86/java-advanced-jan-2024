package defining_classes.p9_cat_lady;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Cat> catList = new ArrayList<>();
        Map<String, Cat> catMap = new HashMap<>();

        while (!"End".equals(line)) {

            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);

            Cat cat;

            switch (type) {
                case "Siamese":
                    cat = new Siamese(name, type, parameter);
                    break;
                case "Cymric":
                    cat = new Cymric(name, type, parameter);
                    break;
                default:
                    cat = new StreetExtraordinaire(name, type, parameter);
                    break;
            }
            catList.add(cat);
            catMap.put(name, cat);

            line = scanner.nextLine();
        }

        String catName = scanner.nextLine();
        System.out.println(catMap.get(catName));
        //
//        Cat searchedCat = catList.stream()
//                                 .filter(cat -> cat.getName().equals(catName))
//                                 .findFirst()
//                                 .get();
//
//        System.out.println(searchedCat);
    }
}
