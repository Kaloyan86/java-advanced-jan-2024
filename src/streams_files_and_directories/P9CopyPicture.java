package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P9CopyPicture {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\copy-picture.jpg";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {

                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
