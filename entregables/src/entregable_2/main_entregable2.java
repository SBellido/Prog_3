package entregable_2;

public class main {
    public static void main() {
        Tree tree = new Tree(50);

        tree.add(33);
        tree.add(60);
        tree.add(40);
        tree.add(55);
        tree.add(77);


        System.out.println("Nodos fronteras: ");
        System.out.println(tree.getFrontera());
    }

}
