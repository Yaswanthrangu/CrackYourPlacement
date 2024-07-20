class ListNode {
    int data;
    ListNode next;
    ListNode (int data) {
        this.data = data;
        this.next = null;
    }
}
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode currnext;
        while(curr != null) {
            currnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currnext;
        }
        return prev;
    }
}