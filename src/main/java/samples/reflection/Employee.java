package samples.reflection;

import java.util.List;
import java.util.Map;

public class Employee {
    private String name;
    private double salary;
    private List<String> list;
    private Map<String, Integer> map;

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
