package entregable_2;

public class main_entregable2 {

    public static void main(String[] args) {
        int[] startValues = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
        Tree tree = new Tree(startValues);

        tree.printPreOrder();
//        System.out.println("Nodos fronteras: ");
//        System.out.println(tree.getFrontera());
    }

}
