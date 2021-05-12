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
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class Tree {

    private Integer value;
    private Tree right;
    private Tree left;
    private Tree father;

    private Tree(Integer value, Tree father) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.setFather(father);
    }

    public Tree(Integer values[]) {
        this.value = null;
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

//preguntar
    // Complejidad computacional: O(n)
    // donde n es la cantidad de elementos del arreglo.
    private void addAll(Integer values[]) {
        // RECORRE EL ARREGLO
        for (int i = 0; i < values.length; i++) {
            // AGREGA UN VALOR A LA RAÍZ
            if (i != 0)
                this.add(values[i]);
            else
                // AGREGA EL RESTO DE LOS VALORES
                this.setValue(values[i]);
        }
    }

    private void removeTree() {
        this.setValue(null);
        this.setFather(null);
        this.setLeft(null);
        this.setRight(null);
    }

    private void giveMyFatherLeftSon() {
        if (this.left != null)
            this.setValue(this.left.getValue());
            this.father.left.setValue(this.getValue());

        if (this.right != null)
            this.setValue(this.right.getValue());
            this.father.right.setValue(this.getValue());
    }

    private void giveMyFatherRightSon() {
        if (this.right != null) {
            this.father.right.setValue(this.right.getValue());
            this.setValue(null);
        }
        if (this.left != null) {
            this.father.right.setValue(this.left.getValue());
            this.left.setValue(null);
        }
    }

    private void redirectParentPointer() {
        if (this.amILeftChild()) {
            this.giveMyFatherLeftSon();
        }
        if (this.amIRightChild()) {
            this.giveMyFatherRightSon();
        }
    }

    private void removePointer(Integer searchedValue) {
        //  SETTEA EN NULL AL ÁRBOL QUE TIENE EL VALOR BUSCADO
        if (this.left != null) {
            if (this.left.getValue() == searchedValue)
                this.left.setValue(null);
        }
        if (this.right != null) {
            if (this.right.getValue() == searchedValue)
                this.right.setValue(null);
        }
    }

    private void removeParentPointer() {
        // SI ES UN HIJO IZQUIERDO LO ELIMINA
        if (this.amILeftChild()) {
            this.father.left = null;
        }
        // SI ES UN HIJO DERECHO LO ELIMINA
        if (amIRightChild()) {
            this.father.right = null;
        }
    }

    private boolean amILeftChild() {
        // SI EL PADRE TIENE UN HIJO IZQUIERDO
        return this.getValue() < this.father.getValue();
    }
    private boolean amIRightChild() {
        // SI EL PADRE TIENE UN HIJO DERECHO
        return this.getValue() > this.father.getValue();
    }

    private void replaceValue(Integer newValue) {
            this.setValue(newValue);
    }

    public boolean delete(Integer value) {
        boolean isDeleted = false;

        //  SI EL VALOR BUSCADO ES IGUAL AL VALOR ACTUAL
        if (this.getValue() == value) {

            // SI EL VALOR ENCONTRADO ESTÁ EN UNA HOJA,
            // SETTEA ÁRBOL EN NULL Y REMUEVE EL PUNTERO DE SU PADRE
            if (this.left == null && this.right == null) {
                this.removeParentPointer();
                isDeleted = true;

            // SI EL VALOR ENCONTRADO ESTÁ EN UN ÁRBOL CON UN HIJO,
            // SETTEA ÁRBOL EN NULL Y REDIRECCIONA EL PUNTERO DE SU PADRE
            } else if ((this.left != null && this.right == null) ||
                    (this.left == null && this.right != null)) {
                this.redirectParentPointer();
                isDeleted = true;

            // SI EL VALOR ENCONTRADO ESTÁ EN UN ÁRBOL CON DOS HIJOS,
            // OBTIENE EL MENOR VALOR DE SU ÁRBOL DERECHO,
            // TOMA SU VALOR Y SETTEA AL PADRE DEL ÁRBOL ENCONTRADO EN NULL
            } else if (this.left != null && this.right != null) {
                Integer newValue = this.right.getMinElem();
                this.replaceValue(newValue);
                this.right.removePointer(newValue);
                isDeleted = true;
            }
        } else {
            if (value < this.getValue()) {
                if (this.left != null)
                    isDeleted = this.left.delete(value);
            }
            if (value > this.getValue()) {
                if (this.right != null)
                    isDeleted = this.right.delete(value);
            }
        }
        return isDeleted;

    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public List getElementAtLevel(int height) {
        return this.getElementAtLevel(0, height);
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    private List getElementAtLevel(int amplitudeLevel, int height) {
        List resultList = new ArrayList<Integer>();
        List leftList = new ArrayList<Integer>();
        List righttList = new ArrayList<Integer>();

        // SI LA ALTURA ACTUAL EQUIVALENTE AL VALOR BUSCADO
        // AGREGA EL VALOR A LA LISTA RESULTADO
        if (height == amplitudeLevel) {
            resultList.add(this.getValue());
            return resultList;
        } else {
            // SINO PREGUNTA RECURSIVAMENTE POR IZQUIERDA Y POR DERECHA
            if (this.left != null)
                leftList = this.left.getElementAtLevel(amplitudeLevel + 1, height);
            if (this.right != null)
                righttList = this.right.getElementAtLevel(amplitudeLevel + 1, height);
        }
        // AGREGA LAS LISTAS OBTENIDAS A LA LISTA RESULTADO
        resultList.addAll(leftList);
        resultList.addAll(righttList);
        return resultList;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
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
        // SI EL ÁRBOL ESTABA VACÍO AGREGA EL VALOR DE LA RAÍZ,
        // SINO AGREGA EL VALOR DE LA HOJA EN LA LISTA MÁS LARGA,
        longestList.add(this.getValue());
        return longestList;
    }


    // la complejidad computacional es de O(1)
    private List completeLeftList(List left) {
        left.add(this.getValue());
        return left;
    }


    // la complejidad computacional es de O(1)
    private List completeRightList(List right) {
        right.add(this.getValue());
        return right;
    }


    // Complejidad computacional: O(n)
    // donde n es la suma de la cantidad de elementos de cada lista.
    private List compareSizeList(List leftList, List rightList) {
        if (leftList.size() > rightList.size())
            return leftList;
        else
            return rightList;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public boolean hasElem(Integer value) {
        boolean hasIt = false;

        // SI EL VALOR BUSCADO ES IGUAL AL VALOR ACTUAL
        // SETTEA Y RETORNA VERDADERO
        if (value == this.getValue()) {
            hasIt = true;
            return hasIt;

        // SI EL VALOR BUSCADO ES MAYOR AL VALOR ACTUAL,
        // SI SU HIJO DERECHO EXISTE LLAMA RECURSIVAMENTE POR DERECHA
        } else if (value > this.getValue()) {
            if (this.right != null)
                hasIt = this.right.hasElem(value);

        // SI EL VALOR BUSCADO ES MENOR AL VALOR ACTUAL,
        // SI SU HIJO IZQUIERDO EXISTE LLAMA RECURSIVAMENTE POR IZQUIERDA
        } else if (value < this.getValue()) {
            if (this.left != null)
                hasIt = this.left.hasElem(value);
        }
        return hasIt;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public Integer getMinElem() {
        Integer minLeft = 0;
        if (this.left != null)
            minLeft = this.left.getMinElem();
        else
            minLeft = this.getValue();
        return minLeft;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public Integer getMaxElem() {
        Integer maxRight = 0;
        if (this.right != null)
            maxRight = this.right.getMaxElem();
        else
            return this.getValue();
        return maxRight;
    }

    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
//    public Tree mostLeft() {
//        Tree mostLeft = new Tree();
//        if (this.right != null)
//            mostLeft = this.right.mostLeft();
//        else
//            return this;
//        return mostLeft;
//    }

    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
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


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
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


    // Complejidad computacional: O(1)
    public Integer getRoot() {
        return this.getValue();
    }


    // Complejidad computacional: O(1)
    public boolean isEmpty() {
        return this.getValue() == null;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public int getHeight() {

        // SI LA RAÍZ ES UNA HOJA RETORNA 0
        if (this.left == null && this.right == null) {
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


    // Complejidad computacional: O(1)
    public void setValue(Integer value) {
        this.value = value;
    }

    // Complejidad computacional: O(1)
    public Integer getValue() {
        return this.value;
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public void printPreOrder() {
        if (this.getValue() == null)
            return;

        System.out.print(this.getValue() + " ");

        if (this.left != null)
            this.left.printPreOrder();
        else
            System.out.print(" - ");
        if (this.right != null)
            this.right.printPreOrder();
        else
            System.out.print(" - ");
    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public void printPostOrder() {
        if (this.getValue() == null)
            return;

        if (this.left != null)
            this.left.printPostOrder();
        else
            System.out.print(" - ");

        if (this.right != null)
            this.right.printPostOrder();
        else
            System.out.print(" - ");

        System.out.print(this.getValue() + " ");

    }


    //  Complejidad computacional: (h)
    //  donde h es la altura del árbol
    public void printEnOrder() {
        if (this.getValue() == null)
            return;

        if (this.left != null)
            this.left.printEnOrder();
        else
            System.out.print(" - ");

            System.out.print(this.getValue() + "  ");

        if (this.right != null)
            this.right.printEnOrder();
        else
            System.out.print(" - ");
    }

    // GETTERS & SETTERS

    // Complejidad computacional: O(1)
    private Tree getFather() {
        return this.father;
    }

    // Complejidad computacional: O(1)
    private void setFather(Tree father) {
        this.father = father;
    }

    // Complejidad computacional: O(1)
    private void setLeft(Integer value) {
        this.left.setValue(value);
    }

    // Complejidad computacional: O(1)
    private void setRight(Integer value) {
        this.right.setValue(value);
    }

}
