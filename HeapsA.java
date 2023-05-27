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

    // creating heap class
    static class Heap{
    public static ArrayList <Integer> a = new ArrayList<>();
    // creating heap functions
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

    // creating heapify method to create maxheap
   
    
    }
    public static void HeapifyMax(int arr[],int i, int size){
        int leftChildIdx = 2*i + 1;
        int rightChildIdx = 2*i+2;
        int maxIDX = i;

        // making conditions for left and right nodes
        if(leftChildIdx <size && arr[leftChildIdx]> arr[maxIDX]){
            maxIDX = leftChildIdx;
        }

        if(rightChildIdx < size && arr[rightChildIdx] > arr[maxIDX]){
            maxIDX = rightChildIdx;
        }

        if(maxIDX != i){
            // swap

            int temp = arr[i];
            //a.set(i, a.get(maxIDX));
            arr[i] = arr[maxIDX];
            // a.set(maxIDX , temp);
            arr[maxIDX] = temp;

            HeapifyMax(arr,maxIDX, size);
        }
    }

    public static void Heapsort(int[] arr){
        int size = arr.length;
        // find all the non leaf nodes
        for(int i = size/2; i>=0; i--){
            HeapifyMax(arr,i, size);
        }

        // now swap root with the last element in the array and then again call to heapifyMax mathod to again convert it into max heap

        for(int i= size-1; i>0; i--){
            // swap largest at first and last element 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // then again call heapifyMax to convert it into max heap again

            HeapifyMax(arr, 0 ,i);
        }

    }

    static class Distance implements Comparable<Distance> {
        int idx;
        int distance;
        public Distance(int idx,int distance){
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance d2){
            return  this.distance-d2.distance;
        }
    }

    
    public static int ConnectNRopes( PriorityQueue <Integer> pq){
        int minCost = 0;
        while(pq.size() > 1){
            // take out first smallest rope from prioprityQueue
        int  rope1 =  pq.remove();
        // take out second smallest rope from prioprityQueue
        int rope2 = pq.remove();
        int sum = rope1 + rope2;
        minCost += sum;
        pq.add(sum);
        }

        return minCost;
    }

    static class prioritySet implements Comparable<prioritySet>{
        int idx;
        int Snum;
        public prioritySet(int idx, int Snum){
            this.idx = idx;
            this.Snum = Snum;
        }

        @Override
        public int compareTo(prioritySet p2){
            return (this.Snum == p2.Snum)? (this.idx - p2.idx) : (this.Snum - p2.Snum);
        }
    }

    static class Info implements Comparable<Info>{
        int data;
        int idx;
        public Info(int data, int idx){
            this.data = data;
            this.idx = idx;
        }

        @Override

        public  int compareTo(Info i2){
            return i2.data - this.data;
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
    
        // Heap h = new Heap();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);
        // h.add(5);
        
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        //** IMP */ heap sort 

        // int[] arr = {1,3,2,4,5,6};
        // Heapsort(arr);

        // for(int i =0 ; i<arr.length; i++){
        //     System.out.print(arr[i]);
        // }

        // we are given N points in a 2D plane which are locations of N cars. If we are at the origin , print the nearest k cars.

        // C0 (3,3)
        // C1 (5,-1)
        // C2 (-2,4)

        // K=2

        // Sol
        // ans = C0 & C2
        // int k = 2;
        // int arr[][] = {{3,3}, {5,-1}, {-2,4}};
        // PriorityQueue <Distance> pq = new PriorityQueue<>();
        // for(int i =0; i<arr.length; i++){
        //     int dis =0;
        //     for(int j = 0; j<arr[0].length; j++){
        //         dis += arr[i][j]*arr[i][j];
        //     }
        //     pq.add(new Distance(i,dis));
            
        // }
        // int i=0;
        // while (i != k){
        //     System.out.println("C"+pq.peek().idx);
        //     pq.remove();
        //     i++;
        // }


        // //Q.) connect n Ropes
        // int ropes[] = {4,3,2,6};

        // // ans = 29
        // PriorityQueue <Integer> pq = new PriorityQueue<>();

        // for(int i = 0; i< ropes.length; i++){
        //     pq.add(ropes[i]);
        // }

        // // Sol
        // System.out.print("The minimum cost required to connect n ropes is : "+ConnectNRopes(pq)
        // );

        // // Weakest Soldier problem
        // int Arr[][] = {{1,0,0,0},
        //                {1,1,1,1},
        //                {1,0,0,0},
        //                {1,0,0,0}
        //             };
        // PriorityQueue <prioritySet> pq = new PriorityQueue<>();
        // for(int i =0; i<Arr.length; i++){
        //     int Count = 0;
        //     for(int j=0; j< Arr[0].length; j++){
        //         if(Arr[i][j]== 1){
        //             Count ++;
        //         }
        //     }
        //     pq.add(new prioritySet(i,Count));

        // }
        // int i = 0;
        // while(i != 2){
        //     System.out.println("R"+pq.peek().idx);
        //     pq.remove();
        //     i++;
        // }
        //** IMP */ Sliding Window Maximum
            // 1,2,3,4,5,6,7,8,9,10
            //windoe Size  k= 3
            // ans = 3,4,5,6,7,8,9,10

        // // Solution 
        // int Arr[] = {1,3,-1,-3,5,3,6,7};
        // int k = 3; // Window Size
        // PriorityQueue <Info> pq = new PriorityQueue<>();
        // ArrayList <Integer> result = new ArrayList<>();
        // // first add k elements to the priority Queue
        // for(int i =0; i<k; i++){
        //     pq.add(new Info(Arr[i], i));
        // }
        // // first add peek of pq  to the result arr at idx 0
        // result.add(0,pq.peek().data);
        // for(int i = k; i<Arr.length; i++){


        //     // while the idx of the peek element of the pq is less and equal to i-k(means it is out of the window) then remove that element.
            
        //     while(pq.peek().data<= i-k){
        //         pq.remove();
        //     }

        //     // add new element from Arr[i] to pq.

        //     pq.add(new Info(Arr[i], i));
        //     result.add(i-k+1,pq.peek().data);

        // }
        // // at the last print all the elements of the ArrayList
        // for(int i=0; i<result.size(); i++){
        //     System.out.print(result.get(i));
        // }
}
}
