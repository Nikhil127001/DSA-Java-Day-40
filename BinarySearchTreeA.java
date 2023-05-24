import java.util.*;
import java.util.LinkedList;

public class BinarySearchTreeA {
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

    public static Node CreateBST(Node root, int n) {
        // if root == null then return that root so that we can use it for next
        // iteration
        if (root == null) {
            root = new Node(n);
            return root;
        }

        if (root.data > n) {
            root.left = CreateBST(root.left, n);
        }

        else {
            root.right = CreateBST(root.right, n);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root.data);
        preOrder(root.right);
    }

    public static boolean SearchNode(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        } else if (root.data < key) {
            return SearchNode(root.right, key);
        } else {
            return SearchNode(root.left, key);
        }

    }

    public static Node findIS(Node root) {

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static Node DeleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        // if data of root node is less than key then check for right nodes cuz right
        // nodes contain nodes having greater values in it
        if (root.data < key) {
            root.right = DeleteNode(root.right, key);
        }
        // else if data of root node is greater than key then check for left nodes cuz
        // left nodes contain nodes having smaller values in it

        else if (root.data > key) {
            root.left = DeleteNode(root.left, key);
        }
        // else value of root node is equal to the key value then check below conditions
        else {

            // case 1 -> if left and right nodes of root node are null then return null-> it
            // makes pointer of root node to null
            if (root.left == null && root.right == null) {
                return null;
            }
            // if root has only one child and left of root node is null then return right of
            // the root node cuz it contains some value..... after that the pointer of the
            // previous node points to the root.right node
            else if (root.left == null) {
                return root.right;
            }
            // if root has only one child and right of root node is null then return left of
            // the root node cuz it contains some value..... after that the pointer of the
            // previous node points to the root.left node
            else if (root.right == null) {
                return root.left;
            }
            // else left and right nodes of root have some value then first calculate
            // InorderSuccessor(it is left most child of the right subtree of root node).
            // then replace root date to InorderSuccessor Node data. After that
            else {
                Node IS = findIS(root);
                root.data = IS.data;
                root.right = DeleteNode(root.right, IS.data);
            }
        }

        return root;

    }

    public static void printElementsInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printElementsInRange(root.left, k1, k2);
            System.out.print(root.data);
            printElementsInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printElementsInRange(root.right, k1, k2);
        } else {
            printElementsInRange(root.left, k1, k2);
        }
    }

    public static void printpath(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
        }
        System.out.println();
    }

    public static void pathRtL(Node root, ArrayList<Integer> a) {

        if (root == null) {
            return;
        }

        // first add element in the arrayList
        a.add(root.data);

        if (root.left == null && root.right == null) {
            printpath(a);
        }

        // call for left subtree
        pathRtL(root.left, a);
        // call for right subtree
        pathRtL(root.right, a);
        // backtracking
        a.remove(a.size() - 1);

    }

    public static boolean IsValidBST(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left.data < root.data && root.right.data > root.data) {
            return true;
        }

        // check for the left subtree

        boolean left = IsValidBST(root.left);
        boolean right = IsValidBST(root.right);

        if (left || right) {
            return true;
        }

        return false;

    }

    public static boolean ValidateBST(Node root, Node min, Node max) {

        if (root == null) {
            return true;
        }

        if (min != null && min.data >= root.data) {
            return false;
        }
        else if (max != null && max.data <= root.data) {
            return false;   
        }
        return ValidateBST(root.left, min, root) && ValidateBST(root.right, root, max);
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

    public static Node MirrorBst(Node root)
    {

        if(root == null){
            return root;
        }
        Node temp = root.right;
        root.right = MirrorBst(root.left);
        root.left = MirrorBst(temp);

        return root;
    }

    public static void main(String[] args) {
        // int[] Nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        // Node root = null;

        // for (int i = 0; i < Nodes.length; i++) {
        // root = CreateBST(root, Nodes[i]);
        // }

        // preOrder(root);
        // searching a number in BST
        // System.out.print(SearchNode(root, 3));

        //// ** IMP
        // DeleteNode(root, 4);
        // preOrder(root);
        // int k1 = 5;
        // int k2 = 10;
        // printElementsInRange(root, k1, k2);

        // Find root to leaf path
        // ArrayList<Integer> a = new ArrayList<>();
        // pathRtL(root, a);

        // ** IMP

        // System.out.print(IsValidBST(root));

        // validate Bst

        // Node root = new Node(5);
        // root.left = new Node(3);
        // root.right = new Node(6);
        // root.right.right = new Node(7);
        // root.left.left = new Node(1);
        // root.left.right = new Node(4);

        // System.out.print(ValidateBST(root, null, null));

        // Mirror two Bst
        //      5
        //     / \
        //    3   6
        //   / \   \
        //  7   4   1
        
        // Approach 1 = 
        //  Node root = new Node(5);
        // root.left = new Node(3);
        // root.right = new Node(6);
        // root.right.right = new Node(7);
        // root.left.left = new Node(1);
        // root.left.right = new Node(4);

        // LevelOrder(root);
        // MirrorBst(root);
        // LevelOrder(root);


        

        

    }
}
