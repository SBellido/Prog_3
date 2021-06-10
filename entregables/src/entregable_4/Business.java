package entregable_4;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private String name;
    private List<Employee> employees;
    private MakeProductiveGroups makeGroups;

    public Business(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!this.containsEmployee(employee))
            this.employees.add(employee);
    }

    private boolean containsEmployee(Employee employee) {
        return this.employees.contains(employee);
    }

// GETTERS & SETTERS
    public List<Employee> getEmployees() {
        return new ArrayList<>(this.employees);
    }


}
