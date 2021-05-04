package entregable_2;

public class main_entregable2 {

    public static void main(String[] args) {
        Integer[] startValues = new Integer[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
        Tree tree = new Tree(startValues);

        System.out.println("Pre Orden");
        tree.printPreOrder();
        System.out.println("\nPos Orden");
        tree.printPostOrder();
        System.out.println("\nEn Orden");
        tree.printEnOrder();
        System.out.println("\nHojas del árbol: ");
        System.out.println(tree.getFrontera());
        System.out.println("\nAltura: ");
        System.out.println(tree.getHeight());
        System.out.println("\nMáximo: ");
        System.out.println(tree.getMaxElem());
        System.out.println("\nMínimo: ");
        System.out.println(tree.getMinElem());
        System.out.println("\nContiene valor: ");
        System.out.println(tree.hasElem(6));
        System.out.println("\nRama más larga: ");
        System.out.println(tree.getLongestBranch());
        System.out.println("\nValores de un nivel: ");
        System.out.println(tree.atElement(3));
    }

}
