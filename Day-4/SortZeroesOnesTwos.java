class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SortZeroesOnesTwos {
    static Node segregate(Node head) {
        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);
        Node zero = dummyZero;
        Node one = dummyOne;
        Node two = dummyTwo;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                zero.next = new Node(0);
                zero = zero.next;
            }
            else if(temp.data == 1) {
                one.next = new Node(1);
                one = one.next;
            }
            else {
                two.next = new Node(2);
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (dummyOne.next != null) ? dummyOne.next : dummyTwo.next;
        one.next = dummyTwo.next;
        two.next = null;
        head = dummyZero.next;
        return head;
    }
}