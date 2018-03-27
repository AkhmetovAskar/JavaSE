package samples.reflection;

public class Employee {
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void printSomething() {
        System.out.println("something");
    }

    public void printParameter(int param) {
        System.out.println("param = " + param);
    }
}
