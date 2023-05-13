package mypackage;
import java.util.LinkedList;

public class LinkedListUsingJCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(0);
        ll.addFirst(3);

        System.out.println(ll);
        ll.removeFirst();
        ll.removeFirst();
        System.out.println(ll);
    }
}
