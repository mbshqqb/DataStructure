package tree;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    public static void main(String args[]) {
        Node root=buildTree("HBDFAEKCG","ABHFDECKG");

    }

    private static Node buildTree(String inorder,String preorder){
        if(preorder.length()==0){
            return null;
        }
        char root=preorder.charAt(0);
        Node node=new Node(root);
        if(preorder.length()==1){
            return node;
        }
        String leftInorder=inorder.substring(0,inorder.indexOf(root));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String rightInorder=inorder.substring(inorder.indexOf(root)+1);
        String[]inorders=inorder.split(String.valueOf(root));
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