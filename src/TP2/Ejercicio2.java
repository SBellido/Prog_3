package TP2;
/* Ejercicio 2.
        Implemente un algoritmo recursivo para buscar un elemento en una lista simple.
        Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado
        ascendentemente [1 2 3 …].
        1. ¿Qué complejidad O() tienen estos algoritmos?
        2. ¿En qué afecta la estructura a estos algoritmos?
        3. ¿Cambia algo que la estructura esté ordenada?
*/

import java.util.Iterator;

public class Ejercicio2 {
    SimpleLinkedList list;


    public Ejercicio2() {
        this.list = new SimpleLinkedList();
    }

    public int findValue(int searchedValue) {
        int foundValue = -1;
        MyIterator it = this.list.iterator();
        if (it.hasNext()) {
            foundValue = this.list.get(this.list.iterator().getValue());
            if (searchedValue == foundValue) {
                return foundValue;
            } else {
                it.move();
                //devolver index
                this.findValue(searchedValue);
            }
            return foundValue;
        }
        return foundValue;
    }


}
