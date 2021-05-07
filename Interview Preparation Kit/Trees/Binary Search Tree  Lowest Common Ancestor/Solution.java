import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

static Node lca(Node root,int v1,int v2)//assume is already ancestor
    {
        //go down path where root is ancestor of both 
    
        if(!isAncestorOf(root, v1) || !isAncestorOf(root, v2)) return null;
        //at this point root is def ancestor of v1 and v2
        
        Node lcaLeft = lca(root.left, v1, v2);
        Node lcaRight = lca(root.right, v1, v2);
        if(lcaLeft==null && lcaRight==null) return root;//neither child is ancestor of both
        if(lcaLeft==null){//right child is ancestor of both
            return lcaRight;
        }else if(lcaRight==null){//left child is ancestor of both
            return lcaLeft;
        }
        //both children cannot be ancestors of both v1 and v2
        return null;
    }

static boolean isAncestorOf(Node root, int data){
    if(root==null) return false;
    if(root.data==data) return true;
    return isAncestorOf(root.left, data) || isAncestorOf(root.right, data);
}


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}