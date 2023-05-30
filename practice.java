public class practice {

//   // creating node class for tries and creating its structure
//   static class Node {
//     // creating array of size 26 to store child nodes
//     Node childrens[] = new Node[26];
//     // initialising end of word as false
//     boolean eow = false;

//     // creating constructor for Node class
//     public Node() {
//       // initialising all the children nodes as null
//       for (int i = 0; i < childrens.length; i++) {
//         childrens[i] = null;
//       }
//     }
//   }

//   // creating root node
//   public static Node root = new Node();

//   // creating function to Insert new child node to the array
//   public static void Insert(String str){
//     // initialising root node as curr
//     Node curr = root;
  
//     // treverse the string characters one by one and add them into the trie
//     for(int i =0; i<str.length(); i++){
//         // store first character of the string
//       char ch = str.charAt(i);
//       // the character place in the childrens array is null then create new node for the element
//       if(curr.childrens[ch - 'a'] == null){
//         curr.childrens[ch - 'a'] = new Node();
//       }
//       //change curr to children[ch - 'a'] Node
//         curr = curr.childrens[ch - 'a'];
//     }
//     // and at last change end of eord to true
//     curr.eow = true;
//   }
//   // creating function to search in the trie
//   public static boolean Search(String str){
//     Node curr = root;
//     for(int i = 0; i< str.length(); i++ ){
//       char ch = str.charAt(i);
//       // chreck if the element is not in the children array
//       //or
//       // the children at the index is null then return false
//       if(curr.childrens[ch - 'a'] == null){
//         return false;
//       }
//       curr = curr.childrens[ch - 'a'];
//     }
//     // check if the end of word is true 
//     if(curr.eow == true){
//       return true;
//     }
//     return false;
//   }
//   public static boolean wordbreak(String str){
//     // base case 
//     if(str.length() == 0){
//         return true;
//     }
//     // solving using substring approach
//      for(int j = 1; j< str.length();j++){
//         // substring 1
//     //   String one = str.substring(i,j); // last index element not included 
//     //   String two = str.substring(j); // from j to last of the string
//       // search if the substring one is not in the array
//       if(Search(str.substring(0,j)) && wordbreak(str.substring(j))){
//         return true;
//       }
//      }
//      return false;
// }

// creating Node for prefix problem
 static class Node2 {
  Node2 children[] = new Node2[26];
  boolean eow = false;
  int frequency;
  public Node2(){
    for(int i=0; i< children.length; i++){
      children[i] = null;
    }
    frequency = 1;
  }
 }
  // creating root node
  public static Node2 root = new Node2();

  // creating function to Insert new child node to the array
  public static void Insert2(String str){
    // initialising root node as curr
    Node2 curr = root;
    // treverse the string characters one by one and add them into the trie
    for(int i =0; i<str.length(); i++){
        // store first character of the string
      char ch = str.charAt(i);
      // the character place in the childrens array is null then create new node for the element
      if(curr.children[ch - 'a'] == null){
        curr.children[ch - 'a'] = new Node2();
      }else{
        curr.children[ch - 'a'].frequency++;
      }
      //change curr to children[ch - 'a'] Node
        curr = curr.children[ch - 'a'];
    }
    // and at last change end of eord to true
    curr.eow = true;
  }


  public static void FindUniquePrefix(Node2 root, String st){
    
    // if root is null return -> base case
    if(root == null){
      return;
    }

    if(root.frequency == 1){
      System.out.print(st);
      return;
    }

    // check for each node in the path to word end
    for(int i = 0; i< root.children.length; i++){
      if(root.children[i] != null){
        FindUniquePrefix(root.children[i], st+=(char)(i+'a'));
      }
    }
  }
 


  public static void main(String args[]) {
    // String arr[] = { "the", "their", "there", "add", "tree", "a", "sout" };

    // for (int i = 0; i < arr.length; i++) {
    //   // insert all the elements in the trie one by one
    //   Insert(arr[i]);
    // }
    // System.out.print( Search("sout"));


    //  // word break problem
    //  String arr[] = {"i","like","samsung","mobile","phone"};
    //  for(int i =0; i<arr.length; i++){
    //         Insert(arr[i]);
    //      }
    //  // creating function to check if the string given is in the arr
    //  System.out.print(wordbreak("ilikesamsung"));

     // prefix problem
     String arr[] ={"duck","dog","dove", "zebra"};
      // first insert elements in trie and then find the unique prifix for each
      for(int j =0; j< arr.length; j++){
        Insert2(arr[j]);
       }
       root.frequency = -1;
        FindUniquePrefix(root,"");  
  }
}