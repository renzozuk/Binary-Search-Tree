package application;

import model.entities.Tree;

public class Program {
    public static void main(String[] args) {
        Tree binarySeachTree = new Tree();

        binarySeachTree.start();

        System.out.println(binarySeachTree.search(5));
        System.out.println(binarySeachTree.search(7));

        System.out.print("\nPRE-ORDER: ");
        System.out.print(binarySeachTree.preOrderIterative(binarySeachTree.getRoot()));

        System.out.print("\n\nSYMMETRIC ORDER: ");
        binarySeachTree.symmetricOrder(binarySeachTree.getRoot());

        System.out.print("\n\nPOST-ORDER: ");
        binarySeachTree.postOrder(binarySeachTree.getRoot());

    }
}
