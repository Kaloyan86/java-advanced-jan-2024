package iterators_and_comparators;

public class Student implements Comparable<Student> {

    private int id;
    private String firstName;
    private String lastName; // optional
    private String email; // optional

    public Student(int id, String firstName, String... args) {
        this.id = id;
        this.firstName = firstName;

        if (args.length == 1) {
            this.lastName = args[0];
        } else if (args.length == 2){
            this.lastName = args[0];
            this.email = args[1];
        }
    }

    @Override
    public int compareTo(Student student) {
        /*
        this.student > student -> 1
        this.student < student -> -1
        this.student == student -> 0
       */
        int res = Integer.compare(this.id, student.id);

        if (res == 0) {
            if (this.firstName.equals(student.firstName)) {
                return 0;
            }
        }

        if (res == 0) {
            return this.firstName.compareTo(student.firstName);
        }

        return res;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               '}';
    }
}
