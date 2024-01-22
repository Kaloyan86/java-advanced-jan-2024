package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P2SumBytes {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bf = Files.newBufferedReader(Paths.get(path))) {

            String line = bf.readLine();
            int sum = 0;
            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = bf.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
