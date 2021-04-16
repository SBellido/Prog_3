package entregable_1;

import java.util.Iterator;

public class main_entregable {

    public static void main(String[] args) {

        Resolution resolution = new Resolution();

        SimpleLinkedList list_1 = new SimpleLinkedList();
        Integer threshold_1 = 10;

        SimpleLinkedList list_2 = new SimpleLinkedList();
        Integer threshold_2 = 10;

        SimpleLinkedList list_3 = new SimpleLinkedList();
        Integer threshold_3 = 2;

        SimpleLinkedList list_4 = new SimpleLinkedList();
        Integer threshold_4 = 10;

        SimpleLinkedList list_5 = new SimpleLinkedList();
        Integer threshold_5 = 15;

//      CARGA DE DATOS
        list_2.insertFront(3);
        list_2.insertFront(2);
        list_2.insertFront(1);

        list_3.insertFront(3);
        list_3.insertFront(2);
        list_3.insertFront(1);

        list_4.insertFront(28);
        list_4.insertFront(14);
        list_4.insertFront(19);
        list_4.insertFront(7);
        list_4.insertFront(2);
        list_4.insertFront(5);
        list_4.insertFront(3);

        list_5.insertFront(28);

        list_5.insertFront(14);
        list_5.insertFront(15);
        list_5.insertFront(7);
        list_5.insertFront(2);
        list_5.insertFront(4);
        list_5.insertFront(5);
        list_5.insertFront(3);

        list_5.insertLast(28);

        System.out.println("Resolución 1: " + resolution.getSolution(list_1, threshold_1));
        System.out.println(list_1.toString());

        System.out.println("Resolución 2: " + resolution.getSolution(list_2, threshold_2));
        System.out.println(list_2.toString());

        System.out.println("Resolución 3: " + resolution.getSolution(list_3, threshold_3));
        System.out.println(list_3.toString());

        System.out.println("Resolución 4: " + resolution.getSolution(list_4, threshold_4));
        System.out.println(list_4.toString());

        System.out.println("Resolución 5: " + resolution.getSolution(list_5, threshold_5));
        System.out.println(list_5.toString());

    }

}
