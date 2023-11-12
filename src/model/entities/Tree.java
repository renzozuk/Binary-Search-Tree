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

        setAllHeights(root);
    }

    public void printPreOrder(Node root){
        System.out.print(root.getValue() + " ");

        if(root.getLeft() != null){
            printPreOrder(root.getLeft());
        }

        if(root.getRight() != null){
            printPreOrder(root.getRight());
        }
    }

    public void printInOrder(Node root){
        if(root.getLeft() != null){
            printInOrder(root.getLeft());
        }

        System.out.print(root.getValue() + " ");

        if(root.getRight() != null){
            printInOrder(root.getRight());
        }
    }

    public void printPostOrder(Node root){
        if(root.getLeft() != null){
            printPostOrder(root.getLeft());
        }

        if(root.getRight() != null){
            printPostOrder(root.getRight());
        }

        System.out.print(root.getValue() + " ");
    }

    public void setAllHeights(Node root){
        if(root.getLeft() != null){
            setAllHeights(root.getLeft());
        }

        if(root.getRight() != null){
            setAllHeights(root.getRight());
        }

        root.setHeight();
    }

    public String iterativePreOrder(Node node){
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

    public String iterativeInOrder(Node node){
        Stack<Node> stack = new Stack<>();
        Node currentNode = node;

        StringBuilder result = new StringBuilder();

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            currentNode = stack.pop();

            result.append(currentNode.getValue()).append(" ");

            currentNode = currentNode.getRight();
        }

        return result.toString();
    }

    public String iterativePostOrder(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Stack<Integer> valuesList = new Stack<>();

        while(!stack.empty()){
            Node currentNode = stack.pop();
            valuesList.push(currentNode.getValue());

            if(currentNode.getLeft() != null){
                stack.push(currentNode.getLeft());
            }

            if(currentNode.getRight() != null){
                stack.push(currentNode.getRight());
            }
        }

        StringBuilder result = new StringBuilder();

        while (!valuesList.empty()){
            result.append(valuesList.pop()).append(" ");
        }

        return result.toString();
    }

    public boolean isThereANode(int value){
        return search(root, value) != null;
    }

    public Node search(Node root, int value){
        if(root == null || root.getValue() == value){
            return root;
        }

        if(root.getValue() < value){
            return search(root.getRight(), value);
        }

        return search(root.getLeft(), value);
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
