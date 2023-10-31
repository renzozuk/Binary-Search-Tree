package model.entities;

import java.util.Stack;

public class Tree {
    private Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void start(){
        root.setLeft(new Node(3));
        root.setRight(new Node(8));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));
    }

    public void preOrder(Node node){
        System.out.print(node.getValue() + " ");

        if(node.getLeft() != null){
            preOrder(node.getLeft());
        }

        if(node.getRight() != null){
            preOrder(node.getRight());
        }
    }

    public void symmetricOrder(Node node){
        if(node.getLeft() != null){
            symmetricOrder(node.getLeft());
        }

        System.out.print(node.getValue() + " ");

        if(node.getRight() != null){
            symmetricOrder(node.getRight());
        }
    }

    public void postOrder(Node node){
        if(node.getLeft() != null){
            postOrder(node.getLeft());
        }

        if(node.getRight() != null){
            postOrder(node.getRight());
        }

        System.out.print(node.getValue() + " ");
    }

    public String preOrderIterative(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        StringBuilder result = new StringBuilder();

        while(!stack.empty()){
            Node aux = stack.pop();
            result.append(aux.getValue()).append(" ");

            if(aux.getRight() != null){
                stack.push(aux.getRight());
            }

            if(aux.getLeft() != null){
                stack.push(aux.getLeft());
            }
        }

        return result.toString();
    }
}
