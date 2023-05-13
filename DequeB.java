package mypackage;
import java.util.*;
import java.util.LinkedList;

public class DequeB {

    static class StackB{
        static Deque <Integer> deque = new LinkedList<>(); 

        // Implementing push function for Stack using Deque
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
        // Implementing push function for Stack using Deque
        public static void push(int data){
            deque.addLast(data);
        }
        // Implementing pop function for Stack using Deque
        public static int pop(){
            if(isEmpty()){
                System.out.print("Stack is Empty");
                return-1;
            }
            return deque.removeLast();
        }
        // Implementing peek function for Stack using Deque
        public static int peek(){
            if(isEmpty()){
                System.out.print("Stack is Empty");
                return -1;
            }
            return deque.getLast();
        }

    }
    public static void main (String args[]){

        // // Implementaion of Deque using java collections and framework
        // Deque <Integer> deque = new LinkedList<>(); 
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addFirst(3);
        // deque.addLast(4);
        // deque.addLast(5);
        // deque.addLast(6);

        // System.out.println("Getting the first element->"+ deque.getFirst());
        // System.out.println("Getting the first element->"+ deque.getLast());
        // System.out.println(deque);

        // Implementation of stack using Deque
        StackB s = new StackB();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}
