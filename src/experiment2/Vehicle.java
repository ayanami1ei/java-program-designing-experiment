package experiment2;

public abstract class Vehicle {
    private String name;

    public abstract void sound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Bike extends Vehicle {
    @Override
    public void sound() {
        System.out.println("lingling");
    }
}

class Car extends Vehicle {
    @Override
    public void sound() {
        System.out.println("dudu");
    }
}

class Train extends Vehicle {
    @Override
    public void sound() {
        System.out.println("wuwu");
    }
}

class Example2_1 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();
        Train train = new Train();

        bike.setName("bike");
        System.out.print(bike.getName() + ":");
        bike.sound();

        car.setName("car");
        System.out.print(car.getName() + ":");
        car.sound();

        train.setName("train");
        System.out.print(train.getName() + ":");
        train.sound();
    }
}


