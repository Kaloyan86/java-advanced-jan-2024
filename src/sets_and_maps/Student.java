package sets_and_maps;

import java.util.Objects;

public class Student {

    private Integer id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Calling equals() for key " + o);
        if (this == o) {
            System.out.println("This is the object " + o);
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
//        int result = id.hashCode();
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
        return Objects.hash(id, name);
    }
}
