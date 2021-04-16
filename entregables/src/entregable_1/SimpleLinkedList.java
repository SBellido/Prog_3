package entregable_1;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Integer>{

    protected Node first;
    protected Node last;
    protected Node cursor;
    private int size;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
        this.cursor = null;
        this.size = 0;
    }

    public void insertFront(Integer number) {
        Node tmp = new Node(number, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public Integer getLast() {
        return this.get(this.size -1);
    }

 /*   public void insertLast(Integer number) {
        MyIterator it = (MyIterator) this.iterator();
        while (it.hasNext()) {
            it.move();
        }
        this.last = it.getCursor();
        this.last.setInfo(number);
        this.size++;
    }*/


//		Node tmp = new Node(number, this.first);
//		this.cursor = tmp.getNext();
//		if (this.cursor.getInfo() == null) {
//			this.last = this.cursor;
//		}
//		tmp.setNext(this.last);
//		this.size++;


    public Integer extractFront() {
        if (this.isEmpty()) {
            return null;
        }
        Integer info = first.getInfo();
        this.first = this.first.getNext();
        this.size--;
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public Integer get(int index) {
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

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this.first);
    }
}
