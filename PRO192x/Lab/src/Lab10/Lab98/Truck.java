package Lab10.Lab98;

public class Truck extends Car {
    public void m1() {
        System.out.println("truck 1");
    }

    public static void main(String[] args) {
        Car mycar = new Car();
        Truck mytruck = new Truck();
        Car truck = new Truck();

        System.out.println(mycar);
        mycar.m1();
        mycar.m2();
        System.out.println(mytruck);
        mytruck.m1();
        mytruck.m2();
        System.out.println(truck);
        truck.m1();
        truck.m2();


    }
}

class Car {
    public void m1() {
        System.out.println("car 1");
    }

    public void m2() {
        System.out.println("car 2");
    }

    public String toString() {
        return "vroom";
    }
}