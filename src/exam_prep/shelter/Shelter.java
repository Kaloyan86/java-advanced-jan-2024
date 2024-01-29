package exam_prep.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    // Method add(Animal animal)
    // – adds an entity to the data if there is an empty cell for the animal.
    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    // Method remove(String name)
    // – removes the animal by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        Animal animal = this.data.stream()
                                 .filter(a -> a.getName().equals(name))
                                 .findFirst()
                                 .orElse(null);

        if (animal == null) {
            return false;
        }

        return this.data.remove(animal);
    }

    //Method getAnimal(String name, String caretaker)
    // – returns the animal with the given name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                        .filter(a -> a.getName().equals(name) &&
                                     a.getCaretaker().equals(caretaker))
                        .findFirst()
                        .orElse(null);
    }

    //•	Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal() {
        return this.data.stream()
                        .max(Comparator.comparingInt(Animal::getAge))
                        .orElse(null);
    }

    //•	Getter getCount – returns the number of animals
    public int getCount() {
        return this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The exam_prep.shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The exam_prep.shelter has the following animals:");

        this.data.forEach(animal -> {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", animal.getName(), animal.getCaretaker()));
        });

        return sb.toString();
    }
}
