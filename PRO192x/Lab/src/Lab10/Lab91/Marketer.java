package Lab10.Lab91;

public class Marketer extends Employee {
    public Marketer() {
    }

    public double getSalary() {
        return super.getSalary() + 10000;
    }

    public void advertise() {
        System.out.println("Act now, while supplies last!");
    }
}
