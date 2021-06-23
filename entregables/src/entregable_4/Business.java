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

    public void makeTehBestProductiveGroups(ArrayList<Employee> groupComplete) {
        this.finalDiference = Integer.MAX_VALUE;
        this.group_1 = new WorkGroup();
        this.group_2 = new WorkGroup();
        Collections.sort(groupComplete);
        this.makeTehBestProductiveGroups(groupComplete, new WorkGroup(), new WorkGroup());
    }

    // BACKTRACKING
    private void makeTehBestProductiveGroups(ArrayList<Employee> groupComplete, WorkGroup group_1, WorkGroup group_2) {

        if (this.isSolution(groupComplete)) { // SI LA LISTA DE ENTRADA ESTÁ VACÍA ES SOLUCIÓN
            int partialDiference = this.getDiference(group_1, group_2);
            if (partialDiference < this.finalDiference) { // SI LA DIFERENCIA DE FUERZA DE TRABAJO PARCIAL ES MENOR, ES MEJOR SOLUCIÓN
                this.finalDiference = partialDiference;
                this.group_1.addEmployees(group_1.getGroup()); // AGREGA EN G1 LA LISTA PARCIAL A LA LISTA FINAL
                this.group_2.addEmployees(group_2.getGroup()); // AGREGA EN G2 LA LISTA PARCIAL A LA LISTA FINAL
            }
        } else {

            // al grupo que menos fuerza tiene le sumo toda la fuerza que me quedo afuera,
            // si ese valor es más grande que la diferencia parcial, ya no puedo mejorar,.. esto es PODA
            this.upCount();
            Employee employeeAux = groupComplete.remove(0);
            group_1.addEmployee(employeeAux); // ELIMINA EL PRIMERO DEL GRUPO DE ENTRADA Y LO AGREGA EN G1
            this.makeTehBestProductiveGroups(groupComplete, group_1, group_2); // LLAMADO RECURSIVO
            group_1.removeLast();
            group_2.addEmployee(employeeAux); // ELIMINA EL PRIMERO DEL GRUPO DE ENTRADA Y LO AGREGA EN G2

            this.makeTehBestProductiveGroups(groupComplete, group_1, group_2); // LLAMADO RECURSIVO

            group_2.removeLast();
            groupComplete.add(0, employeeAux);



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
