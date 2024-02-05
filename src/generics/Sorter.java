package generics;

public class Sorter {


    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        // 2 0 3 6 4 -> 0 2 3 6 4 -> 0 2 3 4 6
        for (int i = 0; i < customList.size(); i++) {
            T currentElement = customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                if (currentElement.compareTo(customList.get(j)) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
