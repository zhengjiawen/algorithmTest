package main.java;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TreeFindPath {

    public static ArrayList<ArrayList<Integer>> findPath(Node root, int target) {
        if(root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Stack<Integer> path = new Stack<>();

        findOnePath(root,target,path,list,0);
        return list;
    }

    public static void findOnePath(Node root , int target , Stack<Integer> path, ArrayList<ArrayList<Integer>> list, int sum){
        if(root == null){
            return ;
        }

        sum+=root.getValue();
        path.push(root.getValue());

        if(root.getRight()==null && root.getLeft()==null){

            if(sum==target){
                List<Integer> onePath = path.stream().collect(Collectors.toList());
                list.add((ArrayList<Integer>) onePath);
            }
        }
        else{
            findOnePath(root.getLeft(),target,path,list,sum);
            findOnePath(root.getRight(),target,path,list,sum);
        }

        path.pop();

    }

    public static void main(String[] args){
        Node root = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        Node node4 = new Node(4);

        Node node5 = new Node(5);

        Node node6 = new Node(6);

        Node node7 = new Node(7);

        Node node8 = new Node(8);

        Node node9 = new Node(9);

        Node node10 = new Node(10);

        root.setLeft(node3);
        root.setRight(node2);
        node3.setLeft(node6);
        node6.setLeft(node10);
        node6.setRight(node4);
        node2.setLeft(node7);
        node2.setRight(node8);
        node7.setRight(node5);
        node8.setLeft(node9);

        System.out.println(findPath(root,20));
    }
}
