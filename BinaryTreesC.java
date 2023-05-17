package mypackage;

public class BinaryTreesC {

    // Approach 1 -> T.C. ->  O(n^2)
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        // calcule height for left subtree
        int left = height(root.left);
        // calcule height for left subtree
        int right = height(root.right);
        
        return (Math.max(left, right) +1);
    }

    //Approach 1 -> T.C. = O(n^2)
    public static int DiameterA(Node root){
        if(root == null){
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
        // now return max of left diameter, right diameter and left height + right height +1;
        int CurrentNodeDiameter = Math.max(Math.max(ld,rd),lh+rh+1);
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

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ////Approach 1 -> T.C. ->  O(n^2) 
         System.out.print(DiameterA(root));

        ////Approach 2 -> T.C. ->  O(n) 
        // System.out.print(Diameter(root).Diameter);
        // System.out.print(Diameter(root).height);
    }
}
