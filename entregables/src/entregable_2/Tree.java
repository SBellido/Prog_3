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

    public List atElement(int value) {
        List list = new ArrayList<Integer>();
        int height = 0;
        if (value == height) {
            list.add(this.getValue());
            height++;
        } else if (value > height) {
            height++;
            if (this.left != null) {
                list = this.left.atElement(height);
            }
            if (this.right != null) {
                list = this.right.atElement(height);
            }
        }
        return list;
    }


    public List<Integer> getLongestBranch() {
        List longestList = new ArrayList<Integer>();
        // SI NO SOY UNA HOJA
        if (!(this.left == null && this.right == null)) {
            List rightHeightList = new ArrayList<Integer>();
            List lerftHeightList = new ArrayList<Integer>();

            // SI TENGO HIJO MENOR LLAMA RECURSIVAMENTE POR LA IZQUIERDA
            if (this.left != null) {
                lerftHeightList = this.left.getLongestBranch();
            }

            // SI TENGO HIJO MAYOR LLAMA RECURSIVAMENTE POR LA DERECHA
            if (this.right != null) {
                rightHeightList = this.right.getLongestBranch();
            }
            // COMPARA TAMAÑOS DE LISTA Y OBTIENE LA MAYOR
            longestList = this.compareSizeList(lerftHeightList, rightHeightList);
        }
        longestList.add(this.getValue());
        // SOY UN ÁRBOL VACÍO, RETORNA EL VALOR DE LA RAÍZ
        return longestList;
    }


    private List completeLeftList(List left) {
        left.add(this.getValue());
        return left;
    }
    private List completeRightList(List right) {
        right.add(this.getValue());
        return right;
    }

    private List compareSizeList(List leftList, List rightList) {
        if (leftList.size() > rightList.size())
            return leftList;
        else
            return rightList;
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

    public Integer getMinElem() {
        Integer minLeft = 0;
        if (this.left != null)
            minLeft = this.left.getMinElem();
        else
            return this.getValue();
        return minLeft;
    }

    public Integer getMaxElem() {
        Integer maxRight = 0;
        if (this.right != null)
            maxRight = this.right.getMaxElem();
        else
            return this.getValue();
        return maxRight;
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

        // SI NO TIENE HIJOS ES UNA HOJA
        if (this.left == null && this.right == null) {
            finalList.add(this.getValue());
            return finalList;
        }
        // SI TIENE HIJO IZQUIERDO LLAMA RECURSIVAMENTE
        if (this.left != null) {
            leftList = this.left.getFrontera();
        }
        // SI TIENE HIJO DERECHO LLAMA RECURSIVAMENTE
        if (this.right != null) {
            rightList = this.right.getFrontera();
        }
        // CARGA LA LISTA FINAL CON AMBAS LISTAS DE HOJAS
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
