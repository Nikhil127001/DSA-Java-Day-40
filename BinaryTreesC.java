package mypackage;

public class BinaryTreesC {

    // Approach 1 -> T.C. -> O(n^2)
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        // calcule height for left subtree
        int left = height(root.left);
        // calcule height for left subtree
        int right = height(root.right);

        return (Math.max(left, right) + 1);
    }

    // Approach 1 -> T.C. = O(n^2)
    public static int DiameterA(Node root) {
        if (root == null) {
            return 0;
        }
        // calcule left node height
        int lh = height(root.left);
        // calculeate right node height
        int rh = height(root.right);
        // calculate left node diameter
        int ld = DiameterA(root.left);
        // calculate right node diameter
        int rd = DiameterA(root.right);
        // now return max of left diameter, right diameter and left height + right
        // height +1;
        int CurrentNodeDiameter = Math.max(Math.max(ld, rd), lh + rh + 1);
        return CurrentNodeDiameter;
    }

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

    // creating info class related to each node we will store information like
    // diameter and height related to each node into Info class object
    static class Info {
        int Diameter;
        int height;

        public Info(int diam, int ht) {
            this.Diameter = diam;
            this.height = ht;
        }
    }

    // creating function to calculate diameter of the binary tree
    // ** IMP Approach 2 -> T.C. = O(n)
    public static Info Diameter(Node root) {
        // base case
        if (root == null) {
            return new Info(0, 0);
        }

        Info LeftDiameterInfo = Diameter(root.left); // left diameter
        Info RightDiameterInfo = Diameter(root.right);// right diameter

        int Currentdiameter = Math.max(Math.max(LeftDiameterInfo.Diameter, RightDiameterInfo.Diameter),
                LeftDiameterInfo.height + RightDiameterInfo.height + 1);
        int CurrentHeight = Math.max(LeftDiameterInfo.height, RightDiameterInfo.height) + 1;

        return new Info(Currentdiameter, CurrentHeight);
    }

    public static boolean isIdentical(Node root1, Node root2) {
        // find all false conditions first
        // if both the roots become null then return true
        if (root1 == null && root2 == null) {
            return true;
        }
        // conditions for false
        // 1.) if root of parent tree will become null
        // 2.) if root of sub tree become null
        // 3.) if Parent tree node data is not equal to subtree node data
        // return false
        else if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        // otherwise check for left node and right node of the parent tree
        // if the above conditions Not satisfied with the parent left
        if (!isIdentical(root1.left, root2.left)) {
            return false;
        }
        // if the above conditions Not satisfied with the parent right
        if (!isIdentical(root1.right, root2.right)) {
            return false;
        }

        // at last return true if none of the above condition satisfied
        return true;
    }

    public static boolean IsSubtree(Node root1, Node root2) {
        // travel the whole parent tree to find root of the subtree
        if (root1 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            if (isIdentical(root1, root2)) {
                return true;
            }
        }
        return IsSubtree(root1.left, root2) || IsSubtree(root1.right, root2);
    }

    //// full code
    // package mypackage;

    // import java.util.HashMap;
    // import java.util.LinkedList;
    // import java.util.Queue;

    // public class TopViewOFBinary {
    // // 1.)first create Node class
    // static class Node{
    // int data;
    // Node next;
    // Node left;
    // Node right;
    // public Node (int data){
    // this.data = data;
    // this.left = null;
    // this.right = null;
    // }
    // }

    // static class Info{
    // Node node;
    // int horizontaldistance;
    // public Info(Node node, int horizontaldistance){
    // this.node = node;
    // this.horizontaldistance = horizontaldistance;
    // }
    // }

    // // function to calculate topView

    // public static void topView(Node root){
    // Queue <Info> q = new LinkedList<>();
    // HashMap <Integer, Node> H = new HashMap<>();

    // int min = 0;
    // int max = 0;

    // q.add(new Info(root
    // , 0));
    // q.add(null);

    // while(!q.isEmpty()){
    // Info current = q.remove();
    // if(current == null){
    // if(q.isEmpty()){
    // break;
    // }
    // else{
    // q.add(null);
    // }
    // }
    // else{
    // // check if the Horizontal distance of node stored in the hashmap is not
    // repeating. if not repating then add it in the hashmap with its node
    // if(!H.containsKey(current.horizontaldistance)){
    // H.put(current.horizontaldistance, current.node);
    // }
    // // then check for the left part
    // if(current.node.left != null){
    // q.add(new Info(current.node.left, current.horizontaldistance-1));
    // min = Math.min(min, current.horizontaldistance-1);
    // }
    // // then check for the left part
    // if(current.node.right != null){
    // q.add(new Info(current.node.right, current.horizontaldistance + 1));
    // max = Math.max(max,current.horizontaldistance + 1);
    // }
    // }
    // }
    // // at last print the data of the node stored in hashmap
    // for(int i = min ; i<=max; i++){
    // System.out.print(H.get(i).data);
    // }

    // }

    // public static void main (String args[]){
    // //2.) create BST
    // Node root = new Node(1);
    // root.left = new Node(2);
    // root.right = new Node(3);
    // root.left.left = new Node(4);
    // root.left.right = new Node(5);
    // root.right.left = new Node(6);
    // root.right.right = new Node(7);

    // topView(root);
    // }
    // }

    public static void main(String args[]) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // ////Approach 1 -> T.C. -> O(n^2)
        // System.out.print(DiameterA(root));

        //// Approach 2 -> T.C. -> O(n)
        // System.out.print(Diameter(root).Diameter);
        // System.out.print(Diameter(root).height);

        // ** IMP */ check if a tree is a subtree of the given tree
        // 1
        // /\
        // 2 3
        // /\ /\
        // 4 5 6 7
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.right = new Node(7);
        root1.right.left = new Node(6);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        // Subtree

        // 2
        // /\
        // 4 7
        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(5);
        System.out.print(IsSubtree(root1, root2));
    }
}
