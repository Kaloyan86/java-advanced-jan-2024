package sets_and_maps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        usernames.forEach(System.out::println);
    }
}
