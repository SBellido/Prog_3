package TP2;

public class main_TP2_ejercicio1{

    public static void main(String[] args) {
        int n = 4;
        int index = n - 1;
        Ejercicio1 e1 = new Ejercicio1(n);
        Ejercicio2 e2 = new Ejercicio2();
//        e1.addvalue(12);
//        e1.addvalue(200);
//        e1.addvalue(50);
//
        e1.addvalue();
        System.out.println("\nARREGLO: " + e1.toString());
       System.out.println("¿El arreglo está ordenado?\n" + e1.isOrder(index));
       // System.out.println("¿El arreglo está ordenado?\n" +  e1.isOrderImprovements(index));
        System.out.println("¿El arreglo está ordenado?\n" + e2.findValue(20));
    }

}

