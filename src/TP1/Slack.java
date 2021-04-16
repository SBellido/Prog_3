package TP1;

/*
Ejercicio 3.
Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar elementos
utilizando el metodo push(Object o). Para retirar elementos de la coleccion se utiliza el metodo
pop(), que retorna el ultimo elemento agregado a la coleccion y lo elimina de la misma. Es
posible consultar el tope de la pila (sin eliminarlo) utilizando el metodo top(). Por ultimo, es
posible inve
 */

public class Slack {
    private MySimpleLinkedList list;

    public Slack() {
        this.list = new MySimpleLinkedList();
    }

    public void push(Integer value) {
        this.list.insertFront(value);
    }

    public Integer pop() {
        return this.list.get(0);
    }

    public Integer top() {
        return this.list.extractFront();
    }

    public void reverse() {
        MySimpleLinkedList auxList = new MySimpleLinkedList();

        while (!this.list.isEmpty())
             this.list.insertFront(this.list.extractFront());

        this.list = auxList;
    }
}
