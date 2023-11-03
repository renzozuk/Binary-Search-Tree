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
        insert(5);
        insert(3);
        insert(8);
        insert(9);
        insert(6);
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

    public void insert(int value){

        Node newNode = new Node(value);

        if (root == null){
            root = newNode;
        }
        else {

            Node aux = root;

            while (true){
                if (newNode.getValue() < aux.getValue()) {
                    if (aux.getLeft() == null){
                        aux.setLeft(newNode);
                        break;
                    }
                    else {
                        aux = aux.getLeft();
                    }
                }
                else {
                    if (newNode.getValue() > aux.getValue()){
                        if (aux.getRight() == null){
                            aux.setRight(newNode);
                            break;
                        }
                        else {
                            aux = aux.getRight();
                        }
                    }
                }
            }
        }
    }
}
