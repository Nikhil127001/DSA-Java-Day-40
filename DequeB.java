package mypackage;
import java.util.*;
import java.lang.Math;
import java.util.LinkedList;

import javax.sound.sampled.SourceDataLine;

import mypackage.DequeB.StackB.QueueX;

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

        
        static class  QueueX{

            static Deque <Integer> q = new LinkedList<>();

            public static boolean isEmpty(){
                return q.isEmpty();
            }
            public static void add(int data){   
                q.addLast(data);
            }

            public static int remove(){
                // empty Queue
                if(q.isEmpty()){
                    System.out.println("Queue is Empty");
                    return -1;
                }
                return q.removeFirst();
            }

            public static int peek(){
                // empty Queue
                if(q.isEmpty()){
                    System.out.println("Queue is Empty");
                    return -1;
                }
                return q.getFirst();
            }
        }

    }

    public static void MaxOfSubarray(Queue<Integer> q, int k){
        Queue <Integer> q2 = new LinkedList<>();
        int i =0;
        
        while(i < k){
            q2.add(q.remove());
            i++;
        }
        while(!q.isEmpty()){
            i = 1;

            int max = q2.remove();
        while(i < k){
            max = Math.max(max, q2.peek());
            q2.add(q2.remove());
            i++;
        }
        System.out.println(max);
        q2.add(q.remove());

        if(q.isEmpty()){
            i = 1;

            max = q2.remove();
        while(i < k){
            max = Math.max(max, q2.peek());
            q2.add(q2.remove());
            i++;
        }
        System.out.println(max);

        }

    }
    }


    public static void ReverseFirstKelements(Deque <Integer> q, int k){
        Stack <Integer> d = new Stack<>();
        int i = 0;
        int size = q.size();
        while(i < k){
            d.push(q.removeFirst());
            i++;
        }

        while(!d.isEmpty()){
            q.addLast(d.pop());
        }
         i =k;
        while(i< size){
            q.addLast(q.removeFirst());
            i++;
        }
        // Time Complexity = O(n);
        // Space Complexity = O(1);
    }

    static class Job{
        int cost;
        int deadline;
        char name;

        Job(char name,int deadline, int cost ){
            this.cost = cost;
            this.name = name;
            this.deadline = deadline;
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

        // // Implementation of stack using Deque
        // StackB s = new StackB();
        // s.push(0);
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()){
        //     System.out.print(s.pop());
        // }

        // // Implementation of Queue using Deque
        //     QueueX d = new QueueX();
        //     d.add(0);
        //     d.add(1);
        //     d.add(2);
        //     d.add(3);

        //     System.out.println(d.isEmpty());
        //     System.out.println(d.peek());

            
        //     while(!d.isEmpty()){
        //         System.out.println(d.remove());
        //     }
        //     System.out.println(d.peek());

        ////Queue Questions
        // Question 5 :Maximum of all subarrays of size kWehaveanarrayarr[]ofsizeNandanintegerK.Findthemaximumforeachandeverycontiguous subarray of size K.Sample Input 1:N=9, K=3 arr= 1 2 3 1 4 5 2 3 6Sample Output 1: 3 3 4 5 5 5 6

        // Queue <Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(1);
        // q.add(4);
        // q.add(5);
        // q.add(2);
        // q.add(3);
        // q.add(6);

        // MaxOfSubarray(q,3);

        // System.out.print(q);

//Question 4 :
// Reversing the first K elements of a Queue
// We have an integer k and a queue of integers, we need to reverse the order of the first k
// elements of the queue, leaving the other elements in the same relative order.
// Sample Input 1 : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] ,k=5
// Sample Output 1 : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]

// Deque <Integer> q = new LinkedList<>();
// q.addLast(10);
// q.addLast(20);
// q.addLast(30);
// q.addLast(40);
// q.addLast(50);
// q.addLast(60);
// q.addLast(70);
// q.addLast(80);
// q.addLast(90);
// q.addLast(100);
// int k = 5;
// ReverseFirstKelements(q,k);
// System.out.print(q);

// Question 3 :
// Job Sequencing Problem
// We have an array of jobs where every job has a deadline and associated profit if the job is
// finished before the deadline. It is also given that every job takes a single unit of time, so the
// minimum possible deadline for any job is 1. Maximize the total profit if only one job can be
// scheduled at a time.
// Sample Input 1 :
// JobID Deadline Profit
// a 4 20
// b 1 10
// c 1 40
// d 1 30
// Sample Output 1 : c, a
ArrayList<Job> arr = new ArrayList<Job>();
arr.add(new Job('a', 2, 100));
arr.add(new Job('b', 1, 19));
arr.add(new Job('c', 2, 27));
arr.add(new Job('d', 1, 25));
arr.add(new Job('e', 3, 15));
for(int i =0; i< arr.size(); i++){
    System.out.print(arr.get(i).name);  
    System.out.print(arr.get(i).deadline);      
    System.out.print(arr.get(i).cost);    
    System.out.println("............................");    


}   

Collections.sort(arr, (a, b) -> {
    return a.deadline-b.deadline;
    });

for(int i =0; i< arr.size(); i++){
    System.out.print(arr.get(i).name);  
    System.out.print(arr.get(i).deadline);      
    System.out.print(arr.get(i).cost);    
    System.out.println();    
}   

}
}
