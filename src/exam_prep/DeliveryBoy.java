package exam_prep;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int startRow = -1;
        int startCol = -1;

        String[][] field = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] currentRow = scanner.nextLine().split("");

            for (int c = 0; c < currentRow.length; c++) {
                field[r][c] = currentRow[c];
                // keep data for the initial position of the delivery boy
                // as you will need it later for the final output.
                if ("B".equals(field[r][c])) {
                    startRow = r;
                    startCol = c;
                }
            }
        }

        int boyRow = startRow;
        int boyCol = startCol;

        // TODO Action
        boolean isLeft = false;

        // 1.Breaks while-loop when He is out of the field
        while (!isLeft) {
            // check the current position
            // "P", "A", "-"

            if ("P".equals(field[boyRow][boyCol])) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                field[boyRow][boyCol] = "R";
            } else if ("-".equals(field[boyRow][boyCol])) {
                field[boyRow][boyCol] = ".";
            } else if ("A".equals(field[boyRow][boyCol])) {
                field[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                // 2.Breaks while-loop when Pizza is delivered
                break;
            }

            String command = scanner.nextLine();

            // Move
            switch (command) {
                case "up": // boyRow--
                    if (boyRow - 1 >= 0) {
                        // Check for obstacle "*"
                        if ("*".equals(field[boyRow - 1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow--;
                    break;
                case "down": // boyRow++
                    if (boyRow + 1 < field.length) {
                        // Check for obstacle "*"
                        if ("*".equals(field[boyRow + 1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow++;
                    break;
                case "left": // boyCol--
                    if (boyCol - 1 >= 0) {
                        // Check for obstacle "*"
                        if ("*".equals(field[boyRow][boyCol - 1])) {
                            continue;
                        }
                    }
                    boyCol--;
                    break;
                case "right": // boyCol++
                    if (boyCol + 1 < cols) {
                        // Check for obstacle "*"
                        if ("*".equals(field[boyRow][boyCol + 1])) {
                            continue;
                        }
                    }
                    boyCol++;
                    break;
            }
            // check whether is in the field and set isLeft
            // return true if is out or false if is in
            isLeft = isOutOfTheField(field, boyRow, boyCol);

        }
        if (isLeft) {
            field[startRow][startCol] = " ";
            System.out.println("The delivery is late. Order is canceled.");
        }
        printField(field);
    }

    private static boolean isOutOfTheField(String[][] field, int boyRow, int boyCol) {
        return boyRow < 0 || boyRow >= field.length ||
               boyCol < 0 || boyCol >= field[boyRow].length;
    }

    private static void printField(String[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
