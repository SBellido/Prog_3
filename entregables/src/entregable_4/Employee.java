package entregable_4;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int workForce;

    public Employee(int id, String name, String surname, int age, int workForce) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workForce = workForce;
    }


    @Override
    public String toString() {
        return "Empleado" +
                ", id: " + id +
                ", Nombre: " + name +
                ", Apellido: " + surname +
                ", Edad: " + age +
                ", Fuerza laboral: " + workForce;
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkForce() {
        return workForce;
    }

    public void setWorkForce(int workForce) {
        this.workForce = workForce;
    }
}
