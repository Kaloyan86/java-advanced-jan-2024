package iterators_and_comparators;

import java.util.Iterator;

public class Course implements Iterable<Student> {

    private Student[] students;

    public Course(Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    class StudentIterator implements Iterator<Student> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public Student next() {
            System.out.println("Index: " + index);
            return students[index++];
        }
    }
}
