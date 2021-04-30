package TP2;
/*
    Ejercicio 6.
    Implemente la estructura de Árbol Binario para búsquedas.

    Métodos:
    ● Object getRoot(), boolean hasElem(Object), boolean isEmpty(), void insert(Object),
    boolean delete(Object), int getHeight(), void printPosOrder(), void printPreOrder(), void
    printInOrder(), List getLongestBranch(), List getFrontera(), Object getMaxElem(), List
    getElemAtLevel(int)

    1. ¿Cuál es la complejidad de cada uno de estos métodos?
    Nota: Mediante moodle indicaremos un ejercicio relacionado con los temas vistos en este
    práctico que deberá ser entregado en alguna fecha pautada.
*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Tree right;
    private Tree left;
    private Integer value;
    private Tree father;

    public Tree(Integer value, Tree father) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.setFather(father);
    }

    public Tree(Integer value) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.setFather(null);
    }

    public void add(int newValue) {
        if (newValue < this.value) {
            if (this.left == null)
                this.left = new Tree(newValue, this);
            else
                this.left.add(newValue);
        } else {
            if (this.right == null)
                this.right = new Tree(newValue, this);
            else
                this.right.add(newValue);
        }
    }

    public List getFrontera() {
        List leftlList = new ArrayList<Integer>();
        List rightList = new ArrayList<Integer>();
        List finalList = new ArrayList<Integer>();

        if (this.left == null && this.right == null) {
            finalList.add(this);
            return finalList;
        } else if (this.left != null) {
            leftlList = this.left.getFrontera();
        } else if (this.right != null) {
            rightList = this.right.getFrontera();
        }
        finalList.addAll(leftlList);
        finalList.addAll(rightList);
        String list = this.printList(finalList);
        System.out.println(list);
        return finalList ;
    }

    public Integer getRoot() {
        return this.getValue();
    }

    public boolean isEmpty() {
        return this.getValue() == null;
    }

    // Complejidad O(n) donde n es la cantidad de valores del arbol
    public int getHeight() {
        if (this.left == null && this.right == null) { // Si soy una hoja
            return 0; // Soy chato, tengo altura 0
        } else {
            // Si tengo al menos un hijo
            int heightLeft = 0;
            int heightRight = 0;

            if (this.left != null)
                heightLeft = 1 + this.left.getHeight();

            if (this.right != null)
                heightRight = 1 + this.right.getHeight();

            int higher = Math.max(heightLeft, heightRight);

            return higher;
        }
    }

    public Integer getValue() {
        return this.value;
    }

    public String printList(List list) {
        String out = "";
        for (Object value : list) {
            out += value;
        }
        return out;
    }

    //    @Override
//    public String toString() {
//        return "Tree{" +
//                "value=" + value +
//                '}';
//    }


// GETTERS & SETTERS
    public void setFather(Tree father) {
        this.father = father;
    }
    public Tree getFather() {
        return this.father;
    }

}
