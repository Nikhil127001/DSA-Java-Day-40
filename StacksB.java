package mypackage;

import java.util.*;
import java.util.LinkedList;

public class StacksB {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    static class Stacks {

        // // Stacks implementation using ArrayList
        // static ArrayList<Integer> List = new ArrayList<>();

        // // push Function in Stack using Arraylist

        // public static void push(int data){
        // List.add(data);
        // }

        // // pop element from Stack

        // public static int pop(){
        // if (List.size() == 0) {
        // return -1;
        // }
        // return List.remove(List.size()-1);
        // }
        // // peak element in stack

        // public static int peek(){
        // if (List.size() == 0) {
        // return -1;
        // }
        // return List.get(List.size()-1);
        // }
        // //
        // ......................................................................................
        // // Stacks implementation using LinkedList
        // checking whether the Stack is Empty or Not
        // public static void isEmpty(){
        // if (head == null) {
        // System.out.println("Stack is Empty");
        // }
        // }

        // // pushing node in the linked list
        // public static void push(int data){
        // Node n = new Node(data);
        // n.next = head;
        // head = n;
        // }

        // // poping node from the LinkedList

        // public static int pop(){
        // if (head == null) {
        // return -1;
        // }
        // Node curr = head;
        // head = head.next;
        // return curr.data;
        // }

        // // peek element in the LinkedList

        // public static int peek(){
        // if (head == null) {
        // return -1;
        // }
        // return head.data;
        // }

        // public static void print(){
        // Node temp = head;
        // if(head == null){
        // System.out.println("Stack is Empty");
        // }
        // while(temp != null){
        // System.out.println(temp.data);
        // temp = temp.next;
        // }
        // }
        // //....................................................................
    }

    public static void pushAtBottom(Stack<Integer> s, int i) {
        // base case
        if (s.isEmpty()) {
            s.push(i);
            return;
        }

        // pop the element at peek and store it in top veriable
        int top = s.pop();
        // recursion
        pushAtBottom(s, i);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> c = new Stack<>();
        int i = 0;
        while (i != str.length()) {
            c.push(str.charAt(i));
            i++;
        }
        StringBuilder s = new StringBuilder();
        while (!c.isEmpty()) {
            s.append(c.pop());
        }
        return s.toString();
    }

    public static void reverseAstack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseAstack(s);
        pushAtBottom(s, top);
    }

    public static void StocksSpanProblem(int[] stocks, int[] span) {
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!st.isEmpty() && currPrice >= stocks[st.peek()]) {
                st.pop();

            }
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevhigh = st.peek();
                span[i] = i - prevhigh;
            }
            st.push(i);
        }
    }

    public static void NextGreater(int arr[], int nextgreater[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int currNum = arr[i];

            while (!stack.isEmpty() && currNum > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextgreater[i] = -1;
            } else {
                nextgreater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
    }

    public static boolean IsValidParenthesis(char arr[]) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(' || ch == '{' || ch == ']') {
                stack.push(ch);
            } else {
                if (stack.peek() == '(' && arr[i] == ')' || stack.peek() == '{' && arr[i] == '}'
                        || stack.peek() == '[' && arr[i] == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean CheckDuplicateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                if (count < 1) {
                    return true; // duplicate
                } else {
                    stack.pop();
                }
            } else {
                // opening
                stack.push(ch);
            }
        }

        return false;
    }

   public static int rainWaterTrapped(int heights[]){// T.C. = O(n)
    int TrppedRainWater =0;
    int LeftLargestHeight[] = new int[heights.length];
    int RightLargestHeight[] = new int[heights.length];

    // left largest bar height
    Stack <Integer> st = new Stack<>();
    LeftLargestHeight[0] = heights[0];
    st.push(heights[0]);
    for (int i = 1; i < LeftLargestHeight.length; i++) {
        while (!st.isEmpty() && st.peek() <= heights[i]) {
            st.pop();
        }
        if (st.isEmpty()) {
            LeftLargestHeight[i] = heights[i];
            st.push(heights[i]);

        }
        else{
            LeftLargestHeight[i] = Math.max(st.peek(), heights[i]);
        }
    }
    

    // right Largest Bar Height
    st = new Stack<>();
    RightLargestHeight[RightLargestHeight.length-1] = heights[heights.length-1];
    st.push(heights[heights.length-1]);
    for (int i = RightLargestHeight.length-2; i >= 0; i--) {
        while (!st.isEmpty() && st.peek() <= heights[i]) {
            st.pop();
        }
        if (st.isEmpty()) {
            RightLargestHeight[i] = heights[i];
            st.push(heights[i]);
        }
        else{
            RightLargestHeight[i] = Math.max(st.peek(), heights[i]);
        }
    }


    // calculating Trapped Water  
    for (int i = 0; i < RightLargestHeight.length; i++) {
        TrppedRainWater = TrppedRainWater + (Math.min(LeftLargestHeight[i], RightLargestHeight[i]) - heights[i]);
    }
    return TrppedRainWater;
   
}

public static StringBuilder SimplifyPath(String str){
    StringBuilder st = new StringBuilder();
    Stack <Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
        stack.push(str.charAt(i));
    }

    if(stack.peek() == '/'){
        stack.pop();
    }
    if (stack.peek() == '.') {
        int count = 0;
        while (stack.peek() != '/') {
            stack.pop();
            count++;
        }
        if (count == 1) {
            stack.pop();
        }
        if (count == 2) {
            stack.pop();
            while (stack.peek() != '/') {
                stack.pop();
                count++;
            }
        }
    }
    Stack <Character> st2 = new Stack<>();
    while(!stack.isEmpty()){
        st2.push(stack.pop());
    }

    while (!st2.isEmpty()) {
        st.append(st2.pop());
    }

    return st;
}

public static boolean CheckPalindromeLinkedList(LinkedList<Character> ll){
    Stack <Character> stack = new Stack<>();
    int i = 0;
    boolean ispalin = false;
    while (i != ll.size()) {
        stack.push(ll.get(i));
        i++;
    }
    i = 0;
    System.out.println(ll.size());
    while (i != ll.size()-1) {
        if (stack.pop() == ll.get(i)) {
            ispalin = true;
        }
        else{
            ispalin = false;
        }
        i++;
    }
    return ispalin;
}
       

    public static void main(String[] args) {
        // Stacks s = new Stacks();
        // Implementation of stacks using java collections framework
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // while (!s.isEmpty()){
        // System.out.println(s.pop());
        // }
        // System.out.println(s.peek());
        // s.print(); // this function is not valid in JCF

        // // **IMP push at bottom of the stack

        // pushAtBottom(s,4);
        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // }

        // // **IMP Reverse a string using stack
        // String str = "HellowWorld";
        // System.out.println(reverseString(str));

        // // **IMP reverse a Stack
        // reverseAstack(s);
        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // }

        // // **IMP Stack span Problem

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int[] span = new int[stocks.length];

        // StocksSpanProblem(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i]);
        // }

        // //***MOST IMP Next Greater Element
        // int arr[] = {6,8,0,1,3};
        // int [] nextgreater = new int[arr.length];

        // NextGreater(arr, nextgreater);
        // for (int i = 0; i < nextgreater.length; i++) {
        // System.out.println(nextgreater[i]);
        // }
        // Also implement
        // next Greater Right
        // next Greater Left
        // next smaller Right
        // next smaller Left

        // // **IMP Valid Parenthesis

        /*
         * Given a string s containing just the characters '(',')','{','}','[',']',
         * determine if the input string is valid
         * An input string is valid if:
         * 1. Open brackets must be closed by the same type of brackets.
         * 2. Open brackets must be closed in the correct order.
         * 3. Every close bracket has a corresponding open bracket of the same type.
         */

        // char arr[] = {'(','{','}',')',']'};
        // System.out.println(IsValidParenthesis(arr));

        // **IMP */ duplicate perenthesis

        // Given a balanced expression, find if it contains duplicate parenthesis or
        // not. A set of parenthesis are duplicate if the same subexpression is
        // surrounded by multiple parenthesis.

        // Examples:

        // Below expressions have duplicate parenthesis -
        // ((a+b)+((c+d)))
        // The subexpression "c+d" is surrounded by two
        // pairs of brackets.

        // (((a+(b)))+(c+d))
        // The subexpression "a+(b)" is surrounded by two
        // pairs of brackets.

        // (((a+(b))+c+d))
        // The whole expression is surrounded by two
        // pairs of brackets.

        // ((a+(b))+(c+d))
        // (b) and ((a+(b)) is surrounded by two
        // pairs of brackets but, it will not be counted as duplicate.

        // String str = "((a+b)+((c+d)))";
        // System.out.println(CheckDuplicateParenthesis(str));

        // Stack Questions
        // Trapping Rain Water
        // WehaveanarrayofNnon-negativeintegersarr[]representinganelevationmapwherethewidth
        // of each bar is 1, compute how much water it is able to trap after
        // raining.Note:WehavealreadysolvedthisQuestionusingArraysbutyouhavetonowsolvethisusinga
        // Stack.Sample Input 1:[7 0 4 2 5 0 6 4 0 6]Sample Output 1: 25

        // int heights[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };
        // System.out.println(rainWaterTrapped(heights));

        // Question 2 :Simplify PathWehavaanabsolutepathforafile(Unix-style),simplifyit.Notethatabsolutepathalwaysbeginwith‘/’(rootdirectory),adotinpathrepresentcurrentdirectoryanddoubledotrepresentsparent directory.Sample Input 1: /apnacollege/Sample Output 1: /apnacollegeSample Input 1: /a/..Sample Output 1: /

        // String str = "/a/..";
        // System.out.println(SimplifyPath(str));
         
        // Question 1 :Palindrome Linked ListWehaveasinglylinkedlistofcharacters,writeafunctionthatreturnstrueifthegivenlistisapalindrome, else false.Input: A->B->C->B->AOutput: Yes It is Palindrome

        // LinkedList<Character> ll = new LinkedList<>();
        // ll.addFirst('A');
        // ll.addFirst('D');
        // ll.addFirst('C');
        // ll.addFirst('C');
        // ll.addFirst('D');
        // ll.addFirst('A');

        // System.out.println(CheckPalindromeLinkedList(ll));
    }
}
