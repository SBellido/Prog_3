package entregable_2;

public class main_entregable2 {

    public static void main(String[] args) {
        // Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
        Integer[] initValues = new Integer[] { 15, 4, 1, 0, 25, 50, 6, 8, 9, 20, 23, 22, 5, 55, 54, 30, 27, 60, 28, 7 };
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

        Integer valueDelete = 50;
        System.out.println("\nPre orden");
        MyTree.printPreOrder();
//        MyTree.add(23);
//        MyTree.add(3);
//        MyTree.delete(50);
        System.out.println("\nSe borró el " + valueDelete);
        MyTree.delete(valueDelete);

        MyTree.printPreOrder();
//        System.out.println( MyTree.getMaxElem() );
//        System.out.println( MyTree.getHeight() );
//        System.out.println( MyTree.getLongestBranch() );
//        System.out.println( MyTree.getElementAtLevel(2) );
//        System.out.println( MyTree.getFrontera() );

//        MyTree.add(65);
//        MyTree.delete(6);
//        MyTree.delete(15);
//        MyTree.add(55);

//          MyTree.printPreOrder();
//        System.out.println( MyTree.getMaxElem() );
//        System.out.println( MyTree.getHeight() );
//        System.out.println( MyTree.getLongestBranch() );
//        System.out.println( MyTree.getElementAtLevel(2) );
//        System.out.println( MyTree.getFrontera() );
    }

}
