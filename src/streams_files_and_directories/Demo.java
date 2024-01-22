package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /*

        FileInputStream, FileOutputStream - Read and Write byte by byte

        FileReader, FileWriter - Read and Write character by character

        Scanner() - uses InputStream

        PrintWriter -  uses Writer

        BufferedReader, BufferedWriter - uses Reader and Writer

        */

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        try (FileInputStream fileInputStream = new FileInputStream(path)) {

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {
                System.out.print((char) oneByte);
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("==============");

        try (FileReader fileReader = new FileReader(path)) {

            int oneByte = fileReader.read();

            while (oneByte != -1) {
                System.out.print((char) oneByte);
                oneByte = fileReader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }






















    }
}
