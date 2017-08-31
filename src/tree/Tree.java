package tree;

import java.util.*;

public class Tree {
    public static void main(String args[]) {
        Node root=buildTree("HBDFAEKCG","ABHFDECKG");
        levelOrder(root);
    }
    private static void preOrder(Node root){
        Node parent=root;
        Stack<Node>stack=new Stack<Node>();
        stack.push(null);
        while (parent!=null){
            System.out.println(parent.data);
            if(parent.right!=null){
                stack.push(parent.right);
            }
            parent=parent.left;
            if(parent==null){
                parent=stack.pop();
            }
        }
    }
    private static void inOrder(Node root){

    }
    private static void levelOrder(Node root){
        Queue<Node>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node parent=queue.poll();
            System.out.println(parent.data);
            if(parent.left!=null){
                queue.offer(parent.left);
            }
            if(parent.right!=null){
                queue.offer(parent.right);
            }
        }
    }


    private static Node buildTree(String inorder,String preorder){
        if(preorder.length()==0){
            return null;
        }
        char parent=preorder.charAt(0);
        Node node=new Node(parent);

        String leftInorder=inorder.substring(0,inorder.indexOf(parent));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String rightInorder=inorder.substring(inorder.indexOf(parent)+1);
        String[]inorders=inorder.split(String.valueOf(parent));
        node.left=buildTree(leftInorder,preorder.substring(1,1+leftInorder.length()));
        node.right=buildTree(rightInorder,preorder.substring(1+leftInorder.length()));
        return node;
    }
}
class Node{
    Node left;
    Node right;
    char data;
    public Node(char data){
        this.data=data;
    }
    @Override
    public String toString() {
        return "["+data+","+left+","+right+"]";
    }
}