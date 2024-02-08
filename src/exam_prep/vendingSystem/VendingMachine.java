package exam_prep.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    // getCount() - int - returns the number of drinks,
    // available in the Vending machine.
    public int getCount() {
        return this.drinks.size();
    }

    //addDrink(Drink drink)
    //adds an entity to the collection of Drinks, if the Capacity allows it.
    public void addDrink(Drink drink) {
        if (this.buttonCapacity > this.drinks.size()) {
            drinks.add(drink);
        }
    }

    // removeDrink(String name) – removes a drink by given name,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeDrink(String name) {
        return this.drinks.removeIf(drink -> drink.getName().equals(name));
    }

    // getLongest() – returns the Drink with the biggest value of volume property.
    public Drink getLongest() {
        return this.drinks.stream()
                          .max(Comparator.comparingInt(Drink::getVolume))
                          .orElse(null);
    }

    // getCheapest() – returns the Drink with the lowest value of price property.
    public Drink getCheapest() {
        return this.drinks.stream()
                          // .min(Comparator.comparing(Drink::getPrice))
                          .min((d1, d2) -> d1.getPrice().compareTo(d2.getPrice()))
                          .orElse(null);
    }

    // buyDrink(String name)
    // - returns a string in the format of the overridden toString() method.
    public String buyDrink(String name) {
        Drink drink = this.drinks.stream()
                                 .filter(d -> d.getName().equals(name))
                                 .findFirst()
                                 .orElse(null);

        return drink.toString();
    }

    //report() – returns a string in the following format:
    //o	"Drinks available:
    //{Drink1}
    //{Drink2}
    //(…)"
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Drinks available:");

        this.drinks.forEach(drink -> {
            sb.append(System.lineSeparator());
            sb.append(drink.toString());
        });

        return sb.toString();
    }
}










