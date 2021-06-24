package entregable_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Business {
    private String name;
    private WorkGroup group_1;
    private WorkGroup group_2;
    private int count = 0;
    private int finalDiference;

    public Business(String name) {
        this.name = name;
        this.group_1 = new WorkGroup();
        this.group_2 = new WorkGroup();
    }

    // GREEDY
    public void makeProductiveGroups(ArrayList<Employee> groupComplete) {
        List<Employee> groupEmployees = new ArrayList<>();
        // MI CANDIDTO ES EL EMPLEADO Y EL GRUPO QUE MENOS FUERZA TIENE
        while (!groupComplete.isEmpty() && !this.isSolution(groupComplete)) {
            ArrayList<Employee> bestTwo = this.toSelect(groupComplete);
        }

    }

    public void makeTheBestProductiveGroups(ArrayList<Employee> groupComplete) {
        this.finalDiference = Integer.MAX_VALUE;
        this.group_1 = new WorkGroup();
        this.group_2 = new WorkGroup();
        Collections.sort(groupComplete);
        this.makeTheBestProductiveGroups(groupComplete, new WorkGroup(), new WorkGroup());
    }

    // BACKTRACKING
    private void makeTheBestProductiveGroups(ArrayList<Employee> groupComplete, WorkGroup group_1, WorkGroup group_2) {

        int partialDiference = this.getDiference(group_1, group_2);
        if (this.isSolution(groupComplete)) { // SI LA LISTA DE ENTRADA ESTÁ VACÍA ES SOLUCIÓN
            if (partialDiference < this.finalDiference) { // SI LA DIFERENCIA DE FUERZA DE TRABAJO PARCIAL ES MENOR, ES MEJOR SOLUCIÓN
                this.finalDiference = partialDiference;
                this.group_1.addEmployees(group_1.getGroup()); // AGREGA EN G1 LA LISTA PARCIAL A LA LISTA FINAL
                this.group_2.addEmployees(group_2.getGroup()); // AGREGA EN G2 LA LISTA PARCIAL A LA LISTA FINAL
            }
        } else {

           if (this.isItFeasible(group_1, group_2, groupComplete, partialDiference)) { // PODA
                this.upCount(); // INCREMENTA EL CONTADOR
                Employee employeeAux = groupComplete.remove(0); // ELIMINA PRIMER EMPLEADO DE LISTA Y GUARDA UNA COPIA
                group_1.addEmployee(employeeAux); // AGREGA EN G1 EL EMPLEADO ELIMINADO DE LA LISTA DE ENTRADA

                this.makeTheBestProductiveGroups(groupComplete, group_1, group_2); // LLAMADO RECURSIVO DE BACKTRACKING
                group_1.removeLast(); // ELIMINA ÚLTIMO EMPLEADO DEL GRUPO 1
                group_2.addEmployee(employeeAux); // AGREGA EN G2 EL EMPLEADO ELIMINADO DE LA LISTA DE ENTRADA

                this.makeTheBestProductiveGroups(groupComplete, group_1, group_2); // LLAMADO RECURSIVO DE BACKTRACKING
                group_2.removeLast(); // ELIMINA ÚLTIMO EMPLEADO DEL GRUPO 2
                groupComplete.add(0, employeeAux);
            }

        }
    }

    private boolean isItFeasible(WorkGroup group_1, WorkGroup group_2, ArrayList<Employee> groupComplete, int partialDiference) {
        // al grupo que menos fuerza tiene le sumo toda la fuerza que me quedo afuera,
        // si ese valor es más grande que la diferencia parcial, ya no puedo mejorar.
        WorkGroup weakestGroup = this.getWeakestGroup(group_1, group_2);
        int pendingForce = this.getWorkForce(groupComplete);
        int result = pendingForce + weakestGroup.getWorkForce();
        return result > partialDiference;
    }

    private int getWorkForce(ArrayList<Employee> groupComplete) {
        int workForceTotal = 0;
        for (Employee employee : groupComplete)
            workForceTotal += employee.getWorkForce();
        return workForceTotal;
    }

    private WorkGroup getWeakestGroup(WorkGroup group_1, WorkGroup group_2) {
        if (group_1.getWorkForce() < group_2.getWorkForce()) {
            return group_1;
        } else {
            return group_2;
        }
    }


    private int getDiference(WorkGroup group_1, WorkGroup group_2) {
        int diference = 0;
        int workForce_1 = group_1.getWorkForce();
        int workForce_2 = group_2.getWorkForce();

        if (workForce_1 > workForce_2) {
            diference = workForce_1 - workForce_2;
        } else {
            diference = workForce_2 - workForce_1;
        }
        return diference;
    }

    private void addWorkGroup(WorkGroup group) {
        this.group_1.addEmployees(group.getGroup());
    }

    private ArrayList<Employee> toSelect(ArrayList<Employee> groupEmployees) {
        return groupEmployees;
    }

    private boolean isSolution(ArrayList<Employee> groupComplete) {
        return groupComplete.isEmpty();
    }

    @Override
    public String toString() {
        return "EMPRESA" +
                "\nNombre: " + this.getName() + "\n" +
                "\nGrupo 1: " + group_1.toString() +
                "\nGrupo 2: " + group_2.toString() +
                "\nContador " + this.getCount();
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    private void upCount() {
        this.count++;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
