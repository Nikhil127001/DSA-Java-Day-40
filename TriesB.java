public class TriesB {

  // creating nodes for trie
  static class Node {
    Node childrens[] = new Node[26];
    boolean eow = false;

    Node() {// creating all childrens of root as null in the begining
      for (int i = 0; i < childrens.length; i++) {
        childrens[i] = null;
      }
    }
  }

  public static Node root = new Node();

  public static void insert(String str) {// T.C. -> O(L)
    // initialising the root as curr
    Node curr = root;
    // traverse the word and insert it in the arr of Nodes
    for (int level = 0; level < str.length(); level++) {
      int idx = str.charAt(level) - 'a';
      // check ifthe childrens of root contains the char
      if (curr.childrens[idx] == null) {
        // insert
        curr.childrens[idx] = new Node();
      }
      // at last change current
      curr = curr.childrens[idx];
    }
    curr.eow = true;
  }

  public static boolean search(String str) {// T.C. -> O(L)
    // initialising the root as curr
    Node curr = root;
    // traverse the word and insert it in the arr of Nodes
    for (int level = 0; level < str.length(); level++) {
      int idx = str.charAt(level) - 'a';
      // check ifthe childrens of root contains the char
      if (curr.childrens[idx] == null) {
        // return false
        return false;
      }
      // at last change current
      curr = curr.childrens[idx];
    }
    if (curr.eow == true) {
      return true;
    }
    return false;
  }

  public static boolean wordbreak(String str) {
    // base case
    if (str.length() == 0) {
      return true;
    }
    // solving using substring approach
    int i = 0;
    for (int j = 1; j < str.length(); j++) {
      // substring 1
      // String one = str.substring(i,j); // last index element not included
      // String two = str.substring(j); // from j to last of the string
      // search if the substring one is not in the array
      if (search(str.substring(0, j)) && wordbreak(str.substring(j))) {
        return true;
      }
    }
    return false;
  }

  static class Node2 {
    Node2 children[] = new Node2[26];
    boolean eow = false;
    int frequency;

    public Node2() {
      for (int i = 0; i < children.length; i++) {
        children[i] = null;
      }
      frequency = 1;
    }
  }

  // creating root node
  public static Node2 root2 = new Node2();

  // creating function to Insert new child node to the array
  public static void Insert2(String str) {
    // initialising root node as curr
    Node2 curr = root2;
    // treverse the string characters one by one and add them into the trie
    for (int i = 0; i < str.length(); i++) {
      // store first character of the string
      char ch = str.charAt(i);
      // the character place in the childrens array is null then create new node for
      // the element
      if (curr.children[ch - 'a'] == null) {
        curr.children[ch - 'a'] = new Node2();
      } else {
        curr.children[ch - 'a'].frequency++;
      }
      // change curr to children[ch - 'a'] Node
      curr = curr.children[ch - 'a'];
    }
    // and at last change end of eord to true
    curr.eow = true;
  }

  public static void FindUniquePrefix(Node2 root2, String st) {

    // if root is null return -> base case
    if (root2 == null) {
      return;
    }

    if (root2.frequency == 1) {
      System.out.println(st);
      return;
    }

    // check for each node in the path to word end
    for (int i = 0; i < root2.children.length; i++) {
      if (root2.children[i] != null) {
        FindUniquePrefix(root2.children[i], st + (char) (i + 'a'));
      }
    }
  }

  public static boolean searchPrefix(String str) {
    for (int i = 0; i < str.length(); i++) {
      // find current char
      char ch = str.charAt(i);
      if (root2.children[ch - 'a'] == null) {
        return false;
      }
      root2 = root2.children[ch - 'a'];
    }
    return true;
  }

  public static int CountUniqueSubs(Node root) {
    // base case
    if (root == null) {
      return 0;
    }
    int count = 0;
    // check in array if for the non null nodes then count the nodes linked to that
    // perticular non null node
    for (int i = 0; i < 26; i++) {
      if (root.childrens[i] != null) {
        count += CountUniqueSubs(root.childrens[i]);
      }
    }
    // here we want to add the count of self node also
    return count + 1;

  }
  public static String st = "";
  public static void FindLongestString(Node root,String temp){
    if(root == null){
      return;
    }
    for(int i =0; i< 26; i++){
      if(root.childrens[i] != null && root.childrens[i].eow == true){
        temp += (char)(i+'a');
        if(temp.length() > st.length()){
          st = temp;
        }
        FindLongestString(root.childrens[i],temp);
        temp = temp.substring(0,temp.length()-1);

      }
    }
    // back tracking 
  }

  public static void main(String[] args) {
    // String arr[] = {"their", "there", "the", "a", "ask", "thee"};
    // // insert function for the trie
    // for(int i =0; i<arr.length; i++){
    // insert(arr[i]);
    // }
    // // search function for the tree
    // System.out.println(search("their"));
    // System.out.print(search("ther"));

    // //** IMP */ word break problem

    // String arr[] = {"i","like","samsung","mobile","phone"};
    // for(int i =0; i<arr.length; i++){
    // insert(arr[i]);
    // }
    // // creating function to check if the string given is in the arr
    // String str = "ilikesamsung";
    // System.out.print(wordbreak(str));

    // ** IMP prefix problem

    // String arr2[] ={"duck","dog","dove", "zebra"};
    // // first insert elements in trie and then find the unique prifix for each
    // for(int j =0; j< arr2.length; j++){
    // Insert2(arr2[j]);
    // }
    // root2.frequency = -1;
    // FindUniquePrefix(root2,"");

    // // ** searchPrefix Question

    // String arr2[] ={"apple","app","mango","man","woman"};
    // // first insert elements in trie and then find the unique prifix for each
    // for(int j =0; j< arr2.length; j++){
    // Insert2(arr2[j]);
    // }
    // System.out.print(searchPrefix("man")
    // );

    //// ** IMP count unique Substrings

    // String str = "ababa";
    // //find all suffix of the string str and insert it in the string
    // for(int i = 0; i< str.length(); i++){
    // String suffix = str.substring(i);
    // insert(suffix);
    // }
    // // create a function to count all the unique substrings from str
    // System.out.print(CountUniqueSubs(root));

     String arr[] = {"a","banana","ap","app","appl","apple","apply","applys"};
    for(int i =0; i<arr.length; i++){
    insert(arr[i]);
    }
    String str = "";
    FindLongestString(root,str);
    System.out.print(st);
  }
}
