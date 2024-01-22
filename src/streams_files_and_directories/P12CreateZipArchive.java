package streams_files_and_directories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {

    public static void main(String[] args) {

        String inputPath1 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";
        String inputPath2 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt";
        String inputPath3 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

        List<String> paths = List.of(inputPath1, inputPath2, inputPath3);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)
        ) {

            for (String path : paths) {
                File file = new File(path);
                FileInputStream fileInputStream = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());

                zipOutputStream.putNextEntry(zipEntry);

                int oneByte = fileInputStream.read();

                while (oneByte != -1) {
                    zipOutputStream.write(oneByte);

                    oneByte = fileInputStream.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
