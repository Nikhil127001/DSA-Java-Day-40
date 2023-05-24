
import java.util.*;
import java.util.LinkedList;;

public class BinaryTreesB {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTrees(int[] Nodes) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node NewNode = new Node(Nodes[idx]);
            // recursively call for root left and root right
            NewNode.left = BuildTrees(Nodes);
            NewNode.right = BuildTrees(Nodes);
            return NewNode;
        }
    }

    // preorder traversal on Binarytree
    public static void preorder(Node root) {// T.C. -> O(n)

        if (root == null) {
            return;
        }
        // first print root
        System.out.print(root.data);
        // class for left
        preorder(root.left);
        // call for right
        preorder(root.right);
    }

    // In order traversal
    public static void Inorder(Node root) {// T.C. -> O(n)
        if (root == null) {
            return;
        }
        // first print left Node
        Inorder(root.left);
        // print root data
        System.out.print(root.data);
        // print root right data
        Inorder(root.right);

    }

    // post Orderr Traversal
    public static void PostOrder(Node root) {
        if (root == null) {
            return;
        }
        // print left subteree of the the root
        PostOrder(root.left);
        // print right subteree of the the root
        PostOrder(root.right);
        // print root
        System.out.print(root.data);
    }

    public static void LevelOrder(Node root) {
        // if tree is empty then return
        if (root == null) {
            return;
        }

        // Make Queue
        Queue<Node> q = new LinkedList<>();
        // first add the root in the queue
        q.add(root);
        // add the null node to the queue. this can be used further to print next line
        q.add(null);

        // while queue is not empty
        while (!q.isEmpty()) {
            // remove the first element of the queue and store it in the level Node
            Node CurrentNode = q.remove();
            // check if the queue is empty
            if (CurrentNode == null) {
                System.out.println();
                // if Queue is empty then break from the loop
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null); // if the queue is not empty the add null at the and of the queue
                }
            } else {
                // print current Node
                System.out.print(CurrentNode.data);
                // check if current node. left ! = null then add node to the Queue
                if (CurrentNode.left != null) {
                    q.add(CurrentNode.left);
                }
                if (CurrentNode.right != null) {
                    q.add(CurrentNode.right);
                }

            }
        }

    }

    public static int NumOfNodes(Node root) {
        // check if root is null
        if (root == null) {
            return 0;
        }
        // recursively check for left and right of root
        int ln = NumOfNodes(root.left);
        int rn = NumOfNodes(root.right);
        int totalNodes = ln + rn + 1;
        return totalNodes;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        int TotSum = ls + rs + root.data;
        return TotSum;

    }

    public static void main(String args[]) {
        // int[] Nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree b = new BinaryTree();
        // Node root = b.BuildTrees(Nodes);
        // preorder(root);
        // System.out.println();
        // Inorder(root);
        // System.out.println();
        // PostOrder(root);
        // System.out.println();
        // // ** IMP iterative approach
        // LevelOrder(root);

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print(NumOfNodes(root));
        System.out.println();
        System.out.print(height(root));
        System.out.println();
        System.out.print(sum(root));

    }

}