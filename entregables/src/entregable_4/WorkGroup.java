package entregable_4;

import java.util.*;

public class WorkGroup {
    private ArrayList<Employee> group;

    public WorkGroup(){
        this.group = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!this.containEmployee(employee))
            this.group.add(employee);
    }

    private boolean containEmployee(Employee employee) {
        return this.group.contains(employee);
    }

    public void removeLast() {
        this.group.remove(this.group.size()-1);
    }

    public ArrayList<Employee> getGroup() {
        return new ArrayList<>(this.group);
    }

    public int getWorkForce() {
        int workForceTotal = 0;
        for (Employee employee : this.group)
            workForceTotal += employee.getWorkForce();
        return workForceTotal;
    }

    public void clearList() {
        this.group.clear();
    }

    public void addEmployees(ArrayList<Employee> employees) {
        this.group.clear();
        this.group.addAll(employees);
    }


    @Override
    public boolean equals(Object obj) {
        try {
            WorkGroup aux = (WorkGroup) obj;
            return this.group.containsAll(aux.getGroup());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(" ");
        for (Employee employee : group)
           out.append(employee.toString());
        return out.toString() + "\nFuerza laboral del grupo: "+ this.getWorkForce();
    }


}
