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
  public static void main(String args[]){
    // level order traversing in the binary tree
    Node root = new Node(1);
    root.right = new Node(3);
    root.left = new Node(2);
    root.left.left  = new Node(4);
    root.right.right = new Node(7);
    root.left.right = new Node(5);
    root.right.left  = new Node(6);

    levelOrder(root);

  }
}
