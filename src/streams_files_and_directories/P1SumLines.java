package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P1SumLines {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                int sum = 0;

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    sum += symbol;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
