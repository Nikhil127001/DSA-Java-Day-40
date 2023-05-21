
public class BinarySearchTreeA {
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

    public static Node CreateBST(Node root, int n){
        // if root == null then return that root so that we can use it for next iteration
        if(root == null){
            root = new Node(n);
            return root;
        }

        if(root.data > n){
            root.left = CreateBST(root.left, n);
        }

        else{
            root.right = CreateBST(root.right, n);
        }

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        System.out.print(root.data);
        preOrder(root.right);
    }

    public static boolean SearchNode(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data ==  key){
            return true;
        }
        else if( root.data < key){
            return SearchNode(root.right, key);
        }
        else{
            return SearchNode(root.left, key);
        }


    }
   public static void main(String[] args){
    int[] Nodes = {5,1,3,4,2,7};
    Node root = null;

    for(int i=0; i<Nodes.length; i++){
        root = CreateBST(root, Nodes[i]);
    }

    // preOrder(root);
    // searching a number in BST
    System.out.print(SearchNode(root, 3)
    );
   }  
}
