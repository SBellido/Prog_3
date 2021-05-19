package entregable_2;

public class main_entregable2 {

    public static void main(String[] args) {
        // Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
        Integer[] initValues = new Integer[] { 15, 4, 1, 25, 50, 6, 7, 20, 5, 30 };
        Tree MyTree = new Tree(initValues);

        System.out.println("\nEn orden");
        MyTree.printEnOrder();

        System.out.println("\nPre orden");
        MyTree.printPreOrder();

        System.out.println("\nMáximo valor");
        System.out.println( MyTree.getMaxElem() );

        System.out.println("\nAltura del árbol");
        System.out.println( MyTree.getHeight() );

        System.out.println("\nRama más larga");
        System.out.println( MyTree.getLongestBranch() );

        System.out.println("\nElementos de un nivel dado");
        System.out.println( MyTree.getElementAtLevel(1) );

        System.out.println("\nHojas del árbol");
        System.out.println( MyTree.getFrontera() );

        System.out.println("\nPre orden");
        MyTree.printPreOrder();

        Integer valueAdd = 23;
        System.out.println("\nSe agregó el " + valueAdd);
        MyTree.add(valueAdd);

        Integer valueAdd1 = 3;
        System.out.println("\nSe agregó el " + valueAdd1);
        MyTree.add(valueAdd1);

        System.out.println("\nPre orden");
        MyTree.printPreOrder();

        System.out.println("\nMáximo valor");
        System.out.println( MyTree.getMaxElem() );

        System.out.println("\nAltura del árbol");
        System.out.println( MyTree.getHeight() );

        System.out.println("\nRama más larga");
        System.out.println( MyTree.getLongestBranch() );

        System.out.println("\nElementos de un nivel dado");
        System.out.println( MyTree.getElementAtLevel(2) );

        System.out.println("\nHojas del árbol");
        System.out.println( MyTree.getFrontera() );

        Integer valueAdd3 = 65;
        System.out.println("\nSe agregó el " + valueAdd3);
        MyTree.add(valueAdd3);

        Integer valueDelete = 6;
        System.out.println("\nSe borró el " + valueDelete);
        MyTree.delete(valueDelete);

        Integer valueDelete1 = 15;
        System.out.println("\nSe borró el " + valueDelete1);
        MyTree.delete(valueDelete1);

        Integer valueAdd4 = 55;
        System.out.println("\nSe agregó el " + valueAdd4);
        MyTree.add(valueAdd4);

        System.out.println("\nPre orden");
        MyTree.printPreOrder();

        System.out.println("\nMáximo valor");
        System.out.println( MyTree.getMaxElem() );

        System.out.println("\nAltura del árbol");
        System.out.println( MyTree.getHeight() );

        System.out.println("\nRama más larga");
        System.out.println( MyTree.getLongestBranch() );

        System.out.println("\nElementos de un nivel dado");
        System.out.println( MyTree.getElementAtLevel(2) );

        System.out.println("\nHojas del árbol");
        System.out.println( MyTree.getFrontera() );
    }

}
