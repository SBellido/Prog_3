package TP2;

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

    // la complejidad computacional es de O(1)
    public Node getNext() {
        return next;
    }

    // la complejidad computacional es de O(1)
    public void setNext(Node next) {
        this.next = next;
    }

    // la complejidad computacional es de O(1)
    public Integer getInfo() {
        return info;
    }

    // la complejidad computacional es de O(1)
    public void setInfo(Integer info) {
        this.info = info;
    }


}
