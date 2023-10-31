package application;

import model.entities.Node;
import model.entities.Tree;

public class Program {
    public static void main(String[] args) {
        Tree binarySeachTree = new Tree(new Node(5));

        binarySeachTree.start();

        System.out.print("PRE-ORDER: ");
        System.out.print(binarySeachTree.preOrderIterative(binarySeachTree.getRoot()));

        System.out.print("\n\nSYMMETRIC ORDER: ");
        binarySeachTree.symmetricOrder(binarySeachTree.getRoot());


        System.out.print("\n\nPOST-ORDER: ");
        binarySeachTree.postOrder(binarySeachTree.getRoot());


    }
}
