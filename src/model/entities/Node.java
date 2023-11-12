package model.entities;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Integer depth;
    private Integer height;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setHeight(){
        int alt1, alt2;

        if(left != null){
            alt1 = left.getHeight();
        }else{
            alt1 = 0;
        }

        if(right != null){
            alt2 = right.getHeight();
        }else{
            alt2 = 0;
        }

        if(alt1 > alt2){
            height = alt1 + 1;
        }else{
            height = alt2 + 1;
        }
    }
}
