package mypackage;

public class LinkedListTwo {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean detectCycle() {
        // slow fast approach
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // if fast = slow then it means cycle exists
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycleExists = true;
                break;
            }
        }
        if (cycleExists == false) {
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;
    }

    public Node mergeSort(Node head) {
        // if linked list is empty or it has only one element
        if (head == null && head.next == null) {
            return head;
        }
        // step-1 find mid of the linked list using fast and slow approach
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // step-2 split main linked list into two small linked lists make left and right
        // part of the linked list
        Node righthead = mid.next;
        mid.next = null;
        // make recursive call for both right and left part
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);
        Node mergell = new Node(-1);

        return merge(newLeft, newRight, mergell);

    }

    // sort and merge
    public Node merge(Node lefthead, Node rightHead, Node mergell) {
        Node temp = mergell;

        while (lefthead != null && rightHead != null) {
            if (lefthead.data < rightHead.data) {
                temp.next = lefthead;
                lefthead = lefthead.next;
                temp = temp.next;
            }
            if (lefthead.data > rightHead.data) {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        // for left over elements in small linked lists
        while (lefthead != null) {
            temp.next = lefthead;
            lefthead = lefthead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergell.next;
    }

    public Node FindMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // .......................................................
    public void ZigZagLL(Node head) {

        // find mid of the linked list
        Node mid = FindMid(head);

        // divide from mid linked lists into two small linked lists
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        // reverse second half of the linked list
        Node curr = rightHead;
        Node next;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        rightHead = prev;

        // alternate merging

        Node nextLeft;
        Node nextRight;

        while (leftHead != null && rightHead != null) {
            nextLeft = leftHead.next;
            nextRight = rightHead.next;
            // adding in zig zag fashion
            leftHead.next = rightHead;
            rightHead.next = nextLeft;
            // updating pointers
            leftHead = nextLeft;
            rightHead = nextRight;

        }
    }
    // ..................................................

    public static int checkMeetingNode(Node List1, Node List2) {
        Node temp1 = List1;
        while (temp1 != null) {
            Node temp2 = List2;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    return temp1.data;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return -1;
        // Time Complexity  : o(m*n)
        // Space Complexity: o(1)
    }

    public void DeleteNafterM(int m, int n) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            int idx1 = 1;
            while (idx1 != m) {
                temp = temp.next;
                idx1++;
            }
            Node prev = temp;
            while (temp != null && idx1 != n + m + 1) {
                temp = temp.next;
                idx1++;
            }
            prev.next = temp;
            // Time Complexity  : o(n)
            // Space Complexity: o(1)
        }
    }

    public void swap(int x, int y) {
        if (x == y) {
            return;
        }
        int idx1 = 1;
        Node temp = head;
        Node prev1 = null;
        Node num1 = null;
        Node num2 = null;
        Node prev2 = null;
        Node next = null;
        if (temp == null) {
            System.out.println("LL is empty");
            return;
        }

        while (temp != null && temp.next != null) {
            if (idx1 == x - 1) {
                prev1 = temp;
                temp = temp.next;
                idx1++;
            } else if (idx1 == x) {
                num1 = temp;
                temp = temp.next;
                idx1++;
            } else if (idx1 == y) {
                num2 = temp;
                temp = temp.next;
                idx1++;
            } else if (idx1 == y - 1) {
                prev2 = temp;
                temp = temp.next;
                idx1++;
            } else if (idx1 == y + 1) {
                next = temp;
                temp = temp.next;
                idx1++;
            } else {
                temp = temp.next;
                idx1++;
            }
            // Time Complexity  : o(n)
            // Space Complexity: o(1)

        }
        // swapping data as below
        // int te = num1.data;
        // num1.data = num2.data;
        // num2.data = te;

        // swapping nodes
        num2.next = num1.next;
        prev1.next = num2;
        num1.next = next;
        prev2.next = num1;
    }

    // public void OddEvenLinkedList(){
    //     Node node = new Node(-1);
    //     Node temp = head;
    //     Node prev = null;
    //     Node curr = null;
    //     Node temp2 = null; 
    //     while (temp != null && temp.next != null) {
    //             if (temp) {
                    
    //             }
                
    //             if(temp.next.data%2 != 0 ){
    //                 prev = temp;
    //                 curr = temp.next;

    //                 prev.next = curr.next;
    //                 temp2 = node;
    //                 while (temp2 != null && temp2.next != null) {
    //                     temp2 = temp2.next;
    //                 }
    //                 temp2.next = curr;
    //                 curr.next = null;
    //             }
    //             temp = temp.next;
    //         }
    //     while(temp!= null && temp.next != null){
    //         temp = temp.next;
            
    //     }
    //        temp.next = node;

    // }

    public static int mergekNode(Node ll1, Node ll2, Node ll3){
        Node dummy = new Node(-1);
        Node temp1 = ll1;
        Node temp2 = ll2;
        Node temp3 = ll3;
        while(temp1 != null && temp2 != null && temp3 != null && temp1.next != null && temp1.next != null && temp1.next != null){

            if (temp1.data < temp2.data && temp1.data<temp3.data) {
                 dummy.next = temp1;
                 temp1 = temp1.next;
                 dummy = dummy.next; 
            }
            if (temp2.data < temp1.data && temp2.data<temp3.data) {
                 dummy.next = temp2;
                 temp2 = temp2.next;
                 dummy = dummy.next; 
            }
            if (temp3.data < temp1.data && temp3.data<temp2.data) {
                 dummy.next = temp3;
                 temp3 = temp3.next;
                 dummy = dummy.next; 
            }
           

        }

        while(temp1 != null && temp2 != null && temp3 != null && temp1.next != null && temp1.next != null && temp1.next != null){
         // for left over elements
         if (temp1 != null && temp2 != null) {
              if (temp1.data < temp2.data) {
                dummy.next = temp1;
                 temp1 = temp1.next;
                 dummy = dummy.next; 
              }  
              if (temp2.data < temp1.data) {
                dummy.next = temp2;
                 temp2 = temp2.next;
                 dummy = dummy.next; 
              }                
         }
         if (temp2 != null && temp3 != null) {
              if (temp2.data < temp3.data) {
                dummy.next = temp2;
                 temp2 = temp2.next;
                 dummy = dummy.next; 
              }  
              if (temp3.data < temp2.data) {
                dummy.next = temp3;
                 temp3 = temp3.next;
                 dummy = dummy.next; 
              }                
         }
         if (temp3 != null && temp1 != null) {
              if (temp1.data < temp3.data) {
                dummy.next = temp1;
                 temp1 = temp1.next;
                 dummy = dummy.next; 
              }  
              if (temp3.data < temp1.data) {
                dummy.next = temp3;
                 temp3 = temp3.next;
                 dummy = dummy.next; 
              }                
         }
        }
        dummy.next = null;
         return dummy.data;
    }

    public static void main(String[] args) {
        LinkedListTwo ll = new LinkedListTwo();
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = head.next;

        // // **IMP detecting cycle code (Floyd's cycle finding algorithm)
        // System.out.println(ll.detectCycle());

        // // **IMP remove cycle from the linked list
        // ll.removeCycle();
        // System.out.println(ll.detectCycle());
        // ll.print();

        // //** IMP */ Merged Sort TC = O(nlogn)
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.print();

        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        // // Zig Zag linked list
        // ll.ZigZagLL(head);
        // ll.print();

        // // Linked List Questions

        // Question 1 :Intersection of Two Linked
        // ListsInasystemtherearetwosinglylinkedlist.Bysomeprogrammingerror,theendnodeofoneofthelinkedlistsgotlinkedtothesecondlist,forminganinvertedY-shapedlist.Writeaprogram
        // to get the point where two linked lists merge.`We have to find the
        // intersection part in this system.

        // Node newNode = new Node(1);
        // newNode.next = new Node (2);
        // newNode.next.next = new Node (3);
        // newNode.next.next.next = new Node (6);
        // newNode.next.next.next.next = new Node (7);
        // newNode.next.next.next.next.next = null;

        // Node newNode2 = new Node(4);
        // newNode2.next = new Node (5);
        // newNode2.next.next = newNode.next.next;

        // System.out.println(checkMeetingNode(newNode,newNode2)
        // );

        // Question 2 :Delete N Nodes After M Nodes of a Linked
        // ListWehavealinkedlistandtwointegersMandN.TraversethelinkedlistsuchthatyouretainMnodesthendeletenextNnodes,continuethesametillendofthelinkedlist.DifficultyLevel:Rookie.Sample
        // Input 1: M=2 N=2 LL: 1->2->3->4->5->6->7->8Sample Output 1: 1->2->5->6Sample
        // Input 2: M=3 N=2 LL: 1->2->3->4->5->6->7->8->9->10Sample Output 2:
        // 1->2->3->6->7->8

        // ll.addFirst(10);
        // ll.addFirst(9);
        // ll.addFirst(8);
        // ll.addFirst(7);
        // ll.addFirst(6);
        // ll.addFirst(5);
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);

        // int m = 3;
        // int n = 2;

        // ll.DeleteNafterM(m,n);
        // ll.print();

        // Question 3 :Swapping Nodes in a Linked List We have a linked list and two
        // keys in it,swap nodes for two given keys.Nodes should be swapped by changing
        // links.Swapping data of nodes may be expensive in many situations when data
        // contains many fields. It may be assumed that all keys in the linked list are
        // distinct.Sample Input 1: 1->2->3->4, x = 2, y = 4 Sample Output 1: 1->4->3->2

        // int idx1 = 2;
        // int idx2 = 4;
        // ll.swap(idx1, idx2);
        // ll.print();

        // Question 4 :Odd Even Linked List We have a LinkedList of integers,write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linkedlist.Also,keep the order of even and odd numbers same.Sample Input 1: 8->12->10->5->4->1->6->NULLSample Output 1: 8->12->10->4->6->5->1->NULLSample Input 2: 1->3->5->7->NULLSample Output 2:1->3->5->7->NULL

        // ll.addFirst(6);
        // ll.addFirst(1);
        // ll.addFirst(3);
        // ll.addFirst(9);
        // ll.addFirst(13);
        // ll.addFirst(5);
        // ll.addFirst(10);
        // ll.addFirst(12);
        // ll.addFirst(8);
        // ll.print();

        // ll.OddEvenLinkedList();
        // ll.print();

        // Question 5 :Merge k Sorted Lists We have K sorted linked lists of size N each, merge them and print the sorted output.Sample Input 1:k = 2, n =  2l1 = 1->3->NULLl2 = 6->8->NULLl3 = 9->10->NULL 
        // Sample Output 1: 1>3->6->8->9->10->NULL

        Node ll1 = new Node(1);
        ll1.next = new Node(3);
        ll1.next.next = null;
        Node ll2 = new Node(6);
        ll2.next = new Node(8);
        ll2.next.next = null;
        Node ll3 = new Node(9);
        ll3.next = new Node(10);
        ll3.next.next = null;
        ll.print();

        System.out.println(mergekNode(ll1,ll2,ll3));
    }
}
