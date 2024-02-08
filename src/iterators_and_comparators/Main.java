package iterators_and_comparators;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(99, "Kaloyan" , "Kostadinov", "kostadinov@mail.bg");
        Student student2 = new Student(65, "Ivan");
        Student student3 = new Student(3, "Peter");
        Student student4 = new Student(99, "Anna");
        Student student5 = new Student(78, "Sofia");

        List<Student> studentList = List.of(student1, student2, student3, student4, student5);

        //        studentList.stream()
        //                   .sorted(Comparator.reverseOrder())
        //                   .forEach(System.out::println);

        Course course = new Course(studentList.toArray(Student[]::new));

        Iterator<Student> iterator = course.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(iterator.hasNext());
        }
    }
}
