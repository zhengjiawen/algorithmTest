package main.java;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印
* */
public class TreePrintTest {
    private List<Integer> list = new ArrayList<>();
    private Queue<Node> queue = new ConcurrentLinkedQueue<Node>();

    public  void printTree(Node root){
        if(root == null){
            return;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            list.add(currentNode.getValue());

            if(currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());
            }

            if(currentNode.getRight() != null){
                queue.add(currentNode.getRight());
            }
        }

        Collections.reverse(list);

    }

    public static void main(String[] args){
        Node root = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        Node node4 = new Node(4);

        Node node5 = new Node(5);

        Node node6 = new Node(6);

        Node node7 = new Node(7);

        root.setLeft(node2);
        root.setRight(node3);

 //       node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);


        TreePrintTest test = new TreePrintTest();
        test.printTree(root);
        System.out.println(test.getList());
    }

    public List<Integer> getList() {
        return list;
    }
}

class Node{
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
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


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
