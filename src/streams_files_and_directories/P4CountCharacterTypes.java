package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class P4CountCharacterTypes {

    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuations = Set.of('!', ',', '.', '?');
        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader.readLine();
            /*
            •	a, e, i, o, u are vowels, only lower case.
            •	All others are other symbols.
            •	Punctuation marks are (! , . ?).
            •	Do not count whitespace.

             */
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuations.contains(c)) {
                        punctuationsCount++;
                    } else if (c != ' ') {
                        othersCount++;
                    }
                }

                line = reader.readLine();
            }

            writer.write(String.format("Vowels: %d", vowelsCount));
            writer.newLine();
            writer.write(String.format("Other symbols: %d", othersCount));
            writer.newLine();
            writer.write(String.format("Punctuation: %d", punctuationsCount));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
