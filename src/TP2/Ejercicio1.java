package TP2;

/*
Ejercicio 1.
        Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
        1. ¿Qué complejidad O() tiene? (La complejidad en el peor caso)
        2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
        3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?

        RESPUESTAS:
        1. Se implementaron dos métodos

        isOrder(n): Tiene una compledidad de O(n), siendo n el tamaño final del arreglo.

        isOrderImprovements(last): O(n/2) (WTF?)
        Se intenta mejorar la complejidad computacional a partir de
        incrementar una variable apuntandio al primer índice
        y decrementar otra apuntando al último.
        Técnicamente, O(n/2) es una complejidad de tiempo "válida".
        En la práctica, sin embargo, escribir  O(n/2) es una mala forma,
        ya que es exactamente el mismo conjunto de funciones que O(n).
        Este método además requiere mayor uso de memoría
        ya que se necesitan más variables y accesos.

        2. El problema de la recursión, podría ser que
        el método para funcionar, requiere recibir un parámetro
        con un valor equivalente a size-1 de nuestro arreglo.

        Además el arreglo debe tener todos los índices cargados,
        sino java completa con ceros hasta el final,
        de esta manera nunca estará ordenado.

        3. Si la estructura utilizada fuera una lista su tamaño es dinámico.
        Además podríamos implementar un iterador para preguntar si existe un próximo valor,
        con un puntero desde la clase, sin neesitar de un parámetro externo.

*/

import java.util.Arrays;

public class Ejercicio1 {
    int size;
    int cursor = 0;
    int[] array;
    int firstIndex;
    int lastIndex;
//    boolean isOrder = true;

    public Ejercicio1(int size) {
        this.size = size;
        this.array = new int[size];
        this.firstIndex = 0;
        this.lastIndex = this.array[size-1];
    }

    public boolean isOrder(int n) {
        boolean isOrder = true;
        if (n > 0 && n <= this.size-1) {
            if (this.array[n] >= this.array[n-1]) {
                isOrder = this.isOrder(n-1);
            } else {
                isOrder = false;
            }
        }
        return isOrder;
    }

    public boolean isOrderImprovements(int last) {
        int first = this.getFirstIndex();
        boolean isOrder = true;
        if (last > 0) {
            if (first != last) {

                if (this.array[first] > this.array[last]) {
                    this.setLastIndex(last-1);
                    this.setFirstIndex(first-1);
                    isOrder(last);
                } else {
                    isOrder = false;
                    return isOrder;
                }
            }
        }
        return isOrder;
    }



    public void addvalue() {
        this.array[0] = 1;
        this.array[1] = 2;
        this.array[2] = 3;
        this.array[3] = 2;
    }


    @Override
    public String toString () {
        String out = "";
        for (int i = 0; i < this.array.length; i++)
            out += this.array[i] + " ";
        return out;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}

