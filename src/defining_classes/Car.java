package defining_classes;

public class Car {

    private String type;
    private String make;
    private String color;
    private int horsePower;
    private int fuelAmount;
    private int distance;

    public Car(String make){
        this(make, 0);
    }

    public Car(String make, int horsePower) {
        this(make, "DEFAULT", horsePower);
    }

    public Car(String make, String color, int horsePower) {
        this("DEFAULT", make, color, horsePower);
    }

    public Car(String type, String make, String color, int horsePower) {
        this.type = type;
        this.make = make;
        this.color = color;
        this.setHorsePower(horsePower);
        this.fuelAmount = 100;
    }

    public String getType() {
        return type;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        // Check for negative value
        if (horsePower > 0) {
            this.horsePower = horsePower;
        }else {
            System.out.println("Horse power must be greater than 0!");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
               "type='" + type + '\'' +
               ", make='" + make + '\'' +
               ", color='" + color + '\'' +
               ", horsePower=" + horsePower +
               ", fuelAmount=" + fuelAmount +
               ", distance=" + distance +
               '}';
    }

    public void drive(){
        this.fuelAmount -= 7;
        this.distance += 100;
    }
}
