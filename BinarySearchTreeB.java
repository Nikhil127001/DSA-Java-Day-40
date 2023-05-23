public class BinarySearchTreeB {

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
    public static Node createBst(int arr[], int Si, int Ei){
        if(Si > Ei){
            return null;
        }

        // calculate mid
        int mid = (Si+Ei)/2;
        // create Node root
        Node  root = new Node(arr[mid]);
        // make recursive call for left node change the E1 to mid-1 for left node and change Si to mid+1 for right node
        root.left = createBst(arr, Si, mid-1);
        root.right = createBst(arr, mid+1, Ei);
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data);

        inOrder(root.left);
        inOrder(root.right);
    }
    public static void main(String[] args){
        // Sorted array to balanced Binary search tree

        int Arr[] = {3,5,6,8,10,12,11};
        Node root = createBst(Arr, 0, Arr.length-1); 
        inOrder(root);       
    }
}
