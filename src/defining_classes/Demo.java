package defining_classes;

public class Demo {

    public static void main(String[] args) {

        Car car1 = new Car("sedan", "OPEL", "RED", 150);
        Car car2 = new Car("BMW", "RED", 115);
        Car car3 = new Car("KIA", 115);

        System.out.println(car1.toString());
        car1.drive();
        car1.drive();
        car1.drive();
        System.out.println(car1);
    }
}
