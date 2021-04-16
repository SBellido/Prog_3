package TP1;

/*
Ejercicio 1.
Implemente los m�todos indicados del esqueleto de Lista desarrollado en Teor�a (insertFront,
extractFront, isEmpty, size). Agregar tambi�n el m�todo: Object get(index)
 */

public class Node {

    private Integer info;
    private Node next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(Integer o, Node n) {
        this.setInfo(o);
        this.setNext(n);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    //	@Override
    public String toString() {
        return " \n Info de nodo: " + this.getInfo() +
                "\n nodo siguiente: " + this.getNext();
    }

}
