import java.util.ArrayList;

public class BinarySearchTreeB {

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

    public static Node CreateBalancedBST(int arr[], int Si, int Ei) {
        if (Si > Ei) {
            return null;
        }

        // calculate mid
        int mid = (Si + Ei) / 2;
        // create Node root
        Node root = new Node(arr[mid]);
        // make recursive call for left node change the E1 to mid-1 for left node and
        // change Si to mid+1 for right node
        root.left = CreateBalancedBST(arr, Si, mid - 1);
        root.right = CreateBalancedBST(arr, mid + 1, Ei);
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    public static void InOrder(Node root, ArrayList<Integer> a) {

        if (root == null) {
            return;
        }

        InOrder(root.left, a);
        a.add(root.data);
        InOrder(root.right, a);
    }

    public static Node CreateBst(ArrayList<Integer> a, int si, int ei) {
        if (si > ei) {
            return null;
        }

        // calculate mid

        int mid = (si + ei) / 2;
        Node root2 = new Node(a.get(mid));
        // make call for left part and store it in variable
        root2.left = CreateBst(a, si, mid - 1);
        root2.right = CreateBst(a, mid + 1, ei);

        return root2;
    }

    static class Info {
        boolean IsBST;
        int size;
        int max;
        int min;

        public Info(boolean IsBST, int size, int max, int min) {
            this.IsBST = IsBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int MaxSizeVal;

    public static Info LargestSubtree(Node root){
        if(root == null){

            return new Info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        // calculate Info for left
        Info left = LargestSubtree(root.left);

        // calculate Info for right Subtree
        Info right = LargestSubtree(root.right);

        // calculate sizep
        int size = left.size + right.size + 1;
        // calculate max for the root
        int max = Math.max(root.data, Math.max(right.max, left.max));
        // calculate max for the root
        int min = Math.min(root.data,Math.min(right.min, left.min));
        
        // calculate boolean value for the root Node
       
        if( left.max >= root.data || right.min <= root.data){
            return new Info(false, size, max, min);
        }

        // check for IsBST if left.isBst is true And 
        if(left.IsBST && right.IsBST){
            // calculate MaxSize
            MaxSizeVal = Math.max(MaxSizeVal, size);
            return new Info(true, size, max, min);
        }
        

        return new Info(false, size, max, min);

    }

    public static void MergeArray(ArrayList <Integer> a, int Array1[], int Array2[]){
        int i=0;
        int j = 0;

        while(i < Array1.length && j < Array2.length){
            if(Array1[i] <= Array2[j]){
                a.add(Array1[i]);
                i++;
            }
            else{
                a.add(Array2[j]);
                j++;
            }
        }
        // for left over elements in the arrays

        while(i < Array1.length){
            a.add(Array1[i]);
                i++;
        }
        while(j < Array2.length){
            a.add(Array2[j]);
                j++;
        }

    }


    public static Node CreateBalancedBST2(ArrayList <Integer> a , int si, int ei){

        if(si> ei){
            return null;
        }
        // find mid 
        int mid = (si+ei)/2;
        // store value of root in Node variable
        Node root = new Node(a.get(mid));
        // mAKE CALL FOR LEFT pART and store value in  the root ki left Node
        root.left = CreateBalancedBST2(a, si, mid -1);
        root.right = CreateBalancedBST2(a, mid+1, ei);
        return root;
    }

    public static void main(String[] args) {
        // // Sorted array to balanced Binary search tree
        // int Arr[] = { 3, 5, 6, 8, 10, 12, 11 };
        // Node root = CreateBalancedBST(Arr, 0, Arr.length - 1);
        // // function to print it inOrder
        // inOrder(root);

        // Convert BSt to Balanced Bst
        /*
         * Arrroach 1 = convert Bst to Array Sort the Array Then Again Call for
         * CreateBalanced Bst Function
         * it will take O(n) time Complexity and O(n) Space Complexity Because we Are
         * using An additional Array here
         */
        /*
         * Approach 2 = but we are using here Approach 2 Which take O(n) time Complexity
         * But O(1) Space Complexity
         */

        // // Bst is
        // Node root = new Node(8) ;
        // root.left = new Node(6) ;
        // root.left.left = new Node(5) ;
        // root.left.left.left = new Node(3) ;
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // // Step 1 -> convert Bst into sorted Array , by using wellKnown property of
        // bst -> the inorder traversal of Bst is a sorted Sequence

        // ArrayList <Integer> a = new ArrayList<>();
        // InOrder(root, a);
        // for(int i =0; i<a.size(); i++){
        // System.out.println(a.get(i));
        // }

        // // Step -> using this shorted Arraylist create a balanced Bst
        // // this function will return you root node of the Balancedbst
        // Node root3 = CreateBst(a,0, a.size()-1 );
        // // using this node create in order sequence of BST
        // inOrder(root3);

        //// ** IMP size of largest Balancedsubtree in the bst

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.right = new Node(60);
        // root.right.right = new Node(70);
        // root.right.left = new Node(45);
        // root.right.right.right = new Node(80);
        // root.right.right.left = new Node(65);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // LargestSubtree(root);
        // System.out.print(MaxSizeVal);

        // merge two BST
        int BST1[] ={1,2,4};
        int BST2[] ={3,9,12};
        // Combine these Sorted Arrays to form new Array
        ArrayList <Integer> a  = new ArrayList<>();
        MergeArray(a,BST1,BST2);
        // this function will return final root Node
        Node root = CreateBalancedBST2(a, 0, a.size()-1);
        inOrder(root);
          
        

    }
}
