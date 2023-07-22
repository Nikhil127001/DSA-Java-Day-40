// package mypackage;

// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

// public class TopViewOFBinary {
//       // 1.)first create Node class
//         static class Node{
//             int data;
//             Node next;
//             Node left;
//             Node right;
//              public Node (int data){
//                 this.data = data;
//                 this.left = null;
//                 this.right = null;
//              }
//         }

//         static class Info{
//             Node node;
//             int horizontaldistance;
//             public  Info(Node node, int horizontaldistance){
//                 this.node = node;
//                 this.horizontaldistance = horizontaldistance;
//             }
//         }

//         // function to calculate topView

//         public static void topView(Node root){
//             Queue <Info> q = new LinkedList<>();
//             HashMap <Integer, Node> H = new HashMap<>();

//             int min = 0;
//             int max = 0;

//             q.add(new Info(root
//                 , 0));
//             q.add(null);

//             while(!q.isEmpty()){
//                 Info current = q.remove();
//                 if(current == null){
//                     if(q.isEmpty()){
//                         break;
//                     }
//                     else{
//                         q.add(null);
//                     }
//                 }
//                 else{
//                     // check if the Horizontal distance of node stored in the hashmap is not repeating. if not repating then add it in the hashmap with its node    
//                     if(!H.containsKey(current.horizontaldistance)){
//                         H.put(current.horizontaldistance, current.node);
//                     }          
//                     // then check for the left part
//                     if(current.node.left != null){
//                         q.add(new Info(current.node.left, current.horizontaldistance-1));
//                         min = Math.min(min, current.horizontaldistance-1);
//                     }      
//                     // then check for the left part
//                     if(current.node.right != null){
//                         q.add(new Info(current.node.right, current.horizontaldistance + 1));
//                         max = Math.max(max,current.horizontaldistance + 1);
//                     }     
//                 }
//             }
//             // at last print the data of the node stored in hashmap
//             for(int i = min ; i<=max; i++){
//                 System.out.print(H.get(i).data);
//             }
            
//         }

       

//     public static void main (String args[]){
//         //2.) create BST
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);

//         topView(root);
//     } 
// }



// bottom view of the binary tree
import java.util.*;
import java.util.LinkedList;

public class TopViewOFBinary{
    // first create node class and the node constructor

     static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

        // create the Info class to make Info objects to store into the queue

        static class Info{
            Node node;
            int horizontaldistance;
            public Info(int horizontalDistance, Node node){
                this.node = node;
                this.horizontaldistance = horizontalDistance;
            }
        }
    
    // creating a function to  find topView of the Bimary tree
    // to do this we have to do level order traversal

    public static void topView(Node root){
        Queue <Info> q = new LinkedList<>();
        HashMap <Integer, Node> H = new HashMap<>();
        int max = 0;
        int min = 0;
        q.add(new Info(0,root));
        q.add(null);

        while(!q.isEmpty()){
            // check if the current Info is null
            Info curr = q.remove();
              if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
              }
              else{

                    H.put(curr.horizontaldistance,curr.node);
                
                // check for the left node
                if(curr.node.left != null){
                    q.add(new Info(curr.horizontaldistance-1, curr.node.left));
                    min = Math.min(min,curr.horizontaldistance-1);
                }
                // check for the right node
                if(curr.node.right != null){
                    q.add(new Info(curr.horizontaldistance+1, curr.node.right));
                    max = Math.max(max, curr.horizontaldistance+1);
                }


              }
        }
        // at last print the Nodes

        for(int i =min; i<=max; i++){
            System.out.print(H.get(i).data);
        }
    }

    public static void main(String args[]){

        // create binary tree using Node 
        Node root = new Node(1);
                root.left = new Node(2);
                root.right = new Node(3);
                root.left.left = new Node(4);
                root.left.right = new Node(5);
                root.right.left = new Node(6);
                root.right.right = new Node(7);

        topView(root);

    }
}
