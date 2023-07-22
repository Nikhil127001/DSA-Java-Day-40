package mypackage;

public class LinkedList {
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
    // to find size of a linked list
    public int size;

    public void addFirst(int data) {
        // step 1 create new NOde
        // if there is no node in the linkedList
        Node node = new Node(data);
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }
        // step 2 - newNode next = head
        node.next = head; // Link

        // step 3 = make head newNode
        head = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        // if linked list is empty
        size++;
        if (head == null) {
            head = tail = node;
            return;
        }

        // step 2 tail ka next new node ko point kre
        tail.next = node;

        // step 3 make last node as tail
        tail = node;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public void add(int idx, int data) {
        Node node = new Node(data);
        size++;
        // step 1 to find the previous index of the required index
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void removeFirst() {
        // make head to head.next
        size--;
        head = head.next;

    }

    public void removeLast() {
        // step 1 is to make a node(prev) which points to head
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        // step 2 is to make prev's next to null
        prev.next = null;
        // step 3 is tp make prev as tail
        prev = tail;
        size--;
    }

    public int SearchIterative(int num) {
        Node temp = head;
        int idx = 0;
        // Linear search
        while (temp != null) {
            if (temp.data == num) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }

        return -1;

    }

    public int SearchRecursive(int num, Node temp) {
        if (temp.data == num) {
            return 0;
        }
        if (temp.next == null) {
            return -1;
        }
        int idx = SearchRecursive(num, temp.next);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverse() {
        Node curr = tail = head;
        Node next;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void RemoveNth(int n, int size) {
        Node prev = head;
        Node curr = head;
        int idx = 0;

        // remove first
        if (n == size) {
            head = head.next;
        }

        while (idx != size - n) {
            curr = curr.next;
            idx++;
        }
        idx = 0;
        while (idx != size - n - 1) {
            prev = prev.next;
            idx++;
        }

        prev.next = curr.next;
    }

    public Node findMiddle() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow; // slow is my mid Node
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1 = find mid
        Node mid = findMiddle();

        // Step -2 reverse 2nd half
        Node curr = mid;
        Node next;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node Right = prev;// right half head
        Node Left = head;// left head

        // step -3 -check left half & right half equality
        while (Right != null) {

            if (Left.data != Right.data) {
                return false;
            }
            Right = Right.next;
            Left = Left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2,10);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.removeLast();
        // ll.print();
        // System.out.println("the size of the LinkedList is "+ll.size);

        // // ** IMP to reverse a linked list
        // ll.reverse();
        // ll.print();

        // search (Iterative)
        // Search for a key in a Linked List. Return the position where it is found. If
        // not found return -1
        // System.out.println(ll.SearchIterative(10));
        // System.out.println(ll.SearchIterative(2));
        // System.out.println(ll.SearchRecursive(10,head));

        // //** IMP Find and Remove Nth Node from End
        // RemoveNth(1, ll.size);
        // ll.print();

        // //***IMP */ finding mid using slow-fast technique
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // System.out.println(ll.checkPalindrome());

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

    }
}
