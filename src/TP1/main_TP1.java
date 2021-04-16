package TP1;

/*
Ejercicio 1.
Implemente los m�todos indicados del esqueleto de Lista desarrollado en Teor�a (insertFront,
extractFront, isEmpty, size). Agregar tambi�n el m�todo: Object get(index)

Ejercicio 2.
Considerando la implementaci�n de la Lista realizado en el ejercicio anterior, comparar la
complejidad computacional contra un array en las siguientes operaciones:
1.- Insertar al principio.
2.- Buscar un elemento en una posici�n.
3.- Determinar la cantidad de elementos.

1.- RESPUESTA
	 O(1) es la complejidad computacional al insertar
	 un elemento al principio de una lista doblemente vinculada,
	 Esto se logra al instanciar un puntero con una referencia
	 al primer elemento, de otra manera la compeljidad ser�a O(n).

	 O(n) es la complejidad computacional al insertar
	 un elemento al principio de un array,
	 siendo 'n' la cantidad de elemtnos contenidos en el mismo.
	 En el peor de los casos se deber� hacer un corrimiento a la derecha
	 de todos los elementos que conforman el array.

2.- RESPUESTA
	 O(1) es la complejidad computacional para obtener un elemento
	 en una posici�n X de un array, ya que solo se necesita un acceso a memoria
	 consultando el valor que se encuentra en un �ndice determinado.

	 O(n) es la complejidad computacioal para obtener un elemento
	 en una posici�n X de una lista doblemente vinculada.
	 Siendo 'n' la cantiad de elementos contenidos, ya que en el peor de los casos
	 se necesita consultar todos los elementos
	 comparando el �ndice requerido con un contador auxiliar

3.- RESPUESTA
	 O(1) es la complejidad computacional para determnar cantidad de elementos en un array,
	 ya que la cantidad de elementos est� determinada desde su instancia y ese valor no cambia.

	 O(1) es la complejidad computacional para determnar cantidad de elementos
	 en una lista doblemente vinculada. Esto se logra llevando el control
	 de la cantidad de elementos contenidos; incrementado la variable 'size'
	 al insertar y decrementando la misma al extraer un elemento.
	 Por lo tanto solo hace falta un acceso a memoria consultando el valor de esta variable.

*/

import java.util.Iterator;

public class main_TP1 {

    public static void main(String[] args) {
        MySimpleLinkedList list = new MySimpleLinkedList();

        list.insertFront(13);
        list.insertFront(12);
        list.insertFront(11);
        list.insertFront(10);
		list.insertLast(9);

        Iterator<Integer> MyIterator = list.iterator();

        while (MyIterator.hasNext()) {
            System.out.println(MyIterator.next());
        }

    }

}
