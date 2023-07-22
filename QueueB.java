package mypackage;

import javax.sound.sampled.SourceDataLine;

import mypackage.QueueB.QueueD.QueueE;
import mypackage.QueueB.QueueD.stackA;

import java.rmi.Remote;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueB {
    // implementing queue using array
    static class QueueA {
        static int size;
        static int arr[];
        static int rear;

        QueueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // craating is Empty method in the Queue
        public static boolean isEmpty() {
            return rear == -1;
        }

        // craating add method in the Queue
        public static void add(int num) {
            rear = rear + 1;
            arr[rear] = num;
        }

        // craating method to remove an element from the Queue
        public static int remove() {
            int front = arr[0];
            if (isEmpty()) {
                System.out.print("Empty Queue");
                return -1;
            }
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;

            return front;
        }

        // creating a function to print the items in the queue
        public static void print() {
            for (int i = 0; i <= rear; i++) {
                System.out.println(arr[i]);
            }
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.print("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }

    // Implementing circular Queue using Arrays
    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // is empty function in Queue
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // adding element in the queue using arrays

        public static void add(int x) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = x;
        }

        // removing an element from queue;
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int reault = arr[front];
            // last el delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return reault;
        }
    }

    // Implementation of Queues using LinkedList

    static class NOde {
        int size;
        int data;
        NOde next;

        public NOde(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueD {
        static NOde head = null;
        static NOde tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            // adding element at the last
            // if ll is empty
            NOde newNode = new NOde(data);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            NOde temp = head;
            while (temp != tail) {
                temp = temp.next;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.print("ll is empty");
                return -1;
            }

            int data = head.data;
            // single element in the linked list
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;

            }
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.print("ll is empty");
                return -1;
            }

            int data = head.data;
            return data;
        }

        // implementing Queue using two Stacks

        static class QueueE {
            static Stack<Integer> s1 = new Stack<>();
            static Stack<Integer> s2 = new Stack<>();

            // Empty function for Queue
            public static boolean isEmpty() {
                return s1.isEmpty();
            }

            // adding element function for Queue using stack

            public static void add(int data) {
                // if staack s1 && staack s2 is empty

                if (s1.isEmpty()) {
                    s1.push(data);
                    return;
                }
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(data);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }

            // finding peek of the Queue
            public static int peek() {
                if (s1.isEmpty()) {
                    System.out.print("stack is Empty");
                    return -1;
                }
                return s1.peek();
            }

            // removing element from the Queue

            public static int remove() {
                if (s1.isEmpty()) {
                    System.out.print("stack is Empty");
                    return -1;
                }
                return s1.pop();
            }
        }

        // // implementing Stack using two Queues

        static class stackA {
            static Queue<Integer> q1 = new LinkedList<>();
            static Queue<Integer> q2 = new LinkedList<>();

            // isEmpty function in the stack
            public static boolean isEmpty() {
                return q1.isEmpty() && q2.isEmpty();
            }

            // Implementing push function for stack

            public static void push(int data) {
                if (!q1.isEmpty()) {
                    q1.add(data);
                } else {
                    q2.add(data);
                }
            }

            // Implementing add pop function int the stack

            public static int pop() {
                if (isEmpty()) {
                    System.out.println("Stack is Empty");
                    return -1;
                }
                // case 1
                int top = -1;
                if (!q1.isEmpty()) {
                    while (!q1.isEmpty()) {
                        top = q1.remove();
                        if (q1.isEmpty()) {
                            break;
                        }
                        q2.add(top);
                    }
                } else { // case 2
                    while (!q2.isEmpty()) {
                        top = q2.remove();
                        if (q2.isEmpty()) {
                            break;
                        }
                        q1.add(top);
                    }
                }
                return top;
            }

            // Implementing add pop function int the stack

            public static int peek() {
                if (isEmpty()) {
                    System.out.println("Stack is Empty");
                    return -1;
                }
                // case 1
                int top = -1;
                if (!q1.isEmpty()) {
                    while (!q1.isEmpty()) {
                        top = q1.remove();
                        q2.add(top);
                    }
                } else { // case 2
                    while (!q2.isEmpty()) {
                        top = q2.remove();
                        q1.add(top);
                    }
                }
                return top;
            }
        }
    }

    public static void StreamOfChar(String str) {
        char arr[] = new char[26];
        Queue<Character> q = new LinkedList<>();
        // inserting characters in the queue
        int i = 0;
        while (i != str.length()) {
            q.add(str.charAt(i));
            arr[str.charAt(i) - 'a']++;
            i++;
            while (!q.isEmpty() && arr[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void InterleafQueue(Queue<Integer> q){
        Queue <Integer> q2 = new LinkedList<>();
        int i =0;
        int size = q.size();// storing size in new variable becuse for each iteration size will give different values resulting wrong answer
        while(i<(size/2)){
            q2.add(q.remove());
            i++;
        }

        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    public static void QueueReversal(Queue<Integer> q){
        Stack <Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String args[]) {
        // Queue q = new Queue(3);
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // System.out.println(q.isEmpty());
        // q.remove();
        // q.remove();
        // q.print();
        // System.out.println(q.peek());

        // CircularQueue c = new CircularQueue(5);
        // c.add(1);
        // c.add(2);
        // c.add(3);
        // c.add(4);
        // c.add(5);

        // while(!c.isEmpty()){
        // System.out.println(c.remove());
        // }
        // System.out.println(c.isEmpty());

        // QueueD q = new QueueD();
        // q.add(0);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // System.out.println(q.isEmpty());
        // System.out.println("peek is - " + q.peek());

        // while(!q.isEmpty()){
        // System.out.println(q.remove());
        // }
        // System.out.println(q.isEmpty());
        // System.out.println("peek is - " + q.peek());

        // // Implmentation of Queue using JCF

        // Queue <Integer> q = new LinkedList<>();
        // q.add(0);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // System.out.print(q.peek());

        // while(!q.isEmpty()){
        // System.out.print(q.remove());
        // }
        // System.out.print(q.peek());

        // // implementing Queue using two stacks
        // QueueE q = new QueueE();
        // q.add(0);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // System.out.print(q.peek());

        // while(!q.isEmpty()){
        // System.out.print(q.remove());
        // }
        // System.out.print(q.peek());

        // // implementing stack using two queues

        // stackA s = new stackA();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);

        // while(!s.isEmpty()){
        // System.out.print(s.peek());
        // s.pop();
        // }

        // // **IMP */ Find first non repeating char in the stream of character
        // String str = "aabccxb";
        // StreamOfChar(str);

        // // interleafing the queue
        // Queue <Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // InterleafQueue(q);
        // System.out.print(q);


        // // Queue Reversal

        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        QueueReversal(q);
        System.out.print(q);
    }

}
