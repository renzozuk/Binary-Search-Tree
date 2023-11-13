package application;

import model.entities.Tree;

public class Program {
    public static void main(String[] args) {
        Tree binarySeachTree = new Tree();

        binarySeachTree.start();

        System.out.println(binarySeachTree.isThereANode(5));
        System.out.println(binarySeachTree.isThereANode(24));

        binarySeachTree.findAllDepths(binarySeachTree.getRoot());
        System.out.println(binarySeachTree.findDepth(binarySeachTree.getRoot(), 9));

        System.out.print("\nPRE-ORDER: ");
        System.out.println(binarySeachTree.iterativePreOrder(binarySeachTree.getRoot()));

        System.out.print("\nSYMMETRIC ORDER: ");
        System.out.println(binarySeachTree.iterativeInOrder(binarySeachTree.getRoot()));

        System.out.print("\nPOST-ORDER: ");
        System.out.println(binarySeachTree.iterativePostOrder(binarySeachTree.getRoot()));

        System.out.print("\nHeight: ");
        System.out.println(binarySeachTree.getRoot().getHeight());

        Tree randomTree = new Tree();

        randomTree.startRandom();

        System.out.print("\nPRE-ORDER: ");
        System.out.println(randomTree.iterativePreOrder(randomTree.getRoot()));

        System.out.print("\nSYMMETRIC ORDER: ");
        System.out.println(randomTree.iterativeInOrder(randomTree.getRoot()));

        System.out.print("\nPOST-ORDER: ");
        System.out.println(randomTree.iterativePostOrder(randomTree.getRoot()));
    }
}
