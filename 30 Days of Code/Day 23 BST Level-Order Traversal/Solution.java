import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

static void levelOrder(Node root){
    //Write your code here
    if (root == null) return;
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(root);
    while (queue.size() != 0) {
        Node temp = queue.poll();
        System.out.print(temp.data + " ");
        if (temp.left != null) queue.offer(temp.left);
        if (temp.right != null) queue.offer(temp.right);
    }
}
public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}