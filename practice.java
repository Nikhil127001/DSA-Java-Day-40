import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class practice {

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

  public static void levelOrder(Node root) {
    // ArrayList <Integer> b = new ArrayList<>();
    if (root == null) {
      return;
    }
    Queue<Node> a = new LinkedList<>();

    a.add(root);
    a.add(null);

    while (!a.isEmpty()) {
      Node curr = a.remove();
      if (curr == null) {
        System.out.println();
        if (a.isEmpty()) {
          break;
        } else {
          a.add(null);
        }
      } else {
        System.out.print(curr.data);
        if (curr.left != null) {
          a.add(curr.left);
        }
        if (curr.right != null) {
          a.add(curr.right);
        }
      }
    }
  }

  public static boolean CheckUnivalued(Node root, int x) {
    if (root == null) {
      return true;
    }

    if (root.data != x) {
      return false;
    }
    boolean left = CheckUnivalued(root.left, x);
    boolean right = CheckUnivalued(root.right, x);

    if (left && right) {
      return true;
    } else {
      return false;
    }
  }

  public static void FindMirrorImage(Node root) {
    if (root == null) {
      return;
    }
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
    FindMirrorImage(root.left);
    FindMirrorImage(root.right);
  }

  public static boolean CheckMI(Node root1, Node root2) {

    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1.data == root2.data) {
      return true;
    }

    boolean left = CheckMI(root1.left, root2.left);
    boolean right = CheckMI(root1.right, root2.right);

    if (left || right) {
      return true;
    } else {
      return false;
    }
  }

  public static Node removeLeafes(Node root, int x) {
    if (root == null) {
      return null;
    }

    root.left = removeLeafes(root.left, x);
    root.right = removeLeafes(root.right, x);

    if (root.left == null && root.right == null && root.data == x) {

      return null;
    }
    return root;

  }

  public static String findAllDups(Node root, HashMap<String, Integer> m) {
    String str = "";
    if (root == null) {
      return "";
    }

    str += findAllDups(root.left, m);
    str += Integer.toString(root.data);
    str += findAllDups(root.right, m);

    // if the hashmap contains key and its value is equal to 1 then print the data
    // of the root in str you want to add in map in next step
    if (m.get(str) != null && m.get(str) == 1) {
      System.out.print(root.data);
    }
    // if hashmap contains key str then put it in the hashmap and updateits value to
    // val + 1
    if (m.containsKey(str)) {
      m.put(str, m.get(str) + 1);
      // if it doesnot contains key str then add it with its value is equal to 1
    } else {
      m.put(str, 1);
    }

    return str;
  }

  public static void printAllDups(Node root) {
    // using hashmap because hashMap contains Unique keys with their last updataed
    // values
    HashMap<String, Integer> m = new HashMap<>();
    findAllDups(root, m);
  }

  public static int FindMaxPath(Node root, int MaxPath) {
    if (root == null) {
      return 0;
    }

    int LeftSum = FindMaxPath(root.left, MaxPath);
    int rightSum = FindMaxPath(root.right, MaxPath);
    int totPathSum = LeftSum + root.data + rightSum;
    MaxPath = Math.max(MaxPath, totPathSum);
    System.out.print(MaxPath);
    return totPathSum;
  }

  static class Res {
    public int val;
  }

  static class Solution {
    Node root;

    int findMaxUtil(Node node, Res res) {
      if (node == null)
        return 0;
      int l = findMaxUtil(node.left, res);
      int r = findMaxUtil(node.right, res);
      int max_single = Math.max(Math.max(l, r) + node.data,
          node.data);
      int max_top = Math.max(max_single, l + r + node.data);
      res.val = Math.max(res.val, max_top);
      return max_single;
    }

    int findMaxSum() {
    return findMaxSum(root);
    }

    int findMaxSum(Node node) {
      Res res = new Res();
      res.val = Integer.MIN_VALUE;
      findMaxUtil(node, res);
      return res.val;
    }
  }
  

    public static void main(String[] args) {
      // Question 1 :
      // Check if a Binary Tree is univalued or not
      // We have a binary tree, the task is to check if the binary tree is univalued
      // or not. If found to be
      // true, then print “YES”. Otherwise, print “NO”.
      // Sample Input 1 :
      // Sample Output 1 : false

      // Sol ->
      // Node root = new Node(1);
      // root.left = new Node(1);
      // root.right = new Node(1);
      // root.left.left = new Node(1);
      // root.left.right = new Node(1);
      // root.right.right = new Node(1);
      // root.right.left = new Node(1);

      // int x = root.data;
      // System.out.print(CheckUnivalued(root, x));

      // Question 2 :
      // Invert Binary Tree
      // Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with
      // left and right
      // children of all non-leaf nodes interchanged.
      // Input1 : fig. above
      // Output1 : Yes

      // Sol ->

      // Node root = new Node(1);
      // root.left = new Node(2);
      // root.right = new Node(3);
      // root.left.left = new Node(4);
      // root.left.right = new Node(5);
      // root.right.right = new Node(7);
      // root.right.left = new Node(6);

      // levelOrder(root);

      // FindMirrorImage(root);

      // levelOrder(root);

      //// check if two binary trees are mirror images of each other

      // // Btree 1
      // Node root = new Node(1);
      // root.left = new Node(2);
      // root.right = new Node(3);
      // root.left.left = new Node(4);
      // root.left.right = new Node(5);
      // root.right.right = new Node(7);
      // root.right.left = new Node(6);

      // // Btree2
      // Node root1 = new Node(1);
      // root1.left = new Node(3);
      // root1.right = new Node(2);
      // root1.left.left = new Node(8);
      // root1.left.right = new Node(6);
      // root1.right.left = new Node(5);
      // root1.right.right = new Node(4);

      // System.out.print(CheckMI(root,root1));

      // Question 3 :
      // Delete leaf nodes with values as x
      // We have a binary tree and a target integer x, delete all the leaf nodes
      // having value as x. Also,
      // delete the newly formed leaves with the target value as x.
      // :

      // Node root1 = new Node(1);
      // root1.left = new Node(3);
      // root1.right = new Node(3);
      // root1.left.left = new Node(3);
      // root1.left.right = new Node(2);

      // int n =3;
      // removeLeafes(root1, n);
      // levelOrder(root1);

      // **IMP */ Question 4 :
      // Find All Duplicate Subtrees
      // We have a binary tree, find all duplicate subtrees. For each duplicate
      // subtree, we only need to
      // return the root node of any one of them. Two trees are duplicates if they
      // have the same
      // structure with the same node values.
      // Input1:
      // 1
      // / \
      // 4 3
      // / / \
      // 3 4 3
      // /
      // 3
      // Output1: 4-3 , 3

      // Node root = null;
      // root = new Node(1);
      // root.left = new Node(4);
      // root.right = new Node(3);
      // root.left.left = new Node(3);
      // root.right.left = new Node(4);
      // root.right.left.left = new Node(3);
      // root.right.right = new Node(3);
      // printAllDups(root);

      // Question 5 :
      // Maximum Path Sum in a Binary Tree
      // We have a binary tree, find the maximum path sum. The path may start and end
      // at any node in
      // the tree.
      // Input1:
      // kumarnikhil2111@gmail.com
      // 4
      // / \
      // 2 7
      // Output1: 13
      // Input2:
      // ;
      // Output2: 42

      Solution tree = new Solution();
      tree.root = new Node(10);
      tree.root.left = new Node(2);
      tree.root.right = new Node(10);
      tree.root.left.left = new Node(20);
      tree.root.left.right = new Node(1);
      tree.root.right.right = new Node(-25);
      tree.root.right.right.left = new Node(3);
      tree.root.right.right.right = new Node(4);
      System.out.println("maximum path sum is : " +
          tree.findMaxSum());

    }
}