import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class HeapsA {

    // Comparable Interface implementation in java

    static class Student implements Comparable<Student>{
        int Age;
        int rank;
        public Student(int Age, int Rank){
            this.Age = Age;
            this.rank = Rank;
        }
        @Override

        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    static class Heap{
    public static ArrayList <Integer> a = new ArrayList<>();
    
    public  void add(int data){
        // add element at last of the list
        a.add(data);
       
        // find the index of its child
        int childIdx = a.size()-1;
         // find the index of its parent
         int parentidx = (childIdx-1)/2;
        while(a.get(parentidx) > a.get(childIdx)){// O(logn)
            // swap parent with child
            int childdata = a.get(childIdx);
            a.set(childIdx,a.get(parentidx));
            a.set(parentidx, childdata);
            childIdx = parentidx;
            parentidx = (childIdx-1)/2;
        }
    }
    public int peek(){
        return a.get(0);
    }

    public static void heapify(int i){
        int leftchildidx = 2*i+1;
        int rightchildidx = 2*i+2;
        int minIdx = i;
        // check for left child of the root element 
        if(leftchildidx < a.size() && a.get(minIdx) > a.get(leftchildidx)){
            minIdx = leftchildidx;
        }
        // check for right child of the parent element
        // if the index of right child is less than array.size and right child value is less than parent then change the value of minIdx to the value of right index 
        if(rightchildidx < a.size() && a.get(rightchildidx)<a.get(minIdx) ){
           minIdx = rightchildidx;
        }
        // if there is any change occur in the value of the mid idx then swap the child and the parent

        if(minIdx != i){
            // swap the child and parent
            int temp = a.get(i);
            a.set(i,a.get(minIdx));
            a.set(minIdx,temp);

            // call recursively taking minidx 
            heapify(minIdx);
        }
    }

    public int remove(){  // O(logn)

        int data = a.get(0);
        // step 1 swap the first and last element of the array in order to perforn remove function
        int temp = a.get(0);
        a.set(0,a.get(a.size()-1));
        a.set(a.size()-1,temp);

        // step 2 remove last element from the heap
        a.remove(a.size()-1);

        // step 3 perform heapify method to rearrange the element of the array so that it will obey rules of heap
        heapify(0);

        return data;
    }

    public boolean isEmpty(){
        return a.size() == 0;
    }
    }
    public static void main(String[] args){
        // PriorityQueue <Student> pq = new PriorityQueue<>();
        // pq.add(new Student(1,25));
        // pq.add(new Student(2,5));
        // pq.add(new Student(12,125));
        // pq.add(new Student(12,75));
        // pq.add(new Student(17,1));

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().Age + "with rank "+ pq.peek().rank);
        //     pq.remove();
        // }

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }

    }

}
