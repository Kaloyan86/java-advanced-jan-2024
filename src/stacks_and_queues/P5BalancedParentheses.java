package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                                   .collect(Collectors.toList());

        String result = isBalanced(input) ? "YES" : "NO";
//        if (isBalanced(input)){
//            System.out.println("YES");
//        }else {
//            System.out.println("NO");
//        }

        System.out.println(result);
    }

    private static boolean isBalanced(List<String> input) {
        // { [ ( ) ] } - balanced
        //  { } { [ ( ) ] } - balanced
        //  ) ] }  -  not balanced
        // ( { [ ( ) ] }  -  not balanced
        Deque<String> openParenthesesStack = new ArrayDeque<>();

        for (String brace : input) {

            switch (brace) {

                case "}":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    String openBrace = openParenthesesStack.pop();
                    if (!"{".equals(openBrace)) {
                        return false;
                    }
                    break;
                case "]":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openParenthesesStack.push(brace);
                    break;
            }
        }

        return openParenthesesStack.isEmpty();
    }
}
