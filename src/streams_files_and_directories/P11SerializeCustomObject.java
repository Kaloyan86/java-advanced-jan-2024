package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class P11SerializeCustomObject {

    public static void main(String[] args) {

        Course course = new Course("Java Advanced", 100);
        Course course2 = new Course("Java Web", 250);

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-jan-2024\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";

        try (
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            // serializing
            objectOutputStream.writeObject(course);
// TODO           objectOutputStream.writeObject(List.of(course, course2));

            // deserializing
            Course deserializedCourse = (Course) objectInputStream.readObject();
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
