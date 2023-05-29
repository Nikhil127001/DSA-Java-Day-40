public class TriesB {

    // creating nodes for trie
    static class Node{
        Node childrens[] = new Node[26];
        boolean eow = false;

        Node(){// creating all childrens of root as null in the begining
            for(int i =0; i< childrens.length; i++){
                childrens[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert(String str){// T.C. -> O(L)
        // initialising the root as curr
        Node curr = root;
        // traverse the word and insert it in the arr of Nodes 
        for(int level = 0; level< str.length(); level++){
            int idx = str.charAt(level) - 'a';
            // check ifthe childrens of root contains the char
            if( curr.childrens[idx] == null){
                // insert
                curr.childrens[idx] = new Node();
            }
            // at last change current
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String str){// T.C. -> O(L)
        // initialising the root as curr
        Node curr = root;
        // traverse the word and insert it in the arr of Nodes 
        for(int level = 0; level< str.length(); level++){
            int idx = str.charAt(level) - 'a';
            // check ifthe childrens of root contains the char
            if( curr.childrens[idx] == null){
                // return false
                return false;
            }
            // at last change current
            curr = curr.childrens[idx];
        }
        if(curr.eow == true){
            return true;
        }
        return false;
    }
    public static void main (String[] args){
     String arr[] = {"their", "there", "the", "a", "ask", "thee"};
    // insert function for the trie
     for(int i =0; i<arr.length; i++){
        insert(arr[i]);
     }
     // search function for the tree
     System.out.println(search("their"));
     System.out.print(search("ther"));
    }
}
