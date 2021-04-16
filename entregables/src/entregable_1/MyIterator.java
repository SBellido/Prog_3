package entregable_1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {

    private Node cursor;

    public MyIterator(Node cursor) {
        this.cursor = cursor;
    }

    // la complejidad computacional es de O(1)
    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    // la complejidad computacional es de O(1)
    @Override
    public Integer next() {
        // guarda una referencia al primer valor
        Integer value = this.cursor.getInfo();
        this.cursor = this.cursor.getNext(); // avanza el cursor
        return value;
    }

    // la complejidad computacional es de O(1)
    public Integer getValue() {
        return this.cursor.getInfo();
    }

    // la complejidad computacional es de O(1)
    public void move() {
        this.cursor = this.cursor.getNext();
    }

    // la complejidad computacional es de O(1)
//    public Node getCursor() {
//        return this.cursor;
//    }


}
