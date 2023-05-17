package mypackage;

import java.util.*;
import java.util.LinkedList;

public class practice {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node findMid(Node head) {
    Node fast = head;
    Node slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static boolean isPalindrome(Node head) {
    if (head == null || head.next == null) {
      return true;
    }
    Node mid = findMid(head);

    Node curr = mid;
    Node next;
    Node prev = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    Node temp1 = head;
    Node temp2 = prev;

    while (temp2 != null) {
      if (temp2.data != temp1.data) {
        return false;
      }
      temp1 = temp1.next;
      temp2 = temp2.next;
    }
    return true;
  }

  public static void main(String[] args) {
    // LinkedList <Integer> ll = new LinkedList<>();
    // ll.add(0);
    // ll.add(1);
    // ll.add(2);
    // ll.add(3);
    // ll.add(4);
    // System.out.print(ll);

    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(1);
    head.next.next.next = new Node(0);

    System.out.print(isPalindrome(head));

  }
}
