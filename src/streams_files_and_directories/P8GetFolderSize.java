package streams_files_and_directories;

import java.io.File;

public class P8GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);

        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                size += file.length();
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
