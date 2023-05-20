package mypackage;

import java.util.*;
import java.util.LinkedList;

public class BinaryTreesD {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // recursive method
    public static void printKthlevelR(Node root, int level, int track) {

        if (root == null) {
            return;
        }
        if (track == level) {
            System.out.print(root.data);
            return;
        }

        printKthlevelR(root.left, level, track + 1);
        printKthlevelR(root.right, level, track + 1);

    }

    // Iterative method
    public static void printKthlevel(Node root, int level) {

        if (root == null) {
            return;
        }
        // create Queue to store elements

        Queue<Node> q = new LinkedList<>();
        // taking track variable to track if the level come or not
        int track = 0;

        // add first element
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            // take current element
            Node curr = q.remove();
            // if the null come in queue it means that we have to increase the level by one
            if (curr == null) {
                track++;
                // if queue is empty then break from the loop and if the level
                if (q.isEmpty() || track == level) {
                    break;
                } else {
                    // otherwise add the null at the end of the queue to track level
                    q.add(null);
                }
            } else {
                // print if tracking variable of the level is == level - 1 means here the second
                // level null came

                if (track == level - 1) {
                    System.out.print(curr.data);
                }

                if (curr.right != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);

                }
            }
        }
    }

    public static boolean isValid(Node root, int n, ArrayList <Integer> Q){
        // first add ist element in the queue
        if(root == null){
            return false;
        }
        Q.add(root.data);

        if( root.data == n){
            return true;
        }
        boolean left = isValid(root.left, n, Q);
        boolean right =isValid(root.right, n, Q);

        if(left || right){
            return true;
        }
        Q.remove(Q.size()-1);
        return false;
    }

    public static boolean FindPath(Node root, int n, ArrayList<Node> a){
        if (root == null){
          return false;
        }
    
        a.add(root);
        if(root.data == n ){
          return true;
        }
    
        // find in the left node of the root node
        boolean left = FindPath(root.left,n,a);
        //find in the right of the root
    
        boolean right = FindPath(root.right,n,a);
    
        if(left || right){
            return true;
        }
        a.remove(a.size()-1);
        return false;
      }

    public static Node LowestCommonAnsistor(Node root, int n1, int n2){
        // createArrayList to insert path elements to n1
        ArrayList <Node> q = new ArrayList<>();
        // create second ArrayList to store elements in the path to the n2
        ArrayList <Node> q2 = new ArrayList<>();
    
        // Now create Find Patrh function to store elements in path to n1 in array q
        FindPath(root, n1, q);
        // Now create Find Patrh function to store elements in path to n2 in array q2
        FindPath(root,n2,q2);
    
        // traverse through both the paths and find the common node ;
        Node lastCommonAnsistror =null;
        for(int i =0; i<q.size() && i<q2.size(); i++){
          if(q.get(i).data == q2.get(i).data){
            
            lastCommonAnsistror = q.get(i);
          }
        }
        // System.out.print(lastCommonAnsistror.data);
        return lastCommonAnsistror;
      }
      
  public static int FindDistance(Node root, int n){
    // if root is equal to null then return -1;
    if(root == null){
      return -1;
    }
    // if root dtaa == the number we want to find then return 0;
    if(root.data == n){
      return 0;
    }
    // then check the conditions fort the left Node
    int leftDistance = FindDistance(root.left, n);
    // check the conditions for the right node
    int rightDistance = FindDistance(root.right, n);


    // check if the left node returns -1 and right Node returns -1 the return -1 to the root node
    if(leftDistance == -1 && rightDistance == -1){
      return -1;
    }
    // if only right node returns -1 themn return return from right node + 1
    else if( rightDistance == -1){
      return leftDistance+1;
    }
    // simarly if only left node returns -1 then return , return from right node + 1
    else{
      return rightDistance+1;
    }

  }

  public static void FindMinDistance(Node root, int n1 , int n2){
    // Lowest common ansistor Node 
    Node LCA = LowestCommonAnsistor(root, n1, n2);

    // find distance from the one number n1
    int DistanceFromLeft = FindDistance(LCA, n1);
     // find distance from the second number n2
    int DistanceFromright = FindDistance(LCA, n2);

    System.out.print(DistanceFromLeft+ DistanceFromright);
  }


    

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // root.right.right.right = new Node(8);
        // root.right.right.left = new Node(11);
        // root.left.left.left = new Node(9);
        // root.left.left.right = new Node(10);
        // printKthlevel(root, 4);

        // printKthlevelR(root, 3, 1);

        // int a = 6;
        // int b = 7;
        LowestCommonAnsistor(root, 6, 7);
        // minimum distance between two nodes
         int a = 6;
        int b = 5;

        FindMinDistance(root, a, b);

    }

}
