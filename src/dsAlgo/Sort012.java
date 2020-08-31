package dsAlgo;

public class Sort012 {
    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(1);
        Node res = LinkedList.segregate(node);

        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
        System.out.println("");
    }
}

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
class LinkedList
{
    static Node segregate(Node head)
    {
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node curr = head;
        Node curr0 = zero;
        Node curr1 = one;
        Node curr2 = two;

        while (curr != null) {
            Node next = curr.next;

            if (curr.data == 0) {
                curr0.next = curr;
                curr0 = curr0.next;
                curr0.next = null;
            } else if (curr.data == 1) {
                curr1.next = curr;
                curr1 = curr1.next;
                curr1.next = null;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
                curr2.next = null;
            }

            curr = next;
        }

        curr1.next = two.next;
        curr0.next = one.next;

        return zero.next;
    }
}