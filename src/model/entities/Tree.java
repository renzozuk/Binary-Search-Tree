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
        insert(root, 5);
        insert(root, 3);
        insert(root, 8);
        insert(root, 9);
        insert(root, 6);
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

    public boolean search(int value){
        return findNode(root, value) != null;
    }

    public Node findNode(Node node, int value){
        if(node == null || node.getValue() == value){
            return node;
        }

        if(node.getValue() < value){
            return findNode(node.getRight(), value);
        }

        return findNode(node.getLeft(), value);
    }

    public Node insert(Node root, int value){

        if (this.root == null){
            setRoot(new Node(value));

            return this.root;
        }
        else if (root == null){
            root = new Node(value);
        }
        else if (value < root.getValue()){
            root.setLeft(insert(root.getLeft(), value));
        }
        else {
            root.setRight(insert(root.getRight(), value));
        }

        return root;
    }
}
