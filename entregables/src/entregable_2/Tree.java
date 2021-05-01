package entregable_2;
/*
    Árbol Binario para búsquedas.

    Métodos:
    ● Object getRoot(), boolean hasElem(Object), boolean isEmpty(), void insert(Object),
    boolean delete(Object), int getHeight(), void printPosOrder(), void printPreOrder(), void
    printInOrder(), List getLongestBranch(), List getFrontera(), Object getMaxElem(), List
    getElemAtLevel(int)

*/

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

    public Tree(Integer values[]) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.addAll(values);
        this.setFather(null);
    }
    public Tree() {
        this.value = null;
        this.right = null;
        this.left = null;
        this.setFather(null);
    }

    private void addAll(Integer values[]) {
        for (int i = 0; i < values.length; i++) {
            if (i != 0)
                this.add(values[i]);
            else
                this.setValue(values[i]);
        }
    }

    public boolean hasElem(Integer value) {
        boolean hasIt = false;
        if (value == this.getValue()) {
            hasIt = true;
            return hasIt;
        } else if (value > this.getValue()) {
            if (this.right != null)
                hasIt = this.right.hasElem(value);
        } else if (value < this.getValue()) {
            if (this.left != null)
                hasIt = this.left.hasElem(value);
        }
        return hasIt;
    }

    public Integer getMaxElem() {
        Integer max = 0;
        Integer maxLeft = 0;
        Integer maxRight = 0;

        if (this.left != null) {
            Integer value = this.getValue();
            maxLeft = this.left.getMaxElem();
            if (value > maxLeft)
                maxLeft = value;
        }
        if (this.right != null) {
            Integer value = this.getValue();
            maxRight = this.right.getMaxElem();
            if (value > maxRight)
                maxRight = value;
        }
        if (maxLeft > maxRight) {
            max = maxLeft;
            return  max;
        } else {
            max = maxRight;
            return  max;
        }
    }

    public void add(Integer newValue) {
        if (newValue != this.value) {
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
    }

    public List getFrontera() {
        List leftList = new ArrayList<Integer>();
        List rightList = new ArrayList<Integer>();
        List finalList = new ArrayList<Integer>();

        if (this.left == null && this.right == null) {
            finalList.add(this.getValue());
            return finalList;
        }
        if (this.left != null) {
            leftList = this.left.getFrontera();
        }
        if (this.right != null) {
            rightList = this.right.getFrontera();
        }
        finalList.addAll(leftList);
        finalList.addAll(rightList);
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

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }


    //  Recorrido Pre-orden
    public void printPreOrder() {
        if (this.getValue() == null)
            return;

        System.out.print(this.getValue() + ", ");

        if (this.left != null)
            this.left.printPreOrder();

        if (this.right != null)
            this.right.printPreOrder();
    }

    //  Recorrido Post-orden
    public void printPostOrder() {
        if (this.getValue() == null)
            return;

        if (this.left != null) {
            this.left.printPostOrder();
        }

        if (this.right != null) {
            this.right.printPostOrder();
        }
        System.out.print(this.getValue() + ", ");

    }

    //  Recorrido En-orden
    public void printEnOrder() {
        if (this.getValue() == null)
            return;

        if (this.left != null)
            this.left.printEnOrder();

            System.out.print(this.getValue() + ", ");

        if (this.right != null)
            this.right.printEnOrder();

    }

    // GETTERS & SETTERS
    public void setFather(Tree father) {
        this.father = father;
    }
    public Tree getFather() {
        return this.father;
    }

}
