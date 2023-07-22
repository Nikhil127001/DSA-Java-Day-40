package mypackage;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public  Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node  head;
    public static Node tail;

    public void addFirst(int data){
        Node newnode = new Node(data);
        // if the list is empty
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // else add new node
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        newNode.next = null;
    }

    public void removeFirst(){
        head = head.next;
        head.prev = null;
    }

    public void removeLast(){
        tail = tail.prev;
        tail.prev.next = null;
    }

    public void reverse(){
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(0);
        ll.addLast(5);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.removeLast();
        ll.print();
        ll.reverse();
        ll.print();
        
    }
}
