package application;

import model.entities.Tree;

public class Program {
    public static void main(String[] args) {
        Tree binarySeachTree = new Tree();

        binarySeachTree.start();

        System.out.println(binarySeachTree.isThereANode(5));
        System.out.println(binarySeachTree.isThereANode(7));

        System.out.print("\nPRE-ORDER: ");
        System.out.println(binarySeachTree.iterativePreOrder(binarySeachTree.getRoot()));

        System.out.print("\nSYMMETRIC ORDER: ");
        System.out.println(binarySeachTree.iterativeInOrder(binarySeachTree.getRoot()));

        System.out.print("\nPOST-ORDER: ");
        System.out.println(binarySeachTree.iterativePostOrder(binarySeachTree.getRoot()));
    }
}
