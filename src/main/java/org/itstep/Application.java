package org.itstep;

import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
//        print(1000000000000000000L);
//        print(1f);
//        Integer i = 1;
//        print(i);
//        print(1.0);
//        print("one");
        Truck truck = new Truck(1_200);
        Garage<Truck> truckGarage = new Garage<>();
        truckGarage.setVehicle(truck);
        Garage<Car> carGarage = new Garage<>();
        Car car = new Car(250);
        carGarage.setVehicle(car);

//        System.out.println(truckGarage.getVehicle().getName());
//        System.out.println(carGarage.getVehicle().getName());
        printVehicleName(truckGarage);
        printVehicleName(carGarage);

        Car[] cars = {new Car(120), new Car(350), new Car(245)};

        Car theSpeedestCar = findMaximum(cars);
//        Truck t = findMaximum(new Truck[]{new Truck(100)});
        System.out.println(theSpeedestCar.getMaxSpeed());

        Garage<Vehicle> garage = new Garage<>();
        setVehicle(garage);
//        System.out.println(garage.getVehicle().getMaxSpeed());
//        Garage<String> stringGarage = new Garage<>();
//        printVehicleName(stringGarage);
//        printName(car);
//        printName(truck);
    }

    static void setVehicle(Garage<? super Vehicle> garage) {
        // Consumer "super"
        garage.setVehicle(new Truck(100));
    }

    static <T extends Comparable<T>> T findMaximum(T[] arr) {
        T maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue.compareTo(arr[i]) < 0){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //    static <T> void printVehicleName(Garage<T> garage) {
//    static void printVehicleName(Garage<? extends Vehicle> garage) {
    static void printVehicleName(Garage<? extends Vehicle> garage) {
        // Producer "extend"
        System.out.println(garage.getVehicle().getName());
    }


    static void printName(Vehicle vehicle) {
        System.out.println(vehicle.getName());
    }

    public static void print(Integer value) {
        System.out.println("print(Integer): " + value);
    }

    public static void print(float value) {
        System.out.println("print(float): " + value);
    }

    public static <T> void print(T value) {
        System.out.println("print(T): " + value);
    }

//    public static void print(Object value) {
//        System.out.println("print(Object): " + value);
//    }
}

abstract class Vehicle {
    private final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Truck extends Vehicle {
    private final int maxWeight;

    public Truck(int maxWeight) {
        super("Truck");
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "maxWeight=" + maxWeight +
                '}';
    }
}

class Car extends Vehicle implements Comparable<Car> {
    private final int maxSpeed;

    public Car(int maxSpeed) {
        super("Car");
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return maxSpeed - o.maxSpeed;
    }
}

//class Garage<T extends Vehicle> {
class Garage<T> {

    private T vehicle;

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "vehicle=" + vehicle +
                '}';
    }
}