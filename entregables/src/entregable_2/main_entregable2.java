package entregable_2;

public class main_entregable2 {

    public static void main(String[] args) {
        // Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
        Integer[] initValues = new Integer[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
        Tree MyTree = new Tree(initValues);

        MyTree.printEnOrder();
 //       MyTree.printPreOrder();
        System.out.println( MyTree.getMaxElem() );
        System.out.println( MyTree.getHeight() );
        System.out.println( "rama más larga "+MyTree.getLongestBranch() );
        System.out.println( MyTree.getElementAtLevel(2) );
        System.out.println( MyTree.getFrontera() );

//        MyTree.add(23);
//        MyTree.add(3);
        MyTree.delete(4);
//        MyTree.delete(30);
//
//        MyTree.printPreOrder();
//        System.out.println( MyTree.getMaxElem() );
//        System.out.println( MyTree.getHeight() );
//        System.out.println( MyTree.getLongestBranch() );
//        System.out.println( MyTree.getElementAtLevel(2) );
//        System.out.println( MyTree.getFrontera() );
//
//        MyTree.add(65);
//        MyTree.delete(5);
//        MyTree.delete(15);
//        MyTree.add(55);

        MyTree.printPreOrder();
//        System.out.println( MyTree.getMaxElem() );
//        System.out.println( MyTree.getHeight() );
//        System.out.println( MyTree.getLongestBranch() );
//        System.out.println( MyTree.getElementAtLevel(2) );
//        System.out.println( MyTree.getFrontera() );
    }

}
