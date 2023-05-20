package mypackage;

import java.util.*;
import java.util.LinkedList;

public class practice {
  static class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static void levelOrder(Node root){


    if(root == null){
      return;
    }
    Queue <Node> q = new LinkedList<>();

    q.add(root);
    q.add(null);

    while(!q.isEmpty()){
      Node curr = q.remove();
      if(curr == null){
        System.out.println();
        if(q.isEmpty()){
          break;
        }
        else{
          q.add(null);
        }
      }
      else{
        System.out.print(curr.data);

        if(curr.left != null){
          q.add(curr.left);
        }
        if(curr.right != null){
          q.add(curr.right);
        }
        
      }
    }
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

    if(root == null){
      return -1;
    }

    if(root.data == n){
      return 0;
    }

    int leftDistance = FindDistance(root.left, n);
    int rightDistance = FindDistance(root.right, n);

    if(leftDistance == -1 && rightDistance == -1){
      return -1;
    }
    else if( rightDistance == -1){
      return leftDistance+1;
    }
    else{
      return rightDistance+1;
    }

  }

  public static void FindMinDistance(Node root, int n1 , int n2){
    // Lowest common ansistor Node 
    Node LCA = LowestCommonAnsistor(root, n1, n2);

    // find height 

    int DistanceFromLeft = FindDistance(LCA, n1);
    int DistanceFromright = FindDistance(LCA, n1);

    System.out.print(DistanceFromLeft+ DistanceFromright);
  }
  public static void main(String args[]){
    // level order traversing in the binary tree
    Node root = new Node(1);
    root.right = new Node(3);
    root.left = new Node(2);
    root.left.left  = new Node(4);
    root.right.right = new Node(7);
    root.left.right = new Node(5);
    root.right.left  = new Node(6);
    // levelOrder(root);
    int a = 5;
    int b= 6;

    // LowestCommonAnsistor(root, a,b) ;
    FindMinDistance(root, a, b);

  }
}
