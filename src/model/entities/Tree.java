package model.entities;

import model.util.FileManager;
import model.util.NumberGenerator;

import java.util.List;
import java.util.Set;
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
        insert(root, 20);
        insert(root, 30);
        insert(root, 28);
        insert(root, 29);
        insert(root, 40);
        insert(root, 41);
        insert(root, 15);
        insert(root, 18);
        insert(root, 13);
        insert(root, 12);
        insert(root, 14);
        insert(root, 27);
        insert(root, 39);
        insert(root, 19);
        insert(root, 17);
    }

    public void startRandom(){
        Set<Integer> list = NumberGenerator.numberGenerator();

        for (Integer number : list) {
            insert(root, number);
        }
    }

    public void startGivenTree(){
        List<Integer> givenNumbers = FileManager.readFirstFile();

        if (givenNumbers != null) {
            for (Integer number : givenNumbers) {
                insert(root, number);
            }
        }

        List<String> givenCommands = FileManager.readSecondFile();

        if (givenCommands != null) {
            for (String command : givenCommands) {
                String[] parameters = command.split(" ");

                switch(parameters[0].toUpperCase()){
                    case "ENESIMAL", "ENESIMO":
                        System.out.println("ENÉSIMO: " + nthElement(root, Integer.parseInt(parameters[1])));
                        break;
                    case "POSITION", "POSICAO":
                        System.out.println("POSIÇÃO: " + position(Integer.parseInt(parameters[1])));
                        break;
                    case "MEDIAN", "MEDIANA":
                        break;
                    case "PERFECT", "CHEIA":
                        System.out.println("CHEIA: " + isPerfect(root, getDeeper(root)));
                        break;
                    case "COMPLETE", "COMPLETA":
                        System.out.println("COMPLETA: " + isComplete(root));
                        break;
                    case "PRINT", "IMPRIMA":
                        printTree(Integer.parseInt(parameters[1]));
                        break;
                    case "REMOVE", "REMOVA":
                        remove(root, Integer.parseInt(parameters[1]));
                        break;
                    default:
                        throw new IllegalArgumentException("An invalid command was received. The only valid commands are ENESIMO, POSICAO, MEDIANA, CHEIA, COMPLETA, IMPRIMA or REMOVA.");
                }
            }
        }
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

    public int findDepth(Node root, int value){
        if(root == null){
            return -1;
        }

        int distance = -1;

        if((root.getValue() == value) ||
            (distance = findDepth(root.getLeft(), value)) >= 0 ||
            (distance = findDepth(root.getRight(), value)) >= 0){
            return distance + 1;
        }

        return distance;
    }

    public void findAllDepths(Node root){
        root.setDepth(findDepth(this.root, root.getValue()));

        if(root.getLeft() != null){
            findAllDepths(root.getLeft());
        }

        if(root.getRight() != null){
            findAllDepths(root.getRight());
        }
    }

    public void findAllHeights(Node root){
        if(root.getLeft() != null){
            findAllHeights(root.getLeft());
        }

        if(root.getRight() != null){
            findAllHeights(root.getRight());
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

            this.root.setHeight(1);
            return this.root;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (root == null){
            root = new Node(value);
        }
        else if (value == root.getValue()){
            System.out.println("Elemento " + value + " já existe.");
            return root;
        }
        else if (value < root.getValue()){

            root.setLeft(insert(root.getLeft(), value));
            leftHeight = root.getLeft().getHeight();

            if (root.getRight() != null) {
                rightHeight = root.getRight().getHeight();
            }
        }
        else {
            root.setRight(insert(root.getRight(), value));
            rightHeight = root.getRight().getHeight();

            if (root.getLeft() != null) {
                leftHeight = root.getLeft().getHeight();
            }
        }

        root.setHeight(Math.max(rightHeight, leftHeight) + 1);

        return root;
    }

    public Node remove(Node root, int value){
        if(root == null){
            return root;
        }

        if(root.getValue() > value){
            root.setLeft(remove(root.getLeft(), value));
            return root;
        }else if(root.getValue() < value){
            root.setRight(remove(root.getRight(), value));
            return root;
        }

        if(root.getLeft() == null){
            return root.getRight();
        }else if(root.getRight() == null){
            return root.getLeft();
        }else{
            Node successorParent = root;

            Node successor = root.getRight();

            while(successor.getLeft() != null){
                successorParent = successor;
                successor = successor.getLeft();
            }

            if(successorParent != root){
                successorParent.setLeft(successor.getRight());
            }else{
                successorParent.setRight(successor.getLeft());
            }

            root.setValue(successor.getValue());

            return root;
        }

    }

    public int getSize(Node root){
        return countNodes(root);
    }

    public int countNodes(Node root){
        if (root == null){
            return 0;
        }
        else {
             return  1 + (countNodes(root.getLeft()) + countNodes(root.getRight()));
        }

    }

    public double calculateMean(Node root){

        if (root == null){
            return 0;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        int sumValues = 0;

        while(!stack.isEmpty()){
            Node aux = stack.pop();
            sumValues += aux.getValue();

            if(aux.getRight() != null){
                stack.push(aux.getRight());
            }

            if(aux.getLeft() != null){
                stack.push(aux.getLeft());
            }
        }

        int sizeTree = getSize(root);

        return (double) sumValues / sizeTree;

    }

    public void printNodeFirstFormat(Node node){
        for (int i = 0; i < node.getDepth(); i++) {
            System.out.print("          ");
        }
        System.out.print(node.getValue());
        for (int i = 0; i < root.getHeight() - node.getDepth(); i++) {
            System.out.print("----------");
        }
    }

    public void printGivenLevel(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 1){
            printNodeFirstFormat(node);
            System.out.println();
        }else if(level > 1){
            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);
        }
    }

    public void printTreeFirstFormat(){
        for (int i = 1; i < root.getHeight() + 1; i++) {
            printGivenLevel(this.root, i);
        }
    }

    public void printTreeSecondFormat(Node root){
        System.out.print("(" + root.getValue());

        if(root.getLeft() != null){
            System.out.print(" ");
            printTreeSecondFormat(root.getLeft());
        }

        if(root.getRight() != null){
            System.out.print(" ");
            printTreeSecondFormat(root.getRight());
        }

        System.out.print(")");
    }

    public void printTree(int s){
        switch(s){
            case 1:
                printTreeFirstFormat();
                break;
            case 2:
                printTreeSecondFormat(root);
                System.out.println();
                break;
            default:
                throw new IllegalArgumentException("1 and 2 are the only valid arguments for the printTree method.");
        }
    }

    public boolean isComplete(Node root){

        if (root == null){
            return false;
        }

        int size = getSize(root);
        int height = root.getHeight();

        return Math.pow(2, height - 1) <= size && size <= Math.pow(2, height) - 1;
    }

    public boolean isPerfect(Node root, int deeper){

        if (root == null){
            return true;
        }

        boolean left;
        boolean right;
        if (root.getLeft() != null && root.getRight() != null){
            left = isPerfect(root.getLeft(), deeper);
            right = isPerfect(root.getRight(), deeper);
        }
        else {
            return deeper == root.getDepth();
        }

        return left && right;

    }

    public int getDeeper(Node root){

        if (root == null){
            return 0;
        }

        int leftDepth = 0;
        int rightDepth = 0;

        if (root.getLeft() != null){
            leftDepth = getDeeper(root.getLeft());
        }

        if (root.getRight() != null){
            rightDepth = getDeeper(root.getRight());
        }

        if (root.getRight() == null && root.getLeft() == null){
            return root.getDepth();
        }

        return Math.max(leftDepth, rightDepth);

    }

    public int nthElement(Node root, int n){

        if (root == null){

            System.out.println("Tree is empty.");

            return -1;
        }

        if (n > getSize(root)){
            throw new IndexOutOfBoundsException();
        }

        int idx = 1;

        int target = 0;
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            if (n == idx){
                target = stack.pop().getValue();
                break;
            }
            else {
                idx++;
                currentNode = stack.pop();
            }

            currentNode = currentNode.getRight();
        }

        return target;

    }

    public int position(int value){
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        int position = 1;

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            currentNode = stack.pop();

            if(currentNode.getValue() == value){
                return position;
            }

            position++;

            currentNode = currentNode.getRight();
        }

        return -1;
    }
}