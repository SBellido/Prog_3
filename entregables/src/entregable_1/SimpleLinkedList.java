package entregable_1;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Integer>{

    private Node first;
    private Node last;
    private int size;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // la complejidad computacional es de O(1)
    public boolean isEmpty() {
        return this.first == null;
    }

    // la complejidad computacional es de O(1)
    // ya que la cantidad de accesos a memoria no cambia.
    public void insertFront(Integer number) {
        Node tmp = new Node(number, null);
        tmp.setNext(this.first);

        if (this.isEmpty())
            this.last = tmp;

        this.first = tmp;
        this.size++;
    }

    // la complejidad computacional es de O(1)
    public void insertLast(Integer number) {

        if (this.last != null) {
            Node tmp = this.last;
            this.last = new Node(number, null);
            tmp.setNext(this.last);
            this.size++;
        } else {
            this.insertFront(number);
        }
    }

    // la complejidad computacional es de O(1)
    // ya que la cantidad de accesos a memoria no cambia.
    public Integer getLast() {
        return this.get(this.size -1);
    }


    // PREGUNTAR O(1) POR LOS GET QUE LLAMA
    // la complejidad computacional es de O(1)
    // ya que la cantidad de accesos a memoria no cambia.
    public Integer extractFront() {
        if (this.isEmpty())
            return null;

        Integer info = first.getInfo();
        this.first = this.first.getNext();

        if (this.isEmpty())
            this.last = null;

        this.size--;
        return info;
    }

    // la complejidad computacional es de O(1)
    public int size() {
        return this.size;
    }

    // la complejidad computacional es de O(n)
    // donde n corresponde al valor del argumento / parámetro
    public Integer get(Integer index) {
        int pos = 0;
        Node aux = new Node();

        if (index >= 0 && index < this.size) {
            aux.setInfo(this.first.getInfo());
            aux.setNext(this.first.getNext());

            while (index != pos)  {
                if (this.isEmpty()) {
                    return aux.getInfo();
                } else {
                    aux = aux.getNext();
                    pos++;
                }
            }
            return aux.getInfo();
        }
        return aux.getInfo();
    }


    // la complejidad computacional es de O(n)
    // donde n es el valor del argumento / parámetro
    public SimpleLinkedList getCopy() {
        SimpleLinkedList listReturn = new SimpleLinkedList();
        Integer value = 0;

        MyIterator it = this.iterator();

        while (it.hasNext()) {
            value = it.getValue();
            listReturn.insertLast(value);
            it.move();
        }
        return listReturn;
    }


    @Override
    public MyIterator iterator() {
        return new MyIterator(this.first);
    }

    @Override
    public String toString() {
        MyIterator it = this.iterator();
        String out = "";

        while (it.hasNext()) {
            out+= it.getValue() + " ";
            it.move();
        }

        return out;
    }
}
