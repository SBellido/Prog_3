package entregable_4;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        Business business1 = new Business("Stormtech");
        Business business2 = new Business("BeeReal");
        Business business3 = new Business("Technisis");
        Business business4 = new Business("Grupo Asa");
        Business business5 = new Business("Yahoo");
        Business business6 = new Business("MediaLab");
        Business business7 = new Business("Pladema");
        Business business8 = new Business("Google");
        Business business9 = new Business("Trenda");


        Employee e1 = new Employee(1, "Juan", "Pérez", 32, 48);
        Employee e2 = new Employee(2, "Roberto", "Hernández", 45, 57);
        Employee e3 = new Employee(3, "Camila", "Gutiérrez", 33, 51);
        Employee e4 = new Employee(4, "Francisco", "Martínez", 22, 73);
        Employee e5 = new Employee(5, "Benjamín", "Núñez", 55, 15);
        Employee e6 = new Employee(6, "Mateo", "Morales", 24, 33);
        Employee e7 = new Employee(7, "Delfina", "López", 36, 92);
        Employee e8 = new Employee(8, "Catalina", "Cruz", 51, 71);
        Employee e9 = new Employee(9, "Benicio", "Montero", 48, 19);
        Employee e10 = new Employee(10, "Valentino", "González", 58, 22);
        Employee e11 = new Employee(11, "Olivia", "Gómez", 33, 41);
        Employee e12 = new Employee(12, "Martina", "Díaz", 21, 49);
        Employee e13 = new Employee(13, "Joaquín", "Cabrera", 22, 14);
        Employee e14 = new Employee(14, "Bautista", "Domínguez", 36, 33);
        Employee e15 = new Employee(15, "Emilia", "Paz", 40, 16);
        Employee e16 = new Employee(16, "Francesca", "Figueroa", 43, 21);
        Employee e17 = new Employee(17, "Santino", "Blanco", 25, 79);
        Employee e18 = new Employee(18, "Ignacio", "Ibarra", 61, 32);
        Employee e19 = new Employee(19, "Andrea", "Chávez", 27, 78);
        Employee e20 = new Employee(20, "Elena", "Mengochea", 52, 67);

        ArrayList<Employee> entry1 = new ArrayList<>();
        entry1.add(e1);
        entry1.add(e2);
        entry1.add(e3);
        entry1.add(e4);
        entry1.add(e5);
        entry1.add(e6);
        ArrayList<Employee> entry2 = new ArrayList<>();
        entry2.add(e7);
        entry2.add(e4);
        entry2.add(e8);
        entry2.add(e15);
        ArrayList<Employee> entry3 = new ArrayList<>();
        entry3.add(e19);
        entry3.add(e12);
        entry3.add(e11);
        entry3.add(e13);
        ArrayList<Employee> entry4 = new ArrayList<>();
        entry4.add(e19);
        entry4.add(e18);
        entry4.add(e14);
        entry4.add(e16);
        ArrayList<Employee> entry5 = new ArrayList<>();
        entry5.add(e7);
        entry5.add(e8);
        entry5.add(e20);
        entry5.add(e3);
        entry5.add(e16);
        ArrayList<Employee> entry6 = new ArrayList<>();
        entry6.add(e7);
        entry6.add(e8);
        entry6.add(e20);
        entry6.add(e3);
        ArrayList<Employee> entry7 = new ArrayList<>();
        entry7.add(e17);
        entry7.add(e2);
        entry7.add(e19);
        entry7.add(e20);
        entry7.add(e4);
        entry7.add(e12);
        entry7.add(e15);
        ArrayList<Employee> entry8 = new ArrayList<>();
        entry8.add(e12);
        entry8.add(e14);
        entry8.add(e18);
        entry8.add(e6);
        entry8.add(e2);
        entry8.add(e9);
        entry8.add(e2);
        entry8.add(e16);
        ArrayList<Employee> entry9 = new ArrayList<>();
        entry9.add(e1);
        entry9.add(e2);
        entry9.add(e3);
        entry9.add(e4);
        entry9.add(e5);
        entry9.add(e6);
        entry9.add(e7);
        entry9.add(e8);
        entry9.add(e9);
        entry9.add(e10);
        entry9.add(e11);
        entry9.add(e12);
        entry9.add(e13);
        entry9.add(e14);
        entry9.add(e15);
        entry9.add(e16);
        entry9.add(e17);
        entry9.add(e18);
        entry9.add(e19);
        entry9.add(e20);

        // greedy
//        business.makeProductiveGroups(entry1);
//        business.makeProductiveGroups(entry2);
//        business.makeProductiveGroups(entry3);
//        business.makeProductiveGroups(entry4);
//        business.makeProductiveGroups(entry5);
//        business.makeProductiveGroups(entry6);
//        business.makeProductiveGroups(entry7);
//        business.makeProductiveGroups(entry8);
//        business.makeProductiveGroups(entry9);

        // backtracking
        System.out.println("RESULTADOS BACKTRACKING");
        business1.makeTheBestProductiveGroups(entry1);
        business2.makeTheBestProductiveGroups(entry2);
        business3.makeTheBestProductiveGroups(entry3);
        business4.makeTheBestProductiveGroups(entry4);
        business5.makeTheBestProductiveGroups(entry5);
        business6.makeTheBestProductiveGroups(entry6);
        business7.makeTheBestProductiveGroups(entry7);
        business8.makeTheBestProductiveGroups(entry8);
        business9.makeTheBestProductiveGroups(entry9);

//        business.makeTehBestProductiveGroups(entry3, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry4, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry5, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry6, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry7, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry8, 0, 0, group_1, group_2);
//        business.makeTehBestProductiveGroups(entry9, 0, 0, group_1, group_2);

        System.out.println(business1.toString()+"\n");
        System.out.println(business2.toString()+"\n");
        System.out.println(business3.toString()+"\n");
        System.out.println(business4.toString()+"\n");
        System.out.println(business5.toString()+"\n");
        System.out.println(business6.toString()+"\n");
        System.out.println(business7.toString()+"\n");
        System.out.println(business8.toString()+"\n");
        System.out.println(business9.toString()+"\n");

//        Entrada 1: [ e1, e2, e3, e4, e5, e6 ]
//
//        Entrada 2: [ e7, e4, e8, e15]
//
//        Entrada 3: [ e19, e12, e11, e13 ]
//
//        Entrada 4: [ e19, e18, e14, e16 ]
//
//        Entrada 5: [ e7, e8, e20, e3, e16 ]
//
//        Entrada 6: [ e7, e8, e20, e3, e16 ]
//
//        Entrada 7: [ e17, e2, e19, e20, e4, e12, e15 ]
//
//        Entrada 8: [ e12, e14, e18, e6, e2, e9, e10, e16 ]
//
//        Entrada 9: [ e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20 ]

    }

}
