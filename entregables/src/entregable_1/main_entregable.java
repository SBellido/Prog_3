package entregable_1;

import java.util.Iterator;

public class main_entregable {

    public static void main(String[] args) {

        SimpleLinkedList list = new SimpleLinkedList();
        Resolution resolution = new Resolution();
        Integer threshold = 10;

//        SETEAR threshold = 10 &&
//        ejecutar resolution.getSolution(list, threshold);

//        SETEAR threshold = 10 || 2
//        list.insertFront(3);
//        list.insertFront(2);
//        list.insertFront(1);

//        SETEAR threshold = 10
//        list.insertFront(28);
//        list.insertFront(14);
//        list.insertFront(19);
//        list.insertFront(7);
//        list.insertFront(2);
//        list.insertFront(5);
//        list.insertFront(3);

//        SETEAR threshold = 15
        list.insertFront(28);
        list.insertFront(14);
        list.insertFront(15);
        list.insertFront(7);
        list.insertFront(2);
        list.insertFront(4);
        list.insertFront(5);
        list.insertFront(3);

        System.out.println(resolution.getSolution(list, threshold));


    }

}
